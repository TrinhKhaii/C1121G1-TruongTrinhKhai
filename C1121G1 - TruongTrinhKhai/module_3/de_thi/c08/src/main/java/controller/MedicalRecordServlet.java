package controller;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 14:41
*/


import model.MedicalRecord;
import model.MedicalRecordDTO;
import model.Patient;
import service.IMedicalRecordService;
import service.impl.MedicalRecordService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
                case "search":
//                    searchProduct(request, response);
                default:
                    listMedicalPatient(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listMedicalPatient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<MedicalRecordDTO> medicalRecordDTOList = medicalRecordService.findAllMedicalRecord();
        request.setAttribute("medicalRecordDTOList", medicalRecordDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
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
                    insertMedicalPatient(request, response);
                    break;
                case "edit":
                    editMedicalPatient(request, response);
                    break;
                case "delete":
                    deleteMedicalPatient(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertMedicalPatient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        String code = request.getParameter("medical_record_code");
        String patientCode = request.getParameter("patient_code");
        String patientName = request.getParameter("patient_name");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String reason = request.getParameter("reason");
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(id, code, patientCode, patientName, startDate, endDate, reason);
        medicalRecordService.insertMedicalRecord(medicalRecordDTO);
        response.sendRedirect("medicalrecord");
    }

    private void deleteMedicalPatient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id_modal_delete"));
        medicalRecordService.deleteMedicalRecord(id);
        response.sendRedirect("medicalrecord");
    }

    private void editMedicalPatient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = Integer.valueOf(request.getParameter("id_modal_edit"));
        String name = request.getParameter("medical_record_code");
        String patientCode = request.getParameter("patient_code");
        String patientName = request.getParameter("patient_name");
        String startDate = request.getParameter("start_date");
        String endDate = request.getParameter("end_date");
        String reason = request.getParameter("reason");
        MedicalRecordDTO medicalRecordDTO = new MedicalRecordDTO(id, name, patientCode, patientName, startDate, endDate, reason);
        medicalRecordService.updateMedicalRecord(medicalRecordDTO);
        response.sendRedirect("medicalrecord");
    }
}
