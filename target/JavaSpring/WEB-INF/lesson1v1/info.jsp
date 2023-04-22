<%--
  Created by IntelliJ IDEA.
  User: Vovchik
  Date: 20.04.2023
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Info</title>
</head>
<body>
<form method="post" action="/pass-data" modelattribute= ${person}>
    <label for="first-name">Name:</label>
    <input type="text" id="first-name" name="name"><br>

    <label for="last-name">Surname:</label>
    <input type="text" id="last-name" name="surname"><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br>

    <label for="phone">Phone:</label>
    <input type="tel" id="phone" name="phone"><br>

    <button type="submit">Save</button>
</form>
</body>
</html>
