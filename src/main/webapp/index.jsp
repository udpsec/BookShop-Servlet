<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String APP_PATH = pageContext.getServletContext().getContextPath();%>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function imgrestore() {
        var imgtag = document.getElementById("verfi");
        // 加上Date时间可以换验证码否则都是请求同一个验证码
        imgtag.src = "/ServletProject_war_exploded/CapthaServlet?" + new Date().getTime();
    }
</script>
<body>
${sessionScope.info}
<form action="LoginServlet" method="post">

    Username: <input type="text" name="username">
    <br>
    Password: <input type="password" name="password">
    <br>
    验证码:<input type="text">
    <img src="/ServletProject_war_exploded/CapthaServlet" align="verification" id="verfi">
    <a href="javascript:imgrestore();">看不清？换个验证码</a><br>
    <input type="submit" value="Login">
</form>
</body>
</body>
</html>
