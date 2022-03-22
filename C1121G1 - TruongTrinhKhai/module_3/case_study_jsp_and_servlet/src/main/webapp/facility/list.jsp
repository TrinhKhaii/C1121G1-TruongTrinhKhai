<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 18/03/2022
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
    <jsp:include page="../includee/cetet.jsp"></jsp:include>
</head>
<body>
<jsp:include page="../includee/header.jsp"></jsp:include>

<h1 style="text-align: center">Facility Management</h1>
<h2 style="text-align: center">
    <div>


        <ul class="nav nav-pills">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                   aria-expanded="false">Add New Facility</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="facility?action=create&serviceTypeId=1">Add New Villa</a></li>
                    <li><a class="dropdown-item" href="facility?action=create&serviceTypeId=2">Add New House</a></li>
                    <li><a class="dropdown-item" href="facility?action=create&serviceTypeId=3">Add New Room</a></li>
                </ul>
            </li>
        </ul>
    </div>
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
            <th>Code</th>
            <th>Name</th>
            <th>Area</th>
            <th>Cost</th>
            <th>Max people</th>
            <th>Rent type name</th>
            <th>Service type name</th>
            <th>Room standard</th>
            <th>Description other convenience</th>
            <th>Pool area</th>
            <th>Number of floors</th>
            <th>Free Service Included</th>
<%--            <th>Actions</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="facility" items="${facilityDTOList}">
            <tr>
                <td>${facility.getId()}</td>
                <td>${facility.getCode()}</td>
                <td>${facility.getName()}</td>
                <td>${facility.getArea()}</td>
                <td>${facility.getCost()}</td>
                <td>${facility.getMaxPeople()}</td>
                <td>${facility.getRentTypeName()}</td>
                <td>${facility.getServiceTypeName()}</td>
                <td>
                    <c:if test="${facility.getRoomStandard() == null}">
                        None
                    </c:if>
                    <c:if test="${facility.getRoomStandard() != null}">
                        ${facility.getRoomStandard()}
                    </c:if>
                </td>
                <td>
                    <c:if test="${facility.getDescriptionOtherConvenience() == null}">
                        None
                    </c:if>
                    <c:if test="${facility.getDescriptionOtherConvenience() != null}">
                        ${facility.getDescriptionOtherConvenience()}
                    </c:if>
                </td>
                <td>
                    <c:if test="${facility.getPoolArea() == -1}">
                        None
                    </c:if>
                    <c:if test="${facility.getPoolArea() != -1}">
                        ${facility.getPoolArea()}
                    </c:if>
                </td>
                <td>
                    <c:if test="${facility.getNumberOfFloors() == -1}">
                        None
                    </c:if>
                    <c:if test="${facility.getNumberOfFloors() != -1}">
                        ${facility.getNumberOfFloors()}
                    </c:if>
                </td>
                <td>
                    <c:if test="${facility.getFreeServiceIncluded() == null}">
                        None
                    </c:if>
                    <c:if test="${facility.getFreeServiceIncluded() != null}">
                        ${facility.getFreeServiceIncluded()}
                    </c:if>
                </td>
<%--                <td>--%>
<%--                    <a href="employee?action=edit&id=${facility.getId()}">Edit</a>--%>
<%--                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"--%>
<%--                            onclick="getId(${facility.getId()})"--%>
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
<%--                    <form method="get">--%>
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

