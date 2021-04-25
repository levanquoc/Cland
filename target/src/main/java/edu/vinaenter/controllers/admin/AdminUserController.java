package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.dao.RolesDao;
import edu.vinaenter.model.Roles;
import edu.vinaenter.model.User;
import edu.vinaenter.service.UserService;
import edu.vinaenter.util.PageUitl;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_USER)
public class AdminUserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RolesDao rolesDao;
	@Autowired
	MessageSource messageSource;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE})
	public String index(ModelMap model,@PathVariable(required = false) Integer page,@RequestParam(required = false) String searchname) {
		int offset=PageUitl.getOffset(page);
		int totalRow=userService.getTotalRow();
		int numberOfPage=PageUitl.getTotalPage(totalRow);
		model.addAttribute("currentPage", page);
		model.addAttribute("numberOfPage",numberOfPage);
		if (searchname==null){
			List<User> userList = userService.getAll(offset,GlobalConstant.TOTAL_ROW);
			model.addAttribute("userList", userList);
			return "admin.user.index";
		}
		List<User> userList = userService.getAll(offset,GlobalConstant.TOTAL_ROW,searchname);
		model.addAttribute("userList", userList);
		return "admin.user.index";
	}

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap model) {
		List<Roles> listRoles = rolesDao.getAll();
		model.addAttribute("listRoles", listRoles);
		return "admin.user.add";
	}

	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute  User user,BindingResult rs ,RedirectAttributes rd, ModelMap model) {		
		
		if(rs.hasErrors()) {
			model.addAttribute("listRoles",rolesDao.getAll());
			return "admin.user.add";
		}
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		if (userService.save(user) > 0) {

			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		return "";
	}
	@GetMapping(URLConstant.DELETE)
	public String del(@PathVariable("id") int id) {
		if(userService.del(id)>0) {
			return "redirect:/admin/user/index";
		}
		return "";
	}
	@GetMapping(URLConstant.EDIT)
	public String edit(@PathVariable("id") int id,ModelMap model) {
		List<Roles> listRoles=rolesDao.getAll();
		model.addAttribute("listRoles", listRoles);
		User user=userService.findById(id);
		model.addAttribute("user", user);
		return "admin.user.edit";
	}
	@PostMapping(URLConstant.EDIT)
	public String edit(@ModelAttribute("user") User user,@RequestParam("roleId") int roleId,RedirectAttributes rd) {
		user.setRoles(new Roles(roleId,null));
		User userOld=userService.findById(user.getId());
		if("".equals(user.getPassword())) {
			user.setPassword(userOld.getPassword());
		}
				
		if(userService.update(user)>0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		
	
		return "";
	}

}
