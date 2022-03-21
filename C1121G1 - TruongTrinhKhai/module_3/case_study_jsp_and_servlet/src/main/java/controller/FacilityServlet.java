package controller;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 00:17
*/


import model.dto.FacilityDTO;
import model.service.RentType;
import model.service.ServiceType;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FacilityServlet", value = "/facility")
public class FacilityServlet extends HttpServlet {
    IFacilityService facilityService = new FacilityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
//                    showEditForm(request, response);
                    break;
                case "delete":
//                    deleteFacility(request, response);
                    break;
                case "search":
//                    searchFacilityByName(request, response);
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
//                    insertFacility(request, response);
                    break;
                case "edit":
//                    showEditForm(request, response);
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

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
        Integer serviceTypeId = Integer.valueOf(request.getParameter("serviceTypeId"));
        request.setAttribute("serviceTypeId", serviceTypeId);
        List<RentType> rentTypeList = facilityService.findAllRentType();
        List<ServiceType> serviceTypeList = facilityService.findAllServiceType();
        request.setAttribute("rentTypeList", rentTypeList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("facility/create.jsp");
        dispatcher.forward(request, response);
    }

//    private void insertFacility(HttpServletRequest request, HttpServletResponse response)
}
