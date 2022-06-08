package model;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 14:40
*/

public class MedicalRecordDTO {
    private Integer id;
    private String code;
//    private Integer patientId;
    private String patientCode;
    private String patientName;
    private String startDate;
    private String endDate;
    private String reason;

    public MedicalRecordDTO() {}

    public MedicalRecordDTO(Integer id, String code, String patientCode, String patientName, String startDate, String endDate, String reason) {
        this.id = id;
        this.code = code;
//        this.patientId = patientId;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public Integer getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Integer patientId) {
//        this.patientId = patientId;
//    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
