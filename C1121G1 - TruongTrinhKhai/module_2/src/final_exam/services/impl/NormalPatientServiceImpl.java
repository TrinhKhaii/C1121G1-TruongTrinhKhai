package final_exam.services.impl;

import final_exam.models.MedicalRecord;
import final_exam.models.NormalPatient;
import final_exam.services.IService;
import final_exam.utils.ReadAndWriteCSVFile;
import final_exam.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class NormalPatientServiceImpl implements IService {
    public static final String DATA_FILE_PATH = "src/final_exam/data/data.csv";
    public static final String MEDICAL_RECORD_CODE_REGEX = "^BA-\\d{3}$";
    public static final String PATIENT_CODE_REGEX = "^BN-\\d{3}$";
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String DATE_REGEX = "^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String POSITIVE_NUMBER_REGEX = "^[+]?\\d+$";

    Scanner sc = new Scanner(System.in);
    String dateOfAdmission;
    @Override
    public void add() {
        List<MedicalRecord> medicalRecordList = final_exam.utils.ReadAndWriteCSVFile.readCaseFromCSVFile(DATA_FILE_PATH);
        System.out.println("--------Add normal patient's medical record--------");

        int id;
        if (medicalRecordList.isEmpty()) {
            id = 1;
        } else {
            id = medicalRecordList.get(medicalRecordList.size()-1).getId() + 1;
        }

        String medicalRecordCode = inputMedicalRecordCode();

        String patientCode = inputPatientCode();

        String patientName = inputPatientName();

        dateOfAdmission = inputDateOfAdmission();

        String dateOfDischarge = inputDateOfDischarge();

        String reason = inputReason();

        Float fee = Float.valueOf(inputFee());

        NormalPatient normalPatient = new NormalPatient(id, medicalRecordCode, patientCode, patientName, dateOfAdmission, dateOfDischarge, reason, fee);
        List<MedicalRecord> medicalRecords = new LinkedList<>();
        medicalRecords.add(normalPatient);

        ReadAndWriteCSVFile.writeListToCSVFile(medicalRecords, DATA_FILE_PATH, true);
    }

    private String inputMedicalRecordCode() {
        System.out.print("Enter medical record code: ");
        return RegexData.regexStr(sc.nextLine(), MEDICAL_RECORD_CODE_REGEX, "Medical record code must be in the format BA-XXX where X is a natural number");
    }

    private String inputPatientCode() {
        System.out.print("Enter patient code: ");
        return RegexData.regexStr(sc.nextLine(), PATIENT_CODE_REGEX, "Patient code must be in the format BN-XXX where X is a natural number");
    }

    private String inputPatientName() {
        System.out.print("Enter patient name: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Patient name cannot have any extra spaces or no characters.");
    }

    private String inputDateOfAdmission() {
        System.out.print("Enter date of admission: ");
        return RegexData.regexStr(sc.nextLine(), DATE_REGEX, "Wrong format of date.");
    }

    private String inputDateOfDischarge() {
        System.out.print("Enter date of discharge: ");
        return RegexData.regexDateOfDischarge(sc.nextLine(), dateOfAdmission, DATE_REGEX);
    }

    private String inputReason() {
        System.out.print("Enter reason: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Reason cannot have any extra spaces or no characters.");
    }

    private String inputFee() {
        System.out.print("Enter fee: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Fee must be a positive number");
    }

}
