<%--
  Created by IntelliJ IDEA.
  User: Arahnik
  Date: 09.10.2020
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="id" type="java.lang.String" scope="request"/>
<jsp:useBean id="outerId" type="java.lang.String" scope="request"/>
<form method="post" action="Sber" enctype="application/x-www-form-urlencoded">
    <input type="hidden" name="id" value="${id}">
    <input type="hidden" name="outerId" value="${outerId}">
    <input type="text" name="number" size="30" value="">
    <input type="text" name="balance" size="30" value="">
    <button type="submit">Сохранить</button>
    <button onclick="window.history.back()">Отменить</button>
</form>

</body>
</html>
