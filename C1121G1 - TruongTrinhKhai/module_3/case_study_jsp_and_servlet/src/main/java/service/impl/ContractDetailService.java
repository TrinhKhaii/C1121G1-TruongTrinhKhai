package service.impl;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 22:48
*/

import model.contract.AttachService;
import model.contract.ContractDetail;
import model.dto.ContractDetailDTO;
import repository.IContractDetailRepository;
import repository.impl.ContractDetailRepository;
import service.IContractDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDetailService implements IContractDetailService {
    IContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    @Override
    public List<ContractDetailDTO> findAllContractDetailDTO() {
        return contractDetailRepository.findAllContractDetailDTO();
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {

    }

    @Override
    public List<AttachService> findAllAttachService() {
        return contractDetailRepository.findAllAttachService();
    }

    @Override
    public Map<String, String> check(ContractDetail contractDetail) {
        Map<String, String> error = new HashMap<>();
        if (error.isEmpty()) {
            return null;
        } else {
            return error;
        }
    }


}
