<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 21/03/2022
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new contract detail form</title>
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
    <h1>Add New Contract Detail Form</h1>
    <h2>
        <a href="contract-detail?action=contract">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div>
    <form method="post" action="contract-detail?action=create">
        <table>
            <caption>
                <h2>Add New Contract Detail</h2>
            </caption>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45" value="${contract.getEndDate()}"/><br/>
                    <%--                    <small class="error">${error.get("end_date")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Contract Id:</th>
                <td>
                    <select name="contract_id">
                        <c:forEach var="contractDTO" items="${contractDTOList}">
                            <option value="${contractDTO.getId()}">${contractDTO.getId()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Attach Service Id:</th>
                <td>
                    <select name="attach_service_id">
                        <c:forEach var="attachService" items="${attachServiceList}">
                            <option value="${attachService.getId()}">${attachService.getName()}</option>
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

