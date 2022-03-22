package service.impl;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 16:13
*/

import model.contract.Contract;
import model.dto.ContractDTO;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractService implements IContractService {
    private final IContractRepository contractRepository = new ContractRepository();


    @Override
    public List<ContractDTO> findAllContractDTO() {
        return contractRepository.findAllContractDTO();
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        contractRepository.insertContract(contract);
    }

    @Override
    public Map<String, String> check(Contract contract) {
        Map<String, String> error = new HashMap<>();
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }
}
