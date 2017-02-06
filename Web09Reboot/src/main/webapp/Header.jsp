<%-- 메뉴 추가 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
SPMS(Simple Project Management System)

<span style="float:right;">
<a style="color:white;" 
  href="<%=request.getContextPath()%>/project/list">프로젝트</a>
<a style="color:white;" 
  href="<%=request.getContextPath()%>/member/list">회원</a>  

<c:if test="${empty sessionScope.member or 
              empty sessionScope.member.email}">
<a style="color:white;" 
  href="<%=request.getContextPath()%>/auth/loginForm">로그인</a>
</c:if>  
            
<c:if test="${!empty sessionScope.member and 
              !empty sessionScope.member.email}">
${sessionScope.member.name}
(<a style="color:white;" 
  href="<%=request.getContextPath()%>/auth/logout">로그아웃</a>)
</c:if>

</span>
</div>