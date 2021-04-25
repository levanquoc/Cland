<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- header -->
<div class="login-wrapper">
			        <div class="box">
			            <div class="content-wrap">
			            	<img width="100px" height="100px" class="img-circle" src="${contextPath}/images/icon-180x180.png">
			                <h6>Đăng nhập</h6>
			<form action="${pageContext.request.contextPath}/auth/login" method="post">
			
			  <div class="form-group">
			                	<label class="text-left pull-left" for="username">Tên đăng nhập</label>
			               		<input class="form-control" name="username"type="text" placeholder="Username">
			                </div>
			                
			                <div class="form-group">
			                	<label class="text-left pull-left" for="password">Mật khẩu</label>
			                	<input class="form-control" name="password" type="password" placeholder="Password">
			                </div>
			                
			                <div class="action">
			                    <input value="submit" class="btn btn-primary signup btn-block" type="submit">
			                </div>
			
			
			</form>                
			                              
			            </div>
			        </div>

			        <div class="already">
			            <p>Don't have an account yet?</p>
			            <a href="javascript:void(0)">Sign Up</a>
			        </div>
			    </div>