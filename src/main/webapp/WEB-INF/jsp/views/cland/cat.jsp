
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix main_content floatleft">
				
					
					<div class="clearfix content">
						<div class="content_title"><h2>Our Works</h2></div>
						
						<div class="clearfix single_work_container">
							
							<c:choose>
								<c:when test="${not empty newsList}">
									<c:forEach items="${newsList}" var="news">
										<div class="clearfix single_work">
								<img class="img_top" src="${pageContext.request.contextPath}/resources/files/${news.picture}" alt=""/>
								<img class="img_bottom" src="${contextPath}/images/work_bg2.png" alt=""/>
								<h2>${news.lname }</h2>
								<a href=""><p class="caption">${news.description }</p></a>
							</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
								
								</c:otherwise>
							</c:choose>
							
							
							<div class="clearfix work_pagination">
								<nav>
									<a class="newer floatleft" href=""> < -- Trang trước</a>
									<a class="older floatright" href="">Trang kế -- ></a>
								</nav>
							</div>

						</div>
					</div>
					
				</div>