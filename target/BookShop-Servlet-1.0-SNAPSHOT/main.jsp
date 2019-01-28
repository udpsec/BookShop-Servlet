<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/16
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${book}" var="books">
        <tr>
            <td>${books.name}</td>
            <td>${books.price}</td>
            <td>${books.pnum}</td>
            <td>${books.category}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
