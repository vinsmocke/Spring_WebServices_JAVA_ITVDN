<%--
  Created by IntelliJ IDEA.
  User: Vovchik
  Date: 24.04.2023
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<h1>List of employee: </h1>
${employees}
<br/>

<h2>To add new employee, press "Add employee" button</h2>
<form method="post" action="/employee/add">
  <p><label for="name">Employee name </label></p>
  <p><input type="text" name="name" id="name"></p>
  <br/>

  <p><label for="surname">Employee surname: </label></p>
  <p><input type="text" name="surname" id="surname"></p>
  <br/>

  <p><label for="phone">Employee phone: </label> </p>
  <p><input type="text" name="phone" id="phone"></p>
  <br/>

  <p><label for="email">Employee email: </label> </p>
  <p><input type="text" name="email" id="email"></p>
  <br/>

  <p><label for="position">Employee position: </label></p>
  <p><input type="text" name="position" id="position"></p>
  <br/>

  <input type="submit" value="Add employee!">
</form>
<br/>
<br/>
<form method="post" action="/employee/findByName">
  <h2>Search employee by name</h2>
  <p>Name: </p>
  <p><input type="text" name="name"></p>
  <p><input type="submit" value="Search!"></p>
</form>
<br/>
<br/>
<form method="post" action="/employee/findByNameAndPosition">
  <h2>Search employee by name and position</h2>
  <p>Name: </p>
  <p><input type="text" name="name"></p>
  <p>Position: </p>
  <p><input type="text" name="position"></p>
  <p><input type="submit" value="Search!"></p>
</form>
<br/>
<br/>
<form method="PATCH" action="/employee/update">
  <h2>Update employee's position by id</h2>
  <p>Id: </p>
  <p><input type="number" name="id"></p>
  <p>Position: </p>
  <p><input type="text" name="position"></p>
  <p><input type="submit" value="Update!"></p>
</form>
</body>
</html>
