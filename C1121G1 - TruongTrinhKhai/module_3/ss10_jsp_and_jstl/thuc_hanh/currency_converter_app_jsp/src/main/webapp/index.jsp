<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 10/03/2022
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="converter.jsp" method="get">
    <label>Rate: </label>
    <input type="text" name="rate" placeholder="RATE" value="22000"><br/>
    <label>USD: </label>
    <input type="text" name="usd" placeholder="USD" value="0"><br/>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
