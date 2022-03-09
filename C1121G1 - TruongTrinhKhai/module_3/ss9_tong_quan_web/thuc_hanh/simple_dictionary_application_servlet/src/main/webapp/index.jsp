<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 09/03/2022
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta charset="UTF-8">--%>
    <title>$Title$</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="/translate" method="post">
    <input type="text" name="input-value" placeholder="Enter your word:">
    <input type="submit" id="submit" value="Search">

</form>
<%--${name}--%>
</body>
</html>
