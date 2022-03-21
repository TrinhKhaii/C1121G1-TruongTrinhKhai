<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 18/03/2022
  Time: 15:48
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
        <a href="employee?action=employee">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div align="center">
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id Card</th>
            <th>Salary</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.getId()}</td>
                <td>${employee.getName()}</td>
                <td>${employee.getBirthday()}</td>
                <td>${employee.getIdCard()}</td>
                <td>${employee.getSalary()}</td>
                <td>${employee.getPhoneNumber()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getAddress()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<jsp:include page="../includee/buttrap.jsp"></jsp:include>
</html>
