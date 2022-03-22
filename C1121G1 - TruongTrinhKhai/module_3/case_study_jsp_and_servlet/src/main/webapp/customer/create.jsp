<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 18/03/2022
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee form</title>
    <jsp:include page="../includee/cetet.jsp"></jsp:include>
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
<jsp:include page="../includee/header.jsp"></jsp:include>

<div>
    <h1>Add New Customer Form</h1>
    <h2>
        <a href="customer?action=customer">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div>
    <form method="post" action="customer?action=create">
        <table>
            <caption>
                <h2>Add New Customer</h2>
            </caption>
            <tr>
                <th>Customer Code:</th>
                <td>
                    <input type="text" name="code" id="code" size="45" value="${customer.getCustomerCode()}"/><br/>
                    <c:choose>
                        <c:when test="${code != null}">
                            <small class="error">${code}</small>
                        </c:when>
                        <c:otherwise>
                            <small class="error">${error.get("code")}</small>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${customer.name}"/><br/>
                    <small class="error">${error.get("name")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday" size="45" value="${customer.birthday}"/><br/>
                    <small class="error">${error.get("birthday")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Id Card:</th>
                <td>
                    <input type="text" name="id_card" id="id_card" size="45" value="${customer.getIdCard()}"/><br/>
                    <small class="error">${error.get("id_card")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Phone Number:</th>
                <td>
                    <input type="text" name="phone_number" id="phone_number" size="45"
                           value="${customer.getPhoneNumber()}"/><br/>
                    <small class="error">${error.get("phone_number")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${customer.getEmail()}"/><br/>
                    <small class="error">${error.get("email")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${customer.getAddress()}"/><br/>
                    <small class="error">${error.get("address")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Type Id:</th>
                <td>
                    <select name="customer_type_id">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value="${customerType.getId()}">${customerType.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <select name="gender">
                        <option value="0">Nam</option>
                        <option value="1">Nữ</option>
                    </select>
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
<jsp:include page="../includee/buttrap.jsp"></jsp:include>
</html>
