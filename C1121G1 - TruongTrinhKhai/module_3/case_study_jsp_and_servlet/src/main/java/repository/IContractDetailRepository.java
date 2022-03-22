package repository;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 22:33
*/

import model.contract.AttachService;
import model.contract.ContractDetail;
import model.dto.ContractDetailDTO;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetailDTO> findAllContractDetailDTO();

    void insertContractDetail(ContractDetail contractDetail);

    List<AttachService> findAllAttachService();
}
