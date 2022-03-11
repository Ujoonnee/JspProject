<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="amado-nav">
	<ul style="text-align: center;">
		<!-- 
=======
	<!-- 
>>>>>>> branch 'main' of https://github.com/Ujoonnee/JspProject.git
		<li><a href="#" class="search-nav"><img
				src="img/core-img/search.png" alt=""> Search</a></li>
		<li>&nbsp;</li>
		 -->
		<li><a href="myPage.do">회원정보수정</a></li>
		<li><a href="qnaList.do">1:1 문의</a></li>
		<c:if test="${user.userAuthority eq 'admin'}">
			<li><a href="productInsertForm.do">상품 등록</a></li>
		</c:if>
	</ul>
</nav>
