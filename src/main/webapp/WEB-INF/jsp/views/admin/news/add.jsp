<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm tin tức</div>
			  			</div>
<form action="" method="post" enctype="multipart/form-data">			  			
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="name">Tên truyện</label>
											<input name="lname"type="text" class="form-control" placeholder="Nhập tên truyện">
										</div>
										
										<div class="form-group">

											<label>Danh mục truyện</label>
											<select name="category.cid" class="form-control">
											
<c:choose>		
	<c:when test="${not empty listCat}">	
	<c:forEach items="${listCat}" var="cat">					
											   <option value="${cat.cid}">${cat.cname}</option>
											   
		</c:forEach>	
	 </c:when>
</c:choose>											   
											</select>
										</div>

										<div class="form-group">
											<label>Thêm hình ảnh</label>
											<input  name="file" type="file" class="btn btn-default" id="exampleInputFile1">
											<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
											
										</div>
										<div class="form-group">
										   <label>Diện tích</label>
										   <textarea name="area"class="form-control" ></textarea>
										</div>
										<div class="form-group">
										   <label>Địa chỉ</label>
										   <textarea name="address"class="form-control" rows="3"></textarea>
										</div>
										<div class="form-group">
										   <label>Mô tả</label>
										   <textarea name="description" class="form-control" rows="3"></textarea>
										</div>

										
									</div>

									<div class="col-sm-6"></div>

									<div class="col-sm-12">
										<div class="form-group">
										   <label>Chi tiết</label>
										   <textarea name="detail" class="form-control" rows="7"></textarea>
										  
										</div>
									</div>
								</div>

								<hr>

								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Thêm" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
</form>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->