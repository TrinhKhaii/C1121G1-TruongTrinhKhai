package model.dto;
/*
    Created by Trinh Khai
    Date: 21/03/2022
    Time: 22:29
*/

public class ContractDetailDTO {
    private Integer id;
    private Integer quantity;
    private Integer contractId;
    private String attachServiceName;
    private Double attachServiccCost;
    private String attachServiceUnit;
    private String attachServiceStatus;

    public ContractDetailDTO() {}

    public ContractDetailDTO(Integer id, Integer quantity, Integer contractId, String attachServiceName, Double attachServiccCost, String attachServiceUnit, String attachServiceStatus) {
        this.id = id;
        this.quantity = quantity;
        this.contractId = contractId;
        this.attachServiceName = attachServiceName;
        this.attachServiccCost = attachServiccCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiccCost() {
        return attachServiccCost;
    }

    public void setAttachServiccCost(Double attachServiccCost) {
        this.attachServiccCost = attachServiccCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
