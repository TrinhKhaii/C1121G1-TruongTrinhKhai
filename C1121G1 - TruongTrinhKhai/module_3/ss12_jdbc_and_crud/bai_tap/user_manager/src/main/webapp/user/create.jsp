<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 14/03/2022
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
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
                <h2>Add New User</h2>
            </caption>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/><br/>
                    <small class="error">${error.get("name")}</small>
                </td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/><br/>
                    <small class="error">${error.get("email")}</small>
                </td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <input type="text" name="country" id="country" size="15"/><br/>
                    <small class="error">${error.get("country")}</small>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
