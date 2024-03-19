<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 46212
  Date: 2024/1/5
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>手机管理系统</title>
    <link rel="stylesheet"type="text/css" href="../css/file.css"/>
</head>
<body>
<div class="navbar">
    <div class="container">
        <a class="logo" href="#">手机管理系统</a>
        <nav class="userbar">
            <ul class="cl">
                <li class="lfet">欢迎:</li>
                <li class="lfet">${login.username}</li>
                <li class="lfet"><a href="http://localhost:8080${pageContext.request.contextPath}/login.jsp" style="color: #fff;">退出</a></li>
            </ul>
        </nav>
    </div>
</div>
<div class="article">
    <div class="bor">
        <div class="bg">
					<span class="lfet">
						<a href="http://localhost:8080${pageContext.request.contextPath}/brand/findAllBrand" class="btn btn-primary radius">添加新机</a>
						<a href="http://localhost:8080${pageContext.request.contextPath}/brand/showAllBrand" class="btn btn-primary radius">品牌管理</a>
					</span>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/phone/deletePhones">
                <table class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="25"><input type="submit" class="btn btn-primary radius" value="批量删除"/></th>
                        <th width="80">ID</th>
                        <th width="80">手机名称</th>
                        <th width="80">价格</th>
                        <th width="80">状态</th>
                        <th width="80">品牌</th>
                        <th width="130">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="phone" items="${phoneList}">
                        <tr class="text-c">
                            <td><input type="checkbox" value="${phone.phoneId}" name="ids"></td>
                            <td>${phone.phoneId}</td>
                            <td>${phone.phoneName}</td>
                            <td>${phone.price}</td>
                            <td class="td-status">
                                <c:if test="${phone.state==1}">
                                    <span class="label label-success radius">有货</span>
                                </c:if>
                                <c:if test="${phone.state==0}">
                                    <span class="label label-warning radius">无货</span>
                                </c:if>
                            </td>
                            <td>${phone.brandName}</td>
                            <td class="td-manage">
                                <a style="text-decoration:none" href="http://localhost:8080${pageContext.request.contextPath}/phone/deleteOnePhone?phoneId=${phone.phoneId}">删除</a>
                                <a style="text-decoration:none" href="http://localhost:8080${pageContext.request.contextPath}/phone/findOnePhone?phoneId=${phone.phoneId}">修改</a>
                            </td>
                        </tr>
                    </c:forEach>



<%--                    <tr class="text-c">--%>
<%--                        <td><input type="checkbox" value="1" name=""></td>--%>
<%--                        <td>1</td>--%>
<%--                        <td>iphone7</td>--%>
<%--                        <td>3500</td>--%>
<%--                        <td class="td-status"><span class="label label-success radius">有货</span></td>--%>
<%--                        <td>苹果</td>--%>
<%--                        <td class="td-manage">--%>
<%--                            <a style="text-decoration:none" href="">删除</a>--%>
<%--                            <a style="text-decoration:none" href="updatephone.html">修改</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                    <tr class="text-c">--%>
<%--                        <td><input type="checkbox" value="2" name=""></td>--%>
<%--                        <td>2</td>--%>
<%--                        <td>Mate 20</td>--%>
<%--                        <td>4000</td>--%>
<%--                        <td class="td-status"><span class="label label-warning radius">无货</span></td>--%>
<%--                        <td>华为</td>--%>
<%--                        <td class="td-manage">--%>
<%--                            <a style="text-decoration:none" href="">删除</a>--%>
<%--                            <a style="text-decoration:none" href="updatephone.html">修改</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
                    </tbody>
                </table>
            </form>
        </div>
<%--        <div class="dataTables_info" id="DataTables_info">当前是第1页 ，共 3页</div>--%>
<%--        <div class="dataTables_paginate" id="DataTables_paginate">--%>
<%--            <a class="paginate_button" id="previous">上一页</a>--%>
<%--            <a class="paginate_button" id="next">下一页</a>--%>
<%--        </div>--%>
    </div>
</div>
</body>
</html>