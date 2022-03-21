package model.contract;
/*
    Created by Trinh Khai
    Date: 17/03/2022
    Time: 13:46
*/

public class ContractDetail {
    private Integer id;
    private Contract contractId;
    private AttachService attachServiceId;
    private Integer quantity;

    public ContractDetail() {}

    public ContractDetail(Integer id, Contract contractId, AttachService attachServiceId, Integer quantity) {
        this.id = id;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", attachServiceId=" + attachServiceId +
                ", quantity=" + quantity +
                '}';
    }
}
