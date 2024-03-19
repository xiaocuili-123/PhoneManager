<%--
  Created by IntelliJ IDEA.
  User: 46212
  Date: 2024/1/9
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加新品牌</title>
    <link rel="stylesheet" type="text/css" href="css/adduser.css"/>
</head>
<body>
<div class="bg">
    <div class="logo lfet"></div>
    <div class="font lfet">
        添加新品牌>>>
    </div>
    <div class="wizard right">
        <form action="${pageContext.request.contextPath}/brand/addBrand">
            <div class="content">
                <div class="col">
                    <div class="form-group">
                        <label class="lfet">品牌名称:</label>
                        <input name="brandName" type="text" class="form-control error inp-bg1 left" value="" style="outline:none;">
                    </div>
                    <div class="bottom" style="text-align: center;">
                        <!-- 这个button也可以提交表单，不需要改成submit -->
                        <button style="text-align: center;">提 交</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
