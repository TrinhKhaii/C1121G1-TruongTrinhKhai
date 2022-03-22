package repository;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 15:07
*/

import model.contract.Contract;
import model.dto.ContractDTO;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    List<ContractDTO> findAllContractDTO();

    void insertContract(Contract contract) throws SQLException;

}
