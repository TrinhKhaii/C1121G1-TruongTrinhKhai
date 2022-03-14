<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 12/03/2022
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Create New Product</h1>
<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name">
                    <span class="error">${error.get("name")}</span>
                </td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price">
                    <p class="error">${error.get("price")}</p>
                </td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description">
                    <p class="error">${error.get("description")}</p>
                </td>
            </tr>
            <tr>
                <td>Manufacturer: </td>
                <td><input type="text" name="manufacturer" id="manufacturer">
                    <p class="error">${error.get("manufacturer")}</p>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create product" onclick="notice()"></td>
            </tr>
        </table>
    </fieldset>
</form>
<p>
    <a href="product">Back to product list</a>
</p>
</body>
<script>
    function notice() {
        alert("Create success!")
    }
</script>
</html>
