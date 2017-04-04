<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="navbar">
    <div class="container-12">
        <img src="images/logo.png" id="logo"/>

        <div class="navbar-list">
        	<c:if test="${1 == 0}">
	            <div class="navbar-item1">
	                <a href="${pageContext.request.contextPath}/newAccount" id="creare-cont"> Creare cont </a>
	            </div>
	            <div class="navbar-item1">
	                <a href="${pageContext.request.contextPath}/login" id="login"> Login </a>
	            </div>
        	</c:if>
        	
        	<c:if test="${0 == 0}">
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/profil" id="profil"> Profil </a>
	            </div>
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/cosCurent" id="cos-curent"> Cos curent </a>
	            </div>
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/istoric" id="istoric"> Istoric comenzi </a>
	            </div>
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/favorite" id="favorite"> Favorite </a>
	            </div>
	            <div class="navbar-item">
	                <a href="${pageContext.request.contextPath}/logout" id="logout"> Logout </a>
	            </div>
        	</c:if>
        </div>
    </div>
</div>
