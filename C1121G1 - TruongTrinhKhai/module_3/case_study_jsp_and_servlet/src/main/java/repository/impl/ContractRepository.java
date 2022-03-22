package repository.impl;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 16:04
*/

import model.contract.Contract;
import model.dto.ContractDTO;
import repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_CONTRACT_DTO = "select contract.contract_id, contract.contract_start_date, contract.contract_end_date, contract.contract_deposit, contract.contract_total_money,\n" +
            "employee.employee_name, customer.customer_name, service.service_name\n" +
            "from contract\n" +
            "inner join employee on contract.employee_id = employee.employee_id\n" +
            "inner join customer on contract.customer_id = customer.customer_id\n" +
            "inner join service on contract.service_id = service.service_id\n" +
            "group by contract.contract_id\n" +
            "order by contract.contract_id;";
    private static final String INSERT_NEW_CONTRACT = "insert into contract(contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id) values (?, ?, ?, ?, ?, ?, ?)";
    @Override
    public List<ContractDTO> findAllContractDTO() {
        List<ContractDTO> contractDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DTO)) {
            System.out.println(SELECT_ALL_CONTRACT_DTO);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("contract_id");
                String startDate = rs.getString("contract_start_date");
                String endDate = rs.getString("contract_end_date");
                Double contractDeposit = rs.getDouble("contract_deposit");
                Double contractTotalMoney = rs.getDouble("contract_total_money");
                String employeeName = rs.getString("employee_name");
                String customerName = rs.getString("customer_name");
                String serviceName = rs.getString("service_name");
                contractDTOList.add(new ContractDTO(id, startDate, endDate, contractDeposit, contractTotalMoney, employeeName, customerName, serviceName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDTOList;
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        System.out.println(INSERT_NEW_CONTRACT);
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_CONTRACT)) {
            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setDouble(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getFacilityId());
            preparedStatement.executeUpdate();
        }
    }
}
