<%--
  Created by IntelliJ IDEA.
  User: Vovchik
  Date: 20.04.2023
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exit</title>
</head>
<body>
<h2>You have completed entering information about the person</h2>
<p>Total records: ${totalRecords}</p>
<c:if test="${not empty person}">
    <h2>Person Details</h2>
    <p>First Name: ${person.name}</p>
    <p>Surname: ${person.surname}</p>
    <p>Email: ${person.email}</p>
    <p>Phone: ${person.phone}</p>
</c:if>

<c:if test="${not empty personList}">
    <h2>All Persons</h2>
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${personList}">
            <tr>
                <td>${p.getName()}</td>
                <td>${p.getSurname()}</td>
                <td>${p.getEmail()}</td>
                <td>${p.getPhone}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
