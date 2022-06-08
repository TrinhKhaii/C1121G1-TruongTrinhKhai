package controller;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 22:02
*/




import model.contract.AttachService;
import model.contract.ContractDetail;
import model.dto.ContractDTO;
import model.dto.ContractDetailDTO;
import service.IContractDetailService;
import service.IContractService;
import service.impl.ContractDetailService;
import service.impl.ContractService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractDetailServlet", value = "/contract-detail")
public class ContractDetailServlet extends HttpServlet {
    IContractDetailService contractDetailService = new ContractDetailService();
    IContractService contractService = new ContractService();

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
                    listContract(request, response);
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
                    insertContractDetail(request, response);
                    break;
                default:
                    listContract(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<ContractDetailDTO> contractDetailList = contractDetailService.findAllContractDetailDTO();
        request.setAttribute("contractDetailList", contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<AttachService> attachServiceList = contractDetailService.findAllAttachService();
        List<ContractDTO> contractDTOList = contractService.findAllContractDTO();
        request.setAttribute("attachServiceList", attachServiceList);
        request.setAttribute("contractDTOList", contractDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertContractDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Integer id = (int) (Math.random() * 10000);
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        Integer contractId = Integer.valueOf(request.getParameter("contract_id"));
        Integer attachServiceId = Integer.valueOf(request.getParameter("attach_service_id"));
        ContractDetail contractDetail = new ContractDetail(id, contractId, attachServiceId, quantity);
        RequestDispatcher dispatcher;
        Map<String, String> error = contractDetailService.check(contractDetail);
        if (error != null) {
            List<AttachService> attachServiceList = contractDetailService.findAllAttachService();
            List<ContractDTO> contractDTOList = contractService.findAllContractDTO();
            request.setAttribute("attachServiceList", attachServiceList);
            request.setAttribute("contractDTOList", contractDTOList);
            request.setAttribute("contractDetail", contractDetail);
            request.setAttribute("error", error);
        } else {
            contractDetailService.insertContractDetail(contractDetail);
            request.setAttribute("messenger", "New contract detail was created");
        }
        dispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
        dispatcher.forward(request, response);
    }
}
