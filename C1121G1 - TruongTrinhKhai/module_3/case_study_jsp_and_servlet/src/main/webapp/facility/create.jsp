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
    <c:choose>
        <c:when test="${serviceTypeId == 1}">
            <h1>Add New Villa Form</h1>
        </c:when>
        <c:when test="${serviceTypeId == 2}">
            <h1>Add New House Form</h1>
        </c:when>
        <c:when test="${serviceTypeId == 3}">
            <h1>Add New Room Form</h1>
        </c:when>
    </c:choose>

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
                <c:choose>
                    <c:when test="${serviceTypeId == 1}">
                        <h2>Add New Villa Form</h2>
                    </c:when>
                    <c:when test="${serviceTypeId == 2}">
                        <h2>Add New House Form</h2>
                    </c:when>
                    <c:when test="${serviceTypeId == 3}">
                        <h2>Add New Room Form</h2>
                    </c:when>
                </c:choose>
            </caption>
            <tr>
                <th>Service Code:</th>
                <td>
                    <input type="text" name="code" id="code" size="45" value="${facility.getCode()}"/><br/>
                    <c:choose>
                        <c:when test="${code != null}">
                            <small class="error">${code}</small>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${serviceTypeId == 1}">
                                    <small class="error">${villaError.get("code")}</small>
                                </c:when>
                                <c:when test="${serviceTypeId == 2}">
                                    <small class="error">${houseError.get("code")}</small>
                                </c:when>
                                <c:when test="${serviceTypeId == 3}">
                                    <small class="error">${roomError.get("code")}</small>
                                </c:when>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Service Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${facility.getName()}"/><br/>
                    <c:choose>
                        <c:when test="${serviceTypeId == 1}">
                            <small class="error">${villaError.get("name")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 2}">
                            <small class="error">${houseError.get("name")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 3}">
                            <small class="error">${roomError.get("name")}</small>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Area:</th>
                <td>
                    <input type="text" name="area" id="area" size="45" value="${facility.getArea()}"/><br/>
                    <c:choose>
                        <c:when test="${serviceTypeId == 1}">
                            <small class="error">${villaError.get("area")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 2}">
                            <small class="error">${houseError.get("area")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 3}">
                            <small class="error">${roomError.get("area")}</small>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Cost:</th>
                <td>
                    <input type="text" name="cost" id="cost" size="45" value="${facility.getCost()}"/><br/>
                    <c:choose>
                        <c:when test="${serviceTypeId == 1}">
                            <small class="error">${villaError.get("cost")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 2}">
                            <small class="error">${houseError.get("cost")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 3}">
                            <small class="error">${roomError.get("cost")}</small>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>Max people:</th>
                <td>
                    <input type="text" name="max_people" id="max_people" size="45"
                           value="${facility.getMaxPeople()}"/><br/>
                    <c:choose>
                        <c:when test="${serviceTypeId == 1}">
                            <small class="error">${villaError.get("max_people")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 2}">
                            <small class="error">${houseError.get("max_people")}</small>
                        </c:when>
                        <c:when test="${serviceTypeId == 3}">
                            <small class="error">${roomError.get("max_people")}</small>
                        </c:when>
                    </c:choose>
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
            <select hidden name="service_type">
                <c:forEach var="serviceType" items="${serviceTypeList}">
                    <c:if test="${serviceType.getId() == serviceTypeId}">
                        <option value="${serviceType.getId()}">${serviceType.getName()}</option>
                    </c:if>
                </c:forEach>
            </select>

            <c:if test="${serviceTypeId == 1 || serviceTypeId == 2}">
                <tr>
                    <th>Room standard:</th>
                    <td>
                        <c:if test="${serviceTypeId == 1}">
                            <input type="text" name="room_standard" id="room_standard" size="45"
                                   value="${villa.getRoomStandard()}"/><br/>
                            <small class="error">${villaError.get("room_standard")}</small>
                        </c:if>
                        <c:if test="${serviceTypeId == 2}">
                            <input type="text" name="room_standard" id="room_standard" size="45"
                                   value="${house.getRoomStandard()}"/><br/>
                            <small class="error">${houseError.get("room_standard")}</small>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Description other convenience:</th>
                    <td>
                        <c:if test="${serviceTypeId == 1}">
                            <input type="text" name="description_other_convenience" id="description_other_convenience"
                                   size="45" value="${villa.getDescriptionOtherConvenience()}"/><br/>
                            <small class="error">${villaError.get("description_other_convenience")}</small>
                        </c:if>
                        <c:if test="${serviceTypeId == 2}">
                            <input type="text" name="description_other_convenience" id="description_other_convenience"
                                   size="45" value="${house.getDescriptionOtherConvenience()}"/><br/>
                            <small class="error">${houseError.get("description_other_convenience")}</small>
                        </c:if>
                    </td>
                </tr>
                <c:if test="${serviceTypeId == 1}">
                    <tr>
                        <th>Pool area:</th>
                        <td>
                            <input type="text" name="pool_area" id="pool_area" size="45"
                                   value="${villa.getPoolArea()}"/><br/>
                            <small class="error">${villaError.get("pool_area")}</small>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <th>Number of floors:</th>
                    <td>
                        <c:if test="${serviceTypeId == 1}">
                            <input type="text" name="number_of_floors" id="number_of_floors" size="45"
                                   value="${villa.getNumberOfFloors()}"/><br/>
                            <small class="error">${villaError.get("number_of_floors")}</small>
                        </c:if>
                        <c:if test="${serviceTypeId == 2}">
                            <input type="text" name="number_of_floors" id="number_of_floors" size="45"
                                   value="${house.getNumberOfFloors()}"/><br/>
                            <small class="error">${houseError.get("number_of_floors")}</small>
                        </c:if>
                    </td>
                </tr>

            </c:if>

            <c:if test="${serviceTypeId == 3}">
                <tr>
                    <th>Free service included:</th>
                    <td>
                        <input type="text" name="free_service_included" id="free_service_included" size="45"
                               value="${room.getFreeServiceIncluded()}"/><br/>
                        <small class="error">${roomError.get("free_service_included")}</small>
                    </td>
                </tr>
            </c:if>
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

