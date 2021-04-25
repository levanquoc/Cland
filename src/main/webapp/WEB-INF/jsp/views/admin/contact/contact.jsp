<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/WEB-INF/jsp/components/taglib.jsp" %>   
<div class="col-md-10">

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý liên hệ</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					
                	<div class="col-md-4">
                	<form action="" method="get">
                	<div class="input-group form">
                       <input name="searchname"type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <input class="btn btn-primary"  value="Search"type="submit"/>
                       </span>
                  	 </div>
                	
                	</form>
                 	 
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
 <c:choose>
 	<c:when test="${not empty contactList }">
 					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Họ tên</th>
								<th>Email</th>
								<th>Chủ đề</th>
								<th>Nội dung</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${contactList}" var="contact">
						<tr class="odd gradeX">
								<td>${contact.id}</td>
								<td>${contact.name}</td>
								<td>${contact.email}</td>
								<td class="center"> ${contact.subject}</td>
								<td class="center text-center">${contact.content}</td>
								<td class="center text-center">
									
                                    <a href="${pageContext.request.contextPath}/admin/contact/del/${contact.id}"  onclick="return confirm('Bạn có muốn xóa không?')" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
								</td>
							</tr>
						</c:forEach>
							
						
							
							
						</tbody>
					</table>
 	</c:when>
  <c:otherwise>
  
  
  </c:otherwise>
 </c:choose>
  					

					<!-- Pagination -->
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					      <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					    <c:forEach begin="1" end="${numberOfPage }" var="number">
								<li class='<c:if test="${number == currentPage }" >active</c:if>'><a href="${pageContext.request.contextPath}/admin/contact/index/${number}">${number} <span class="sr-only">(current)</span></a></li>
								</c:forEach>
					      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					   </ul>
					</nav>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		  </div>