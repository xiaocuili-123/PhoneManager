<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 46212
  Date: 2024/1/8
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改手机</title>
    <link rel="stylesheet" type="text/css" href="../css/adduser.css"/>
</head>
<body>
<div class="bg">
    <div class="logo lfet"></div>
    <div class="font lfet">
        修改手机>>>
    </div>
    <div class="wizard right">
        <form action="${pageContext.request.contextPath}/phone/updatePhone">
            <div class="content">
                <div class="col">
                    <input name="phoneId" value="${phone.phoneId}" hidden>
                    <div class="form-group">
                        <label class="lfet">手机名称:</label>
                        <input name="phoneName" type="text" class="form-control error inp-bg1 left" value="${phone.phoneName}" style="outline:none;">
                    </div>
                    <div class="form-group">
                        <label style="text-align: left;">是否有货:</label>
                        <input type="radio" style="outline:none;" value="1" name="state"
                        <c:if test="${phone.state==1}">
                               checked="checked"
                        </c:if>

                        ><span>有货</span>
                        <input type="radio" style="outline:none;" value="0" name="state"
                        <c:if test="${phone.state==0}">
                               checked="checked"
                        </c:if>

                        ><span>无货</span>
                    </div>
                    <div class="form-group">
                        <label class="lfet">价格:</label>
                        <input type="text" class="form-control error dh" style="outline:none;" name="price" value="${phone.price}">
                    </div>
                    <div class="form-group">
                        <label class="lfet">品牌:</label>
                        <select name="brandId"  class="form-control error map" style="outline:none;height: 30px;width: 300px;" >
                            <c:forEach var="brand" items="${brandList}">
                                <option value="${brand.brandId}"
                                        <c:if test="${phone.brandId==brand.brandId}">
                                            selected
                                        </c:if>
                                >${brand.brandName}</option>
                            </c:forEach>
                            <%--  <option>华为</option>
                              <option>苹果</option>--%>
                            <option>OPPO</option>
                        </select>
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