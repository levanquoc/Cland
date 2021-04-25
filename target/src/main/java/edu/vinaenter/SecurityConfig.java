package edu.vinaenter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource).
		passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery(
						"select username, name from users u inner join roles r on u.roleId = r.id where username= ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/admin/cat/edit/**").access("hasAnyRole('ROLE_ADMIN','ROLE_MOD')")
		.antMatchers("/admin/cat/del/**").access("hasAnyRole('ROLE_ADMIN')")
		.antMatchers("/admin/news/del").access("hasAnyRole('ROLE_ADMIN')")
		.antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN','ROLE_MOD','ROLE_USER')")
		.antMatchers("/").permitAll()
		.and().formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
				.loginPage("/auth/login")
				.loginProcessingUrl("/auth/login")
				.failureUrl("/auth/login?msg=Error")
				.defaultSuccessUrl("/admin/cat/index", false)
				.and()
				.logout()
				.logoutUrl("/auth/logout")
				.logoutSuccessUrl("/auth/logout")
				.and().exceptionHandling()
				.accessDeniedPage("/403").
				and()
				.csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}