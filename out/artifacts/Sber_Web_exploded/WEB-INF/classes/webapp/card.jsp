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

        h1 {
            word-spacing: -10px;
            margin-bottom: -26px;
        }

        p {
            letter-spacing: 0em;
            word-spacing: 0px;
        }

        br {
            margin-bottom: -30px;
            letter-spacing: 1em;
            word-spacing: 6px;
        }

        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
            font-size: 14px;
            border-radius: 10px;
            border-spacing: 0;
            text-align: center;
        }

        th {
            background: #5872eb;
            color: #000000;
            padding: 10px 20px;
        }

        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }

        th:first-child, td:first-child {
            text-align: left;
        }

        th:first-child {
            border-top-left-radius: 10px;
        }

        th:last-child {
            border-top-right-radius: 10px;
            border-right: none;
        }

        td {
            padding: 10px 20px;
            background: #80c4f8;
        }

        tr:last-child td:first-child {
            border-radius: 0 0 0 10px;
        }

        tr:last-child td:last-child {
            border-radius: 0 0 10px 0;
        }

        tr td:last-child {
            border-right: none;
        }
    </style>

</head>
<h2>Cards:</h2>
<body>

<table>
    <tr>
        <th>ID</th>
        <th>Номер</th>
        <th>Баланс</th>
    </tr>
    <jsp:useBean id="cardList" scope="request" type="java.util.List"/>
    <c:forEach items="${cardList}" var="card">
    <jsp:useBean id="card" type="app.model.Card"/>
    <tr>
        <td>${card.id}</td>
        <td>${card.number}</td>
        <td>${card.balance}</td>
        </c:forEach>
    </tr>
</table>

<jsp:useBean id="accountId" type="java.lang.String" scope="request"/>
<a href="Sber?id=${accountId}&action=addCard" class="button24">Добавить карту</a>


</body>
</html>
