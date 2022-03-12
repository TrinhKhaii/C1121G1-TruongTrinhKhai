<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 13/03/2022
  Time: 01:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<h1>Search Result</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
    </tr>
    <c:forEach var="product" items="${searchProductList}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getManufacturer()}</td>
        </tr>
    </c:forEach>
</table>
</body>
<p>
    <a href="product">Back to product list</a>
</p>
</html>
