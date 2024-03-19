<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 46212
  Date: 2024/1/9
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li class="lfet"><a href="" style="color: #fff;">退出</a></li>
            </ul>
        </nav>
    </div>
</div>
<div class="article">
    <div class="bor">
        <div class="bg">
					<span class="lfet">
						<a href="http://localhost:8080${pageContext.request.contextPath}/addBrand.jsp" class="btn btn-primary radius">添加品牌</a>
						<a href="http://localhost:8080${pageContext.request.contextPath}/phone/showAllPhone" class="btn btn-primary radius">手机管理</a>
					</span>
        </div>
        <div>
            <form action="">
                <table class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="80">ID</th>
                        <th width="80">品牌名称</th>
                        <th width="80">该品牌下手机数量</th>
                        <th width="130">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="brand" items="${brandList}">
                        <tr class="text-c">
                            <td>${brand.brandId}</td>
                            <td>${brand.brandName}</td>
                            <td>${brand.phoneNum}</td>
                            <td class="td-manage">
                                <a style="text-decoration:none" href="http://localhost:8080${pageContext.request.contextPath}/brand/deleteBrand?brandId=${brand.brandId}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>