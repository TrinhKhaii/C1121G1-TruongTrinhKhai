<%@ page import="model.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 10/03/2022
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h2 style="margin-left: 100px">Danh sach khach hang</h2>
<table style="border: 1px solid black; margin-left: 30px">
    <tr style="border-bottom: 1px solid rgba(56,56,56,0.42)">
        <th class="pl-4">Name</th>
        <th class="pl-4">Birthday</th>
        <th class="pl-4">Address</th>
        <th class="pl-4">Image</th>
    </tr>
    <c:forEach var="person" items="${list}">
        <tr style="border-bottom: 1px solid rgba(56,56,56,0.42)">
<%--        <td><c:out value="${person.name}"></c:out></td>--%>
<%--        <td><c:out value="${person.dateOfBirth}"></c:out></td>--%>
<%--        <td><c:out value="${person.address}"></c:out></td>--%>
<%--        <td><img src="${person.picture}" alt=""></td>--%>
            <td class="p-4">${person.name}</td>
            <td class="p-4">${person.dateOfBirth}</td>
            <td class="p-4">${person.address}</td>
            <td class="p-4"><img style="width: 100px" src="${person.picture}" alt="pic"></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
