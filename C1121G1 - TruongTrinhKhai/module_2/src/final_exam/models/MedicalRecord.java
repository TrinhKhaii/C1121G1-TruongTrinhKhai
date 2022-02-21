package final_exam.models;

public abstract class MedicalRecord {
    private int id;
    private String medicalRecordCode;
    private String patientCode;
    private String patientName;
    private String dateOfAdmission;
    private String dateOfDischarge;
    private String reason;

    public MedicalRecord() {}

    public MedicalRecord(int id, String medicalRecordCode, String patientCode, String patientName, String dateOfAdmission, String dateOfDischarge, String reason) {
        this.id = id;
        this.medicalRecordCode = medicalRecordCode;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.dateOfAdmission = dateOfAdmission;
        this.dateOfDischarge = dateOfDischarge;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicalRecordCode() {
        return medicalRecordCode;
    }

    public void setMedicalRecordCode(String medicalRecordCode) {
        this.medicalRecordCode = medicalRecordCode;
    }

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

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getDateOfDischarge() {
        return dateOfDischarge;
    }

    public void setDateOfDischarge(String dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return ", id=" + id +
                ", medicalRecordCode='" + medicalRecordCode + '\'' +
                ", patientCode='" + patientCode + '\'' +
                ", patientName='" + patientName + '\'' +
                ", dateOfAdmission='" + dateOfAdmission + '\'' +
                ", dateOfDischarge='" + dateOfDischarge + '\'' +
                ", reason='" + reason;
    }
}
