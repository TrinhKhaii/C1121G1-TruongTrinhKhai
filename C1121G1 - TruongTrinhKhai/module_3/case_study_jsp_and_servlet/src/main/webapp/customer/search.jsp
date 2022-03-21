<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 18/03/2022
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
    <jsp:include page="../includee/cetet.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../includee/header.jsp"></jsp:include>
<div>
    <h1>Customer Management</h1>
    <h2>
        <a href="customer?action=customer">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div align="center">
    <c:if test="${messenger == null}">
        <h1>Search Result</h1>
        <table border="1" id="example" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Code</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Id Card</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Address</th>
                <th>Customer Type Id</th>
                <th>Gender</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.getId()}</td>
                    <td>${customer.getCustomerCode()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getBirthday()}</td>
                    <td>${customer.getIdCard()}</td>
                    <td>${customer.getPhoneNumber()}</td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getAddress()}</td>
                    <td>${customer.getCustomerTypeId()}</td>
                    <td>
                        <c:if test="${customer.getGender() == 1}">
                            Nữ
                        </c:if>
                        <c:if test="${customer.getGender() == 0}">
                            Nam
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
<jsp:include page="../includee/buttrap.jsp"></jsp:include>
</html>
