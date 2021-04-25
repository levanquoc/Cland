<%@page import="edu.vinaenter.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section id="header_area">
	<div class="wrapper header">
		<div class="clearfix header_top">
			<div class="clearfix logo floatleft">
				<a href=""><h1>
						<span>C</span>Land
					</h1></a>
			</div>
			<div class="clearfix search floatright">
				<form action="" method="get">
					<input name="namesearch"  type="text" placeholder="Search" /> <input type="submit" />
				</form>
			</div>
		</div>
		<div class="header_bottom">
			<nav>
				<ul id="nav">
					<li><a href="${pageContext.request.contextPath}/home">Trang
							chủ</a></li>
					<li id="dropdown"><a
						href="${pageContext.request.contextPath}/detail">Bất động sản</a>
						<ul>
							<c:choose>
								<c:when test="${not empty listCat}">
									<c:forEach items="${listCat}" var="cat">
										<li><a href="${pageContext.request.contextPath}/${StringUtil.makeSlug(cat.cname)}/${cat.cid}.html">${cat.cname}</a></li>
									</c:forEach>
								</c:when>
							</c:choose>


						</ul></li>
					<li><a href="${pageContext.request.contextPath}/detail">Giới thiệu</a></li>
					<li><a href="${pageContext.request.contextPath}/contact">Liên hệ</a></li>
				</ul>
			</nav>
		</div>
	</div>
</section>