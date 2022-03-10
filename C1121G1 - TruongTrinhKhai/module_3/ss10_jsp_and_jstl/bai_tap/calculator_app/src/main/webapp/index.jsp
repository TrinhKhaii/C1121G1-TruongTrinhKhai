<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 10/03/2022
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <label>First operand: </label>
    <input type="text" name="first-operand" value="0"><br/>
    <label>Operator</label>
    <select name="operator" id="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br/>
    <label>Second operand</label>
    <input type="text" name="second-operand" value="0"><br/>
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>
