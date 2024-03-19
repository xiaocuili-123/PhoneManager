<%--
  Created by IntelliJ IDEA.
  User: 46212
  Date: 2024/1/10
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>手机商城后台注册</title>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
<div class="bg">
    <div class="logo lfet"></div>
    <div class="font lfet">用户注册>>></div>
    <div class="wizard right">
        <div class="wizard-header">
            <h3>Phone Manger System</h3>
        </div>
        <form action="${pageContext.request.contextPath}/user/register" method="post">
            <div class="content">
                <div class="col">
                    <div class="form-group">
                        <label class="lfet">用户名</label>
                        <input  name="username" type="text" class="form-control error inp-bg1"  style="outline: none;">
                    </div>
                    <div class="form-group">
                        <label class="lfet">密码</label>
                        <input name="password1" type="password"  class="form-control error mminp" style="outline: none;">
                    </div>
                    <div class="form-group">
                        <label class="lfet">确认密码</label>
                        <input name="password2" type="password"  class="form-control error mminp" style="outline: none;">
                    </div>
                    <div class="bottom" style="text-align: center;">
                        <!-- 这个button也可以提交表单，不需要改成submit -->
                        <button style="text-align: center;">Register</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>