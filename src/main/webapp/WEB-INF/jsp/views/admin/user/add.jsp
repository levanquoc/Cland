<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Thêm người dùng</div>
			</div>
			<form action="" method="post">
				<div class="content-box-large box-with-header">
					<div>
						<div class="row mb-10"></div>

						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="name">Username</label> <input type="text"
										class="form-control" name="username"
										placeholder="Nhập username">
										<form:errors path="user.username"></form:errors>
								</div>
								<div class="form-group">
									<label for="name">Fullname</label> <input type="text"
										class="form-control" name="fullname"
										placeholder="Nhập fullname">
								</div>
								<div class="form-group">
									<label for="name">Password</label> <input type="password"
										class="form-control" name="password"
										placeholder="Nhập password">
								</div>

								<div class="form-group">
									<label>Role</label> <select name="roles.id" class="form-control">

										<c:choose>
											<c:when test="${not empty listRoles}">
												<c:forEach items="${listRoles}" var="roles">
													<option value="${roles.id}">${roles.name}</option>

												</c:forEach>
											</c:when>
										</c:choose>
									</select>
								</div>






							</div>

							<div class="col-sm-6"></div>


						</div>

						<hr>

						<div class="row">
							<div class="col-sm-12">
								<input type="submit" value="Thêm" class="btn btn-success" /> <input
									type="reset" value="Nhập lại" class="btn btn-default" />
							</div>
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /.row col-size -->

</div>
<!-- /.col-md-10 -->