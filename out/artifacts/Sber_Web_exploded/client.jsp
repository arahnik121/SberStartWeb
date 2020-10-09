<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SberStartWebApp</title>
    <style>
        a.button24 {
            display: inline-block;
            color: #000000;
            text-decoration: none;
            padding: .5em 2em;
            outline: none;
            border-width: 2px 0;
            border-style: solid none;
            border-color: #80c4f8 #000000 #80c4f8;
            border-radius: 6px;
            background: linear-gradient(#80c4f8, #94bdeb) #94bdeb;
            transition: 0.2s;
        }

        a.button24:hover {
            background: linear-gradient(#5872eb, #80c4f8) #5872eb;
        }

        a.button24:active {
            background: linear-gradient(#80c4f8, #94bdeb) #5872eb;
        }
    </style>

</head>
<h2>Clients:</h2>
<body>

<jsp:useBean id="clientList" scope="request" type="java.util.List"/>
<%--<jsp:useBean id="cardList" scope="request" type="java.util.List"/>--%>
<c:forEach items="${clientList}" var="client">
    <jsp:useBean id="client" type="app.model.Client"/>
        <a href="Sber?id=${client.id}&action=showAccount" class="button24">${client.name} ${client.surname}</a>
</c:forEach>

</body>
</html>
