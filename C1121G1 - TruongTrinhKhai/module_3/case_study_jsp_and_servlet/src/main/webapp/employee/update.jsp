<%--
  Created by IntelliJ IDEA.
  User: truongtrinhkhai
  Date: 17/03/2022
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
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
    <h1>Edit Employee Form</h1>
    <h2>
        <a href="employee?action=employee">Back to List</a>
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
                <h2>Edit Employee</h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="id" value="${employee.getId()}">
            </c:if>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${employee.getName()}"/><br/>
                    <small class="error">${error.get("name")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="date" name="birthday" id="birthday" size="45" value="${employee.getBirthday()}"/><br/>
                    <small class="error">${error.get("birthday")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Id Card:</th>
                <td>
                    <input type="text" name="id_card" id="id_card" size="45" value="${employee.getIdCard()}"/><br/>
                    <small class="error">${error.get("id_card")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45" value="${employee.getSalary()}"/><br/>
                    <small class="error">${error.get("salary")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Phone Number:</th>
                <td>
                    <input type="text" name="phone_number" id="phone_number" size="45" value="${employee.getPhoneNumber()}"/><br/>
                    <small class="error">${error.get("phone_number")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${employee.getEmail()}"/><br/>
                    <small class="error">${error.get("email")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${employee.getAddress()}"/><br/>
                    <small class="error">${error.get("address")}</small>
                </td>
            </tr>
            <tr>
                <th>Employee Position Id:</th>
                <td>
                    <select name="position_id">
                        <c:forEach var="position" items="${positionList}">
                            <c:choose>
                                <c:when test="${position.getId()== employee.getPositionId()}">
                                    <option value="${position.getId()}" selected>${position.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${position.getId()}">${position.getName()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Education Degree Id:</th>
                <td>
                    <select name="education_degree_id">
                        <c:forEach var="educationDegree" items="${educationDegreeList}">
                            <c:choose>
                                <c:when test="${educationDegree.getId() == employee.getEducationDegreeId()}">
                                    <option value="${educationDegree.getId()}" selected>${educationDegree.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${educationDegree.getId()}">${educationDegree.getName()}</option>
                                </c:otherwise>
                            </c:choose>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Division Id:</th>
                <td>
                    <select name="division_id">
                        <c:forEach var="division" items="${divisionList}">
                            <c:choose>
                                <c:when test="${division.getId() == employee.getDivisionId()}">
                                    <option value="${division.getId()}" selected>${division.getName()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${division.getId()}">${division.getName()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee User Name:</th>
                <td>
                    <input type="text" name="user_name" id="user_name" size="45" value="${employee.getUsername()}"/><br/>
                    <small class="error">${error.get("user_name")}</small>
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
