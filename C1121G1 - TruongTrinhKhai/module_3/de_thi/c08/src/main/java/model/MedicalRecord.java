package model;
/*
    Created by Trinh Khai
    Date: 23/03/2022
    Time: 14:38
*/

public class MedicalRecord {
    private Integer id;
    private String code;
    private Integer patientId;

    public MedicalRecord() {}

    public MedicalRecord(Integer id, String code, Integer patientId) {
        this.id = id;
        this.code = code;
        this.patientId = patientId;
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

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}
