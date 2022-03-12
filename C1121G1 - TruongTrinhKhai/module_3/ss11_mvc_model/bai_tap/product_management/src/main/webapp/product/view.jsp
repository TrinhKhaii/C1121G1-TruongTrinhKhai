<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 13/03/2022
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Product Information</legend>
    <table>
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" id="name" value="${product.getName()}"></td>
        </tr>
        <tr>
            <td>Price: </td>
            <td><input type="text" name="price" id="price" value="${product.getPrice()}"></td>
        </tr>
        <tr>
            <td>Description: </td>
            <td><input type="text" name="description" id="description" value="${product.getDescription()}"></td>
        </tr>
        <tr>
            <td>Manufacturer: </td>
            <td><input type="text" name="manufacturer" id="manufacturer" value="${product.getManufacturer()}"></td>
        </tr>
    </table>
</fieldset>
<p>
    <a href="product">Back to product list</a>
</p>
</body>
</html>
