package controller;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 18:43
*/


import model.MedicalRecordDTO;
import service.IMedicalRecordService;
import service.impl.MedicalRecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MedicalRecordServlet", value = "/medicalrecord")
public class MedicalRecordServlet extends HttpServlet {
    private final IMedicalRecordService medicalRecordService = new MedicalRecordService();

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
                case "edit":
//                    showEditForm(request, response);
                    break;
                case "delete":
//                    deleteCustomer(request, response);
                    break;
                case "search":
//                    searchCustomerByName(request, response);
                    break;
                default:
                    listMedicalRecord(request, response);
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
                    insertMedicalRecord(request, response);
                    break;
                case "edit":
//                    editCustomer(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<MedicalRecordDTO> medicalRecordDTOList = medicalRecordService.findAllMedicalRecord();
        request.setAttribute("medicalRecordDTOList", medicalRecordDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertMedicalRecord(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String code = request.getParameter("medical_record_code");
        String patientCode = request.getParameter("patient_code");
        String patientName = request.getParameter("patient_name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String reason = request.getParameter("reason");
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(id, code, patientCode, patientName, startDate, endDate, reason);
        RequestDispatcher dispatcher;
        Map<String, String> error = medicalRecordService.check(medicalRecordDTO);
        if (medicalRecordService.selectMedicalRecordDTOByCode(code) != null) {
            request.setAttribute("medicalRecordDTO", medicalRecordDTO);
            request.setAttribute("error", error);
            request.setAttribute("code", "Mã bệnh án đã tồn tại.");
        } else {
            if (!error.isEmpty()) {
                request.setAttribute("medicalRecordDTO", medicalRecordDTO);
                request.setAttribute("error", error);
            } else {
                medicalRecordService.insertMedicalRecord(medicalRecordDTO);
                request.setAttribute("messenger", "New customer was created");
            }
        }
        dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }
}
