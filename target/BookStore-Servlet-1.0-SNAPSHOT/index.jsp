<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function imgrestore() {
        var imgtag = document.getElementById("verfi");
        // 加上Date时间可以换验证码否则都是请求同一个验证码
        imgtag.src = "${APP_PATH}/verifyServlet?" + new Date().getTime();
    }
</script>
<body>
${sessionScope.info}
<form action="LoginServlet" method="post">

    Username: <input type="text" name="username">
    <br>
    Password: <input type="password" name="password">
    <br>
    <input type="checkbox" name="remember" value="">记住用户名<br>
    验证码:<input type="text" name="verify_code">
    <img src="${APP_PATH}/verifyServlet" id="verfi">
    <a href="javascript:imgrestore();">看不清？换个验证码</a><br>
    <input type="submit" value="Login">
</form>
</body>
</body>
</html>
