<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 18/03/2022
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
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
    <h1>Edit Customer Form</h1>
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
    <form method="post" action="customer?action=edit">
        <table>
            <caption>
                <h2>Edit Employee</h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="${customer.getId()}">
            </c:if>
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
                    <input type="text" name="name" id="name" size="45" value="${customer.getName()}"/><br/>
                    <small class="error">${error.get("name")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="text" name="birthday" id="birthday" size="45" value="${customer.getBirthday()}"/><br/>
                    <small class="error">${error.get("birthday")}</small>
                </td>
            </tr>
            <tr>
                <th>Customer Id Card:</th>
                <td>
                    <input type="text" name="id_card" id="id_card" size="45" value="${customer.getIdCard()}"/><br/>
                    <%--                    <small class="error">${error.get("name")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Customer Phone Number:</th>
                <td>
                    <input type="text" name="phone_number" id="phone_number" size="45" value="${customer.getPhoneNumber()}"/><br/>
                    <%--                    <small class="error">${error.get("name")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${customer.getEmail()}"/><br/>
                    <%--                    <small class="error">${error.get("email")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${customer.getAddress()}"/><br/>
                    <%--                    <small class="error">${error.get("email")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Customer Type Id:</th>
                <td>
                    <select name="customer_type_id">
                        <c:forEach var="customerTypeList" items="${customerTypeList}">
                            <c:choose>
                                <c:when test="${customerTypeList.getId() == customer.getCustomerTypeId()}">
                                    <option value="${customerTypeList.getId()}" selected>${customerTypeList.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${customerTypeList.getId()}">${customerTypeList.getName()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select name="gender">
                        <c:if test="${customer.getGender() == 1}">
                            <option value="1">Nữ</option>
                        </c:if>
                        <c:if test="${customer.getGender() == 0}">
                            <option value="0">Nam</option>
                        </c:if>
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
