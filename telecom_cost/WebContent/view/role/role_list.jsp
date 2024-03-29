﻿ <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <title>角色管理</title>
        <%@ include file="../include/header.jsp" %>
       	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
       	
        <script language="javascript" type="text/javascript">
        function deleteRole(rid) {
            var r = window.confirm("确定要删除此角色吗？");
            //var path = '${pageContext.request.contextPath}';
            if(r) location.href="${pageContext.request.contextPath}/role/deleteRoleAction.do?rid="+rid;
            var msg = '${msg}';
            if(msg==""){
            	$("#operate_result_info").append(msg);
            	$("#operate_result_info").css("display","block");
            }
           // document.getElementById("operate_result_info").style.display = "block";
        }
        
        function updateRole(rid) {
            location.href="${pageContext.request.contextPath}/role/updateShowRoleAction.do?rid="+rid;
        }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <!--Logo区域结束-->
        <!--导航区域开始-->
         <%@ include file="../include/navi.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/role/privListAction.do';" />
                </div>  
                <!--删除的操作提示-->
                 <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath}/assets/images/close.png" onclick="this.parentNode.style.display='none';" />
               
                </div> 
                 <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                             <th>角色图标</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>    
                        <c:forEach items="${roleList}" var="role">
                        <tr>
                            <td>${role.id }</td>
                            <td>${role.rname }</td>
                            <td><img style="width:30px;height:30px;" src="${pageContext.request.contextPath }${role.by001}"/></td>
                            <td>${role.privs }</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="updateRole('${role.id}');"/>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${role.id});" />
                            </td>
                        </tr>
                        </c:forEach>                  
                       
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
