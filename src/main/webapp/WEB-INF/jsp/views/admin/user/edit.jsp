<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	<div class="row">
		<div class="col-md-12 panel-info">
			<div class="content-box-header panel-heading">
				<div class="panel-title ">Sửa người dùng</div>
			</div>

			<c:choose>
				<c:when test="${not empty user }">
					<form action="" method="post">
						<div class="content-box-large box-with-header">
							<div>
								<div class="row mb-10"></div>

								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="name">Username</label> <input readonly="readonly" type="text"
												value="${user.username }" class="form-control"
												name="username" placeholder="Nhập username">
										</div>
										<div class="form-group">
											<label for="name">Fullname</label> <input type="text"
												value="${user.fullname}" class="form-control"
												name="fullname" placeholder="Nhập fullname">
										</div>
										<div class="form-group">
											<label for="name">Password</label> <input type="password"
												value="${user.password}" class="form-control"
												name="password" placeholder="Nhập password">
										</div>

										<div class="form-group">
											<label>Role</label> <select  name="roleId" class="form-control">

												<c:choose>
													<c:when test="${not empty listRoles}">
														<c:forEach items="${listRoles}" var="roles">
															<c:choose>
																<c:when test="${roles.id==user.roles.id }">
																	<option value="${roles.id}"  selected="selected">${roles.name}</option>

																</c:when>
																<c:otherwise>

																	<option value="${roles.id}">${roles.name}</option>
																</c:otherwise>

															</c:choose>




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
										<input type="submit" value="Sửa" class="btn btn-success" /> <input
											type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
					</form>
				</c:when>
			</c:choose>
		</div>
	</div>
	<!-- /.row col-size -->

</div>
<!-- /.col-md-10 -->