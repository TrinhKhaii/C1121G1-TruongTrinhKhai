package final_exam.models;

public class NormalPatient extends MedicalRecord{
    private float fee;

    public NormalPatient() {}

    public NormalPatient(int id, String medicalRecordCode, String patientCode, String patientName, String dateOfAdmission, String dateOfDischarge, String reason, float fee) {
        super(id, medicalRecordCode, patientCode, patientName, dateOfAdmission, dateOfDischarge, reason);
        this.fee = fee;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "NormalPatient{" +
                super.toString() +
                "fee=" + fee +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getMedicalRecordCode() + "," + this.getPatientCode() + "," + this.getPatientName()
                + "," + this.getDateOfAdmission() + "," + this.getDateOfDischarge() + "," + this.getReason()
                + "," + this.getFee();
    }
}
