﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <title>登录</title>
        <link type="text/css" rel="stylesheet" media="all" href="../assets/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../assets/css/global_color.css" /> 
        <script type="text/javascript" src="../assets/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript">
        	$(function(){
        		$("#smit").click(function(){
        			$("#loginForm").submit();
        		})
        	})
        </script>
    </head>
    <body class="index">
        <div class="login_box">
        <form id="loginForm" action="${pageContext.request.contextPath}/admin/LoginAction.do" method="post">
       <%--  <span class="required">${errorMsg}</span> --%>
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="acname" type="text" class="width150" /></td>
                    <td class="login_error_info"><span class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input  name="apwd" type="password" class="width150" /></td>
                    <td><span class="required"></span></td>
                </tr>           
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a id="smit"><img src="../assets/images/login_btn.png" /></a>
                    </td>    
                    <td><span class="required"></span></td>                
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
