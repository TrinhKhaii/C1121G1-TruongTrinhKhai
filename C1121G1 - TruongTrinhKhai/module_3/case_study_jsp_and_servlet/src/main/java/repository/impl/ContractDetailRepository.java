package repository.impl;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 22:34
*/

import model.contract.AttachService;
import model.contract.ContractDetail;
import model.dto.ContractDetailDTO;
import repository.IContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_CONTRACT_DETAIL_DTO = "select contract_detail.contract_detail_id, contract_detail.quantity, contract_detail.contract_id, attach_service.attach_service_name,\n" +
            "attach_service.attach_service_cost, attach_service.attach_service_unit, attach_service.attach_service_status\n" +
            "from contract_detail\n" +
            "inner join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id\n" +
            "group by contract_detail.contract_detail_id\n" +
            "order by contract_detail.contract_detail_id;";
    private static final String SELECT_ALL_ATTACH_SERVICE = "select * from attach_service";

    @Override
    public List<ContractDetailDTO> findAllContractDetailDTO() {
        List<ContractDetailDTO> contractDetailDTOList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL_DTO)) {
            System.out.println(SELECT_ALL_CONTRACT_DETAIL_DTO);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("contract_detail_id");
                Integer quantity = rs.getInt("quantity");
                Integer contractId = rs.getInt("contract_id");
                String attachServiceName = rs.getString("attach_service_name");
                Double attachServiceCost = rs.getDouble("attach_service_cost");
                String attachServiceUnit = rs.getString("attach_service_unit");
                String attachServiceStatus = rs.getString("attach_service_status");
                contractDetailDTOList.add(new ContractDetailDTO(id, quantity, contractId, attachServiceName, attachServiceCost, attachServiceUnit, attachServiceStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetailDTOList;
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {

    }

    @Override
    public List<AttachService> findAllAttachService() {
        List<AttachService> attachServiceList = new ArrayList<>();
        try (Connection connection = baseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer attachServiceId = rs.getInt("attach_service_id");
                String attachServiceName = rs.getString("attach_service_name");
                Double attachServiceCost = rs.getDouble("attach_service_cost");
                String attachServiceUnit = rs.getString("attach_service_unit");
                String attachServiceStatus = rs.getString("attach_service_status");
                attachServiceList.add(new AttachService(attachServiceId, attachServiceName, attachServiceCost, attachServiceUnit, attachServiceStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;
    }
}
