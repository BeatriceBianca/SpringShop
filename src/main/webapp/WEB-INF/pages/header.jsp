<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
 
<div class="navbar">
    <div class="container-12">
        <a href="${pageContext.request.contextPath}/"> <img src="images/logo.png" id="logo"/> </a>

        <div class="navbar-list">
        	<c:if test="${pageContext.request.userPrincipal.name == null}">
	            <div class="navbar-item1">
	                <a href="${pageContext.request.contextPath}/newAccount" id="creare-cont"> Creare cont </a>
	            </div>
	            <div class="navbar-item1">
	                <a href="${pageContext.request.contextPath}/login" id="login"> Login </a>
	            </div>
        	</c:if>
        	
        	<c:if test="${pageContext.request.userPrincipal.name != null}">
        		<security:authorize  access="hasAnyRole('MANAGER')">
	        		<div class="navbar-item">
		                <a href="${pageContext.request.contextPath}/newAccount" id="newAccountManager"> Creare cont </a>
		            </div>
	            </security:authorize>
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/profil" id="profil"> Profil </a>
	            </div>
	            <security:authorize  access="hasAnyRole('BUYER')">
		            <div class="navbar-item">
		                <a href="${pageContext.request.contextPath}/cosCurent" id="cos-curent"> Cos curent </a>
		            </div>
		            <div class="navbar-item">
		                <a href="${pageContext.request.contextPath}/favorite" id="favorite"> Favorite </a>
		            </div>
	            </security:authorize>
	            <security:authorize  access="hasAnyRole('SUPPLIER')">
		            <div class="navbar-item">
		                <a href="${pageContext.request.contextPath}/propunereOferta" id="propunereOferta"> Propune oferta </a>
		            </div>
	            </security:authorize>
	            <security:authorize  access="hasAnyRole('MANAGER')">
		            <div class="navbar-item">
		                <a href="${pageContext.request.contextPath}/oferte" id="oferte"> Oferte </a>
		            </div>
	            </security:authorize>
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/logout" id="logout"> Logout </a>
	            </div>
        	</c:if>
        </div>
    </div>
</div>
