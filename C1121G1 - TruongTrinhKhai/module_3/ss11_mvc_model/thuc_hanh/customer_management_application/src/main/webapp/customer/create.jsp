<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 11/03/2022
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope[message] == null}'>
        <span class="messenger">${requestScope[message]}</span>
    </c:if>
</p>
<p>
<%--    <a href="#" onclick="servlet()">Back to customer list</a>--%>
    <a href="customers">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
<%--<script>--%>
<%--    function servlet() {--%>
<%--        if (confirm("Bạn muốn chuyển trang?")) {--%>
<%--            window.location.href= "customers"--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</html>
