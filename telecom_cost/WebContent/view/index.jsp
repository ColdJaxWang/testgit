<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <title>向导</title>
        <%@ include file="include/header.jsp" %>
        <script type="text/javascript" src="../assets/js/jquery-3.4.1.min.js"></script>
        
    </head>
    <body class="index">
    	<div id="header" >
		<span
			style="margin: 5px 5px;color: blue; font-size: 15px;font-weight: bold;">${admin.aname}</span>
			<a href="${pageContext.request.contextPath}/user/exitAction.do">【退出】</a>
		</div>
        <!--导航区域开始-->
        <div id="index_navi">
            <ul id="menu">
            	<c:forEach items="${admin.lp}" var="priv">
            	<li><a href = "${pageContext.request.contextPath}${priv.purl}" class="${priv.pclass}_off"></a> </li>
            	</c:forEach>
                
            </ul>
        </div>
    </body>
</html>
