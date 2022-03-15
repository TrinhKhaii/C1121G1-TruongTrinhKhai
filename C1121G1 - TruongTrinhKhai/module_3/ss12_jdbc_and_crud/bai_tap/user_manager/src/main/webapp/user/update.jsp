<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 15/03/2022
  Time: 05:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
    <style>
        .error {
            color: red;
        }
        .messenger {
            color: green;
        }
    </style>
</head>
<body>
<div>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div>
    <form method="post">
        <table>
            <caption>
                <h2>Edit User</h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="${user.getId()}">
            </c:if>
            <tr>
                <th>User Name: </th>
                <td>
                    <input type="text" name="name" value="${user.getName()}" size="45"><br/>
                    <small class="error">${error.get("name")}</small>
                </td>
            </tr>
            <tr>
                <th>User Email: </th>
                <td>
                    <input type="text" name="email" value="${user.getEmail()}" size="45"><br/>
                    <small class="error">${error.get("email")}</small>
                </td>
            </tr>
            <tr>
                <th>User Country: </th>
                <td>
                    <input type="text" name="country" value="${user.getCountry()}" size="45"><br/>
                    <small class="error">${error.get("country")}</small>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
