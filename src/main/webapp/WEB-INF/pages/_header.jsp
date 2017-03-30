<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div class="header-container">
 
    <img src="${pageContext.request.contextPath}/images/logo.png" />
 
    <div class="header-bar">
        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
        Hello
           <a href="${pageContext.request.contextPath}/accountInfo">
                ${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </c:if>
        
        <c:if test="${pageContext.request.userPrincipal.name == null}">
        	<a href="${pageContext.request.contextPath}/newAccount">Creare Cont</a>
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
    </div>
</div>