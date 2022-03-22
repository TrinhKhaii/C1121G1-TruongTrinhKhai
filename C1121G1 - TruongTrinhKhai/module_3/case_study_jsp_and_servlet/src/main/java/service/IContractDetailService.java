package service;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 22:47
*/

import model.contract.AttachService;
import model.contract.ContractDetail;
import model.dto.ContractDetailDTO;

import java.util.List;
import java.util.Map;

public interface IContractDetailService {
    List<ContractDetailDTO> findAllContractDetailDTO();

    void insertContractDetail(ContractDetail contractDetail);

    List<AttachService> findAllAttachService();

    Map<String, String> check(ContractDetail contractDetail);
}
