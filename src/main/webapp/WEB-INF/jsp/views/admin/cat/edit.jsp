<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa danh mục</div>
			  			</div>
<c:choose>									
			<c:when test="${not empty cat }">				  			
			  			<form action="" method="post" >
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
						<div class="form-group">
											<label for="name">Tên danh mục</label>
											<input  type="text"   value="${cat.cname}" name="cname" class="form-control" >
										</div>
		
									</div>

									<div class="col-sm-6"></div>

									<div class="col-sm-12">
									
									</div>
								</div>

								<hr>
								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Sửa" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
						</form>
			</c:when>
</c:choose>									
										
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->