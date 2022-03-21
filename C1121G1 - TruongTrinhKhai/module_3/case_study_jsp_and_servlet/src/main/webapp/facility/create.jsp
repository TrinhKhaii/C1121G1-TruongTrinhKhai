<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 21/03/2022
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new facility form</title>
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
    <h1>Add New Facility Form</h1>
    <h2>
        <a href="facility?action=facility">Back to List</a>
    </h2>
    <p>
        <c:if test='${messenger != null}'>
            <span class="messenger">${messenger}</span>
        </c:if>
    </p>
</div>
<div>
    <form method="post">
        <table>
            <caption>
                <h2>Add New Facility</h2>
            </caption>
            <tr>
                <th>Facility Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${facility.getName()}"/><br/>
                    <small class="error">${error.get("name")}</small>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="area" id="area" size="45" value="${facility.getArea()}"/><br/>
                    <small class="error">${error.get("birthday")}</small>
                </td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td>
                    <input type="text" name="cost" id="cost" size="45" value="${facility.getCost()}"/><br/>
                    <%--                    <small class="error">${error.get("name")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Max people:</th>
                <td>
                    <input type="text" name="max_people" id="max_people" size="45" value="${facility.getMaxPeople()}"/><br/>
                    <%--                    <small class="error">${error.get("name")}</small>--%>
                </td>
            </tr>

            <tr>
                <th>Rent type:</th>
                <td>
                    <select name="rent_type">
                        <c:forEach var="rentType" items="${rentTypeList}">
                            <option value="${rentType.getId()}">${rentType.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <select hidden name="rent_type">
                <c:forEach var="serviceType" items="${serviceTypeList}">
                    <c:if test="serviceType.getId() == serviceTypeId">
                        <option value="${serviceType.getId()}">${serviceType.getName()}</option>
                    </c:if>
                </c:forEach>
            </select>

            <c:if test="serviceTypeId == 2">
                <tr>
                    <th>Number of floors:</th>
                    <td>
                        <input type="text" name="number_of_floors" id="number_of_floors" size="45" value="${facility.getEmail()}"/><br/>
                            <%--                    <small class="error">${error.get("email")}</small>--%>
                    </td>
                </tr>
            </c:if>

            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${employee.getAddress()}"/><br/>
                    <%--                    <small class="error">${error.get("email")}</small>--%>
                </td>
            </tr>
            <tr>
                <th>Employee Position Id:</th>
                <td>
                    <select name="position_id">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.getId()}">${position.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Education Degree Id:</th>
                <td>
                    <select name="education_degree_id">
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <option value="${educationDegree.getId()}">${educationDegree.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Division Id:</th>
                <td>
                    <select name="division_id">
                        <c:forEach var="division" items="${divisionList}">
                            <option value="${division.getId()}">${division.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee User Name:</th>
                <td>
                    <input type="text" name="user_name" id="user_name" size="45" value="${employee.getUsername()}"/><br/>
                    <small class="error">${error.get("email")}</small>
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
</html>

