<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/components/taglib.jsp" %>   
<div class="col-md-10">

	<div class="content-box-large">
		<div class="row">
			<div class="panel-heading">
				<div class="panel-title ">Quản lý danh mục</div>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-md-8">
				<a href="${pageContext.request.contextPath}/admin/cat/add" class="btn btn-success"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

			</div>
			<div class="col-md-4">
			<form action="" method="get">
				<div class="input-group form">
					<input type="text" class="form-control" name="searchname" placeholder="Search...">
					<span class="input-group-btn">
						<input class="btn btn-primary"  value="Search" type="submit">
					</span>
				</div>
				</form>
			</div>
		</div>
<c:choose>
<c:when test="${not empty catList }">
		<div class="row">
			<div class="panel-body">
				<table cellpadding="0" cellspacing="0" border="0"
					class="table table-striped table-bordered" id="example">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tên</th>
							
							<th>Chức năng</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${catList}" var="item" >
						<tr class="odd gradeX">
							<td>${item.cid}</td>
							<td>${item.cname}</td>
							

							<td class="center text-center"><a href="${pageContext.request.contextPath}/admin/cat/edit/${item.cid}" title=""
								class="btn btn-primary"><span
									class="glyphicon glyphicon-pencil "></span> Sửa</a> <a href="${pageContext.request.contextPath}/admin/cat/del/${item.cid}"
								title="" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không?')" ><span
									class="glyphicon glyphicon-trash" ></span> Xóa</a></td>
						</tr>

					</c:forEach>

					</tbody>
				</table>
				
				</c:when>
</c:choose>
				<!-- Pagination -->
				<nav class="text-center" aria-label="...">
					<ul class="pagination">
						<li class="disabled"><a href="#" aria-label="Previous"><span
								aria-hidden="true">«</span></a></li>
						<c:forEach begin="1" end="${numberOfPage }" var="number">
								<li class='<c:if test="${number == currentPage }" >active</c:if>'><a href="${pageContext.request.contextPath}/admin/cat/index/${number}">${number} <span class="sr-only">(current)</span></a></li>
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