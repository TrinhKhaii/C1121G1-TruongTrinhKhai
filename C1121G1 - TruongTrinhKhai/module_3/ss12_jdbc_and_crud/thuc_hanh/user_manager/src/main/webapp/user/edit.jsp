<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 13/03/2022
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</div>
<div style="align-self: center">
    <form method="post">
        <table style="border: 1px; padding: 5px">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
            </c:if>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="${user.name}"
                    />
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="${user.email}"
                    />
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="${user.country}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" style="align-self: center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
