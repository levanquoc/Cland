<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý người dùng</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath}/admin/user/add"
					class="btn btn-success"><span class="glyphicon glyphicon-plus"
					aria-hidden="true"></span>&nbsp;Thêm</a>

			</div>



			<div class="col-md-4">

				<form action="" method="get">
					<div class="input-group form">

						<input type="text" class="form-control" name="searchname"
							placeholder="Search..."> <span class="input-group-btn"><input
							class="btn btn-primary" value="Search" type="submit" /></span>

					</div>
				</form>

			</div>
		</div>
		<c:choose>
			<c:when test="${not empty userList }">
				<div class="row">
					<div class="panel-body">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table table-striped table-bordered" id="example">
							<thead>
								<tr>
									<th>ID</th>
									<th>Username</th>
									<th>Fullname</th>
									<th>Roles</th>
									<th>Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userList}" var="user">
									<tr class="odd gradeX">
										<td>${user.id }</td>
										<td>${user.username}</td>
										<td>${user.fullname}</td>
										<td>${user.roles.name}</td>

										<td class="center text-center"><a
											href="${pageContext.request.contextPath}/admin/user/edit/${user.id}"
											title="" class="btn btn-primary"><span
												class="glyphicon glyphicon-pencil "></span> Sửa</a> <a
											href="${pageContext.request.contextPath}/admin/user/del/${user.id}"
											onclick="return confirm('Bạn có muốn xóa không?')" title=""
											class="btn btn-danger"><span
												class="glyphicon glyphicon-trash"></span> Xóa</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- Pagination -->
						<nav class="text-center" aria-label="...">
							<ul class="pagination">
								<li class="disabled"><a href="#" aria-label="Previous"><span
										aria-hidden="true">«</span></a></li>
								<c:forEach begin="1" end="${numberOfPage }" var="number">
								<li class='<c:if test="${number == currentPage }" >active</c:if>'><a href="${pageContext.request.contextPath}/admin/user/index/${number}">${number} <span class="sr-only">(current)</span></a></li>
								</c:forEach>		
								
								
								
								<li><a href="#" aria-label="Next"><span
										aria-hidden="true">»</span></a></li>
							</ul>
						</nav>
						<!-- /.pagination -->

					</div>
				</div>
				<!-- /.row -->

			</c:when>
		</c:choose>
	</div>
	<!-- /.content-box-large -->



</div>