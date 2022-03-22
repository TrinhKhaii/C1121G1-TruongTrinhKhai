<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 21/03/2022
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract Detail List</title>
    <jsp:include page="../includee/cetet.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../includee/header.jsp"></jsp:include>

<h1 style="text-align: center">Contract Detail Management</h1>
<h2 style="text-align: center">
    <a href="contract-detail?action=create">Add New Contract Detail</a>
    <%--    <a href="users?">Get List All</a>--%>
</h2>
<c:if test="${message!=null}">
    <p style="color: red;text-align: center;font-size: 18px">${message}</p>
</c:if>
<form method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="search" size="45">
    <input type="submit" value="tìm kiếm">
</form>
<div align="center">
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Quantity</th>
            <th>Contract Id</th>
            <th>Attach Service name</th>
            <th>Attach Service Cost</th>
            <th>Attach Service Unit</th>
            <th>Attach Service Status</th>
            <%--            <th>Actions</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contractDetail" items="${contractDetailList}">
            <tr>
                <td>${contractDetail.getId()}</td>
                <td>${contractDetail.getQuantity()}</td>
                <td>${contractDetail.getContractId()}</td>
                <td>${contractDetail.getAttachServiceName()}</td>
                <td>${contractDetail.getAttachServiccCost()}</td>
                <td>${contractDetail.getAttachServiceUnit()}</td>
                <td>${contractDetail.getAttachServiceStatus()}</td>
                    <%--                <td>--%>
                    <%--                    <a href="customer?action=edit&id=${contract.getId()}">Edit</a>--%>
                    <%--                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"--%>
                    <%--                            onclick="getId(${contract.getId()})"--%>
                    <%--                            data-bs-target="#exampleModal">--%>
                    <%--                        delete--%>
                    <%--                    </button>--%>
                    <%--                </td>--%>
            </tr>
        </c:forEach>

        <%--  modal --%>
        <%--        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
        <%--            <div class="modal-dialog">--%>
        <%--                <div class="modal-content">--%>
        <%--                    <form method="get" >--%>
        <%--                        <input type="hidden" name="action" value="delete">--%>
        <%--                        <input type="hidden" name="id" id="idDelete">--%>
        <%--                        <div class="modal-header">--%>
        <%--                            <h5 class="modal-title" id="exampleModalLabel">Do you want to delete this employee?</h5>--%>
        <%--                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
        <%--                        </div>--%>
        <%--                        <div class="modal-body">--%>
        <%--                            Yes or No--%>
        <%--                        </div>--%>
        <%--                        <div class="modal-footer">--%>
        <%--                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>--%>
        <%--                            <button type="submit" class="btn btn-primary">YES</button>--%>
        <%--                        </div>--%>
        <%--                    </form>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        </tbody>
    </table>
</div>
</body>
<jsp:include page="../includee/buttrap.jsp"></jsp:include>
</html>

