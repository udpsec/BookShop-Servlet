<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/15
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>%
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="info" items="${sessionScope.info}" step="1">
    <span>info</span>
</c:forEach>
<form action="LoginServlet" method="post">

    Username: <input type="text" name="username">
    <br>
    Password: <input type="password" name="password">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</body>
</html>
