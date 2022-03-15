<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 15/03/2022
  Time: 05:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
    <style>
        .messenger {
            color: red;
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
<c:if test="${messenger == null}">
    <h1>Search Result</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <c:forEach var="user" items="${userSearchResultList}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
