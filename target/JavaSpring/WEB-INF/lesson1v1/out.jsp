<%--
  Created by IntelliJ IDEA.
  User: Vovchik
  Date: 20.04.2023
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Out</title>
</head>
<body>
<p>Person's name: ${person.name}</p>
<p>Person's surname: ${person.surname}</p>
<p>Person's email: ${person.email}</p>
<p>Person's phone: ${person.phone}</p>
<p>The entered data was successfully saved!</p>
<p>Number of entries: ${totalRecords}</p>
<a href="/pass-data">Return to entering personal information</a> or <a href="/exit">complete input</a>
</body>
</html>
