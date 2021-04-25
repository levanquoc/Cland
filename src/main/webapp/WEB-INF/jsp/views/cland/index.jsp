
<%@page import="edu.vinaenter.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix main_content floatleft">
				
					<div class="clearfix slider">
						<ul class="pgwSlider">
							<li><img src="${contextPath}/images/thumbs/megamind_07.jpg" alt="Paris, France" data-description="Eiffel Tower and Champ de Mars" data-large-src="${contextPath}/images/slides/megamind_07.jpg"/></li>
							<li><img src="${contextPath}/images/thumbs/wall-e.jpg" alt="Montréal, QC, Canada" data-large-src="${contextPath}/images/slides/wall-e.jpg" data-description="Eiffel Tower and Champ de Mars"/></li>
							<li>
								<img src="${contextPath}/images/thumbs/up-official-trailer-fake.jpg" alt="Shanghai, China" data-large-src="${contextPath}/images/slides/up-official-trailer-fake.jpg" data-description="Shanghai ,chaina">
							</li>


						</ul>
					</div>
					
					<div class="clearfix content">
						<div class="content_title"><h2>Bài viết mới</h2></div>
					
						
<c:choose>
	<c:when test="${not empty newsList }">
	
	<c:forEach items="${newsList}" var="news">
			<div class="clearfix single_content">
							<div class="clearfix post_date floatleft">
								<div class="date">
									<h3>27</h3>
									<p>Tháng 3</p>
								</div>
							</div>
							<div class="clearfix post_detail">
								<h2><a href="${pageContext.request.contextPath}/detail/${StringUtil.makeSlug(news.category.cname)}/${StringUtil.makeSlug(news.lname)}/${news.lid}.html">${news.lname} </a></h2>
								<div class="clearfix post-meta">
									<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${news.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${news.area}m2</span></p>
								</div>
								<div class="clearfix post_excerpt">
									<img src="${pageContext.request.contextPath}/resources/files/${news.picture}" alt=""/>
									<p>${news.description} </p>
								</div>
								<a href="">Đọc thêm</a>
							</div>
						</div>
	
	</c:forEach>	
	</c:when>
	<c:otherwise>
	
	
	</c:otherwise>
</c:choose>				
						
						
											
					</div>
					
					<div class="pagination">
						<nav>
							<ul>
							
								<li><a href=""> << </a></li>
								<c:forEach begin="1" end="${numberOfpage}" var="number">
										<li><a  href="${pageContext.request.contextPath}/home/${number}">${number}</a></li>
							</c:forEach>
								
								
								<li><a href=""> >> </a></li>
							</ul>
						</nav>
					</div>
				</div>