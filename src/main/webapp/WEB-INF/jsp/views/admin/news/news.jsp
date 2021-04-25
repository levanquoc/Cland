<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý tin tức</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath}/admin/news/add" class="btn btn-success"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

			</div>
			<div class="col-md-4">
			<form action="" method="get">
				<div class="input-group form">
					<input type="text" class="form-control" name="searchname"placeholder="Search...">
					<span class="input-group-btn">
						<input class="btn btn-primary" value="Search"type="submit"/>
					</span>
				</div>
			
			</form>
			
			</div>
		</div>

		<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0"
					class="table table-striped table-bordered" id="example">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên tin tức</th>
							<th>Danh mục</th>
							<th>Hình ảnh</th>
							<th >Mô tả</th>
							<th >Chi tiết</th>
							<th>Diện tích</th>
							<th>Địa chỉ</th>

							<th width="200px">Chức năng</th>
						</tr>
					</thead>
					<c:choose>
						<c:when test="${not empty newsList }">
							<c:forEach items="${newsList}" var="news">
								<tbody>
									<tr class="odd gradeX">
										<td>${news.lid}</td>
										<td>${news.lname}</td>
										<td>${news.category.cname }</td>
										<td class="center text-center"><img src="${pageContext.request.contextPath}/resources/files/${news.picture}" width="200px" height="200px"/>
										</td>
										<td class="center">${news.description}</td>
										<td class="center">${news.detail}</td>
										<td class="center">${news.area}</td>
										<td class="center">${news.address}</td>

										<td class="center text-center"><a href="${pageContext.request.contextPath}/admin/news/edit/${news.lid}" title=""
											class="btn btn-primary"><span
												class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href="${pageContext.request.contextPath}/admin/news/del/${news.lid}"
										onclick="return confirm('Bạn có muốn xóa không ?')"	title="" class="btn btn-danger"><span
												class="glyphicon glyphicon-trash"></span> Xóa</a></td>
									</tr>

								</tbody>


							</c:forEach>

						</c:when>
						<c:otherwise>
				Không có tin tức nào
	</c:otherwise>

					</c:choose>

				</table>

				<!-- Pagination -->
				<nav class="text-center" aria-label="...">
					<ul class="pagination">
						<li class="disabled"><a href="#" aria-label="Previous"><span
								aria-hidden="true">«</span></a></li>
									<c:forEach begin="1" end="${numberOfPage }" var="number">
								<li class='<c:if test="${number == currentPage }" >active</c:if>'><a href="${pageContext.request.contextPath}/admin/news/index/${number}">${number} <span class="sr-only">(current)</span></a></li>
								</c:forEach>
						
						
						<li><a href="#" aria-label="Next"><span
								aria-hidden="true">»</span></a></li>
					</ul>
				</nav>
				<!-- /.pagination -->

			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.content-box-large -->



</div>