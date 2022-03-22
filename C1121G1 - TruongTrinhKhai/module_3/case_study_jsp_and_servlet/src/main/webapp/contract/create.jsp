<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 21/03/2022
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new contract form</title>
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
    <h1>Add New Contract Form</h1>
    <h2>
        <a href="contract?action=contract">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div>
    <form method="post" action="contract?action=create">
        <table>
            <caption>
                <h2>Add New Contract</h2>
            </caption>
<%--            <tr>--%>
<%--                <th>Contract Id:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="id" id="id" size="45" value="${contract.getId()}"/><br/>--%>
<%--                    <small class="error">${error.get("id")}</small>--%>

<%--                    <c:choose>--%>
<%--                        <c:when test="${code != null}">--%>
<%--                            <small class="error">${code}</small>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <small class="error">${error.get("code")}</small>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Start Date:</th>
                <td>
                    <input type="text" name="start_date" id="start_date" size="45" value="${contract.getStartDate()}"/><br/>
<%--                    <small class="error">${error.get("start_date")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>End Date:</th>
                <td>
                    <input type="text" name="end_date" id="end_date" size="45" value="${contract.getEndDate()}"/><br/>
<%--                    <small class="error">${error.get("end_date")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Deposit:</th>
                <td>
                    <input type="text" name="deposit" id="deposit" size="45" value="${contract.getDeposit()}"/><br/>
                    <%--                    <small class="error">${error.get("name")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Total money:</th>
                <td>
                    <input type="text" name="total_money" id="total_money" size="45"
                           value="${contract.getTotalMoney()}"/><br/>
                    <%--                    <small class="error">${error.get("name")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <select name="customer_name">
                        <c:forEach var="customer" items="${customerList}">
                            <option value="${customer.getId()}">${customer.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <select name="employee_name">
                        <c:forEach var="employee" items="${employeeList}">
                            <option value="${employee.getId()}">${employee.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Service Name:</th>
                <td>
                    <select name="service_name">
                        <c:forEach var="facilityDTO" items="${facilityDTOList}">
                            <option value="${facilityDTO.getId()}">${facilityDTO.getName()}</option>
                        </c:forEach>
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

