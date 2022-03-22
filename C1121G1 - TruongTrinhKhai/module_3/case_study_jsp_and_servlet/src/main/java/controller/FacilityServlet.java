package controller;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 00:17
*/


import model.dto.FacilityDTO;
import model.service.*;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    IFacilityService facilityService = new FacilityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                default:
                    listFacility(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertFacility(request, response);
                    break;
                default:
                    listFacility(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<FacilityDTO> facilityDTOList = facilityService.selectAllFacilityDTO();
        request.setAttribute("facilityDTOList", facilityDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("facility/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer serviceTypeId = Integer.valueOf(request.getParameter("serviceTypeId"));
        request.setAttribute("serviceTypeId", serviceTypeId);
        List<RentType> rentTypeList = facilityService.findAllRentType();
        List<ServiceType> serviceTypeList = facilityService.findAllServiceType();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("facility/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFacility(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        Integer area = Integer.valueOf(request.getParameter("area"));
        Double cost = Double.valueOf(request.getParameter("cost"));
        Integer maxPeople = Integer.valueOf(request.getParameter("max_people"));
        Integer rentTypeId = Integer.valueOf(request.getParameter("rent_type"));
        Integer serviceTypeId = Integer.valueOf(request.getParameter("service_type"));
        String roomStandard = request.getParameter("room_standard");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        String poolArea = request.getParameter("pool_area");
        String numberOfFloors = request.getParameter("number_of_floors");
        String freeServiceIncluded = request.getParameter("free_service_included");
        FacilityDTO facilityDTO = new FacilityDTO(id, code, name, area, cost, maxPeople);
        RequestDispatcher dispatcher;
        List<RentType> rentTypeList = facilityService.findAllRentType();
        List<ServiceType> serviceTypeList = facilityService.findAllServiceType();
        switch (serviceTypeId) {
            case 1:
                Villa villa = new Villa(id, code, name, area, cost, maxPeople, rentTypeId, serviceTypeId, roomStandard, descriptionOtherConvenience, Float.parseFloat(poolArea), Integer.parseInt(numberOfFloors));
                Map<String, String> villaError = facilityService.checkVilla(villa);
                if (villaError != null) {
                    request.setAttribute("rentTypeList", rentTypeList);
                    request.setAttribute("serviceTypeList", serviceTypeList);
                    request.setAttribute("serviceTypeId", serviceTypeId);
                    request.setAttribute("facility", facilityDTO);
                    request.setAttribute("villa", villa);
                    request.setAttribute("villaError", villaError);
                } else {
                    request.setAttribute("rentTypeList", rentTypeList);
                    request.setAttribute("serviceTypeList", serviceTypeList);
                    request.setAttribute("serviceTypeId", serviceTypeId);
                    facilityService.insertVilla(villa);
                    request.setAttribute("messenger", "New villa service was created");
                }
                break;
            case 2:
                House house = new House(id, code, name, area, cost, maxPeople, rentTypeId, serviceTypeId, roomStandard, descriptionOtherConvenience, Integer.parseInt(numberOfFloors));
                Map<String, String> houseError = facilityService.checkHouse(house);
                if (houseError != null) {
                    request.setAttribute("rentTypeList", rentTypeList);
                    request.setAttribute("serviceTypeList", serviceTypeList);
                    request.setAttribute("serviceTypeId", serviceTypeId);
                    request.setAttribute("facility", facilityDTO);
                    request.setAttribute("house", house);
                    request.setAttribute("houseError", houseError);
                } else {
                    request.setAttribute("rentTypeList", rentTypeList);
                    request.setAttribute("serviceTypeList", serviceTypeList);
                    request.setAttribute("serviceTypeId", serviceTypeId);
                    facilityService.insertHouse(house);
                    request.setAttribute("messenger", "New house service was created");
                }
                break;
            case 3:
                Room room = new Room(id, code, name, area, cost, maxPeople, rentTypeId, serviceTypeId, freeServiceIncluded);
                Map<String, String> roomError = facilityService.checkRoom(room);
                if (roomError != null) {
                    request.setAttribute("rentTypeList", rentTypeList);
                    request.setAttribute("serviceTypeList", serviceTypeList);
                    request.setAttribute("serviceTypeId", serviceTypeId);
                    request.setAttribute("facility", facilityDTO);
                    request.setAttribute("room", room);
                    request.setAttribute("roomError", roomError);
                } else {
                    request.setAttribute("rentTypeList", rentTypeList);
                    request.setAttribute("serviceTypeList", serviceTypeList);
                    request.setAttribute("serviceTypeId", serviceTypeId);
                    facilityService.insertRoom(room);
                    request.setAttribute("messenger", "New room service was created");
                }
                break;
        }
        dispatcher = request.getRequestDispatcher("facility/create.jsp");
        dispatcher.forward(request, response);
    }
}
