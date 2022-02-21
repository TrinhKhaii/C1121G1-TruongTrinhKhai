package final_exam.models;

public class VipPatient extends MedicalRecord{
    public enum VipType {
        VIP1("Vip I"),
        VIP2("Vip II"),
        VIP3("Vip III"),;
        private final String value;
        VipType(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }

    private String vipType;
    private String vipDuration;

    public VipPatient() {}

    public VipPatient(int id, String medicalRecordCode, String patientCode, String patientName, String dateOfAdmission, String dateOfDischarge, String reason, String vipType, String vipDuration) {
        super(id, medicalRecordCode, patientCode, patientName, dateOfAdmission, dateOfDischarge, reason);
        this.vipType = vipType;
        this.vipDuration = vipDuration;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getVipDuration() {
        return vipDuration;
    }

    public void setVipDuration(String vipDuration) {
        this.vipDuration = vipDuration;
    }

    @Override
    public String toString() {
        return "VipPatient{" +
                super.toString() +
                "vipType='" + vipType + '\'' +
                ", vipDuration='" + vipDuration + '\'' +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getMedicalRecordCode() + "," + this.getPatientCode() + "," + this.getPatientName()
                + "," + this.getDateOfAdmission() + "," + this.getDateOfDischarge() + "," + this.getReason()
                + "," + this.getVipType() + "," + this.getVipDuration();
    }
}
