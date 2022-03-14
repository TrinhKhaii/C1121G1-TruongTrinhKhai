<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 12/03/2022
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<p>
    <a href="product?action=create">Add new product</a>
</p>
<form method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="search" id="search" placeholder="Search product: ">
    <input type="submit" value="Search">
</form>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="product?action=view&id=${product.getId()}"> ${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getManufacturer()}</td>
            <td><a href="product?action=update&id=${product.getId()}">Update</a></td>
            <td><a href="product?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
