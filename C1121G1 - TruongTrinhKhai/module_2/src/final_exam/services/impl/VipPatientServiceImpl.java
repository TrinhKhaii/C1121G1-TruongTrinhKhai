package final_exam.services.impl;

import final_exam.models.MedicalRecord;
import final_exam.models.VipPatient;
import final_exam.services.IService;
import final_exam.utils.ReadAndWriteCSVFile;
import final_exam.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static final_exam.services.impl.NormalPatientServiceImpl.*;

public class VipPatientServiceImpl implements IService {
    public static final String CHOICE_REGEX = "^\\d{1}$";

    Scanner sc = new Scanner(System.in);
    String dateOfAdmission;
    @Override
    public void add() {
        List<MedicalRecord> medicalRecordList = final_exam.utils.ReadAndWriteCSVFile.readCaseFromCSVFile(DATA_FILE_PATH);
        System.out.println("--------Add vip patient's medical record--------");

        int id;
        if (medicalRecordList.isEmpty()) {
            id = 1;
        } else {
            id = medicalRecordList.get(medicalRecordList.size() - 1).getId() + 1;
        }

        String medicalRecordCode = inputMedicalRecordCode();

        String patientCode = inputPatientCode();

        String patientName = inputPatientName();

        dateOfAdmission = inputDateOfAdmission();

        String dateOfDischarge = inputDateOfDischarge();

        String reason = inputReason();

        System.out.println("--------Vip type list--------");
        int count = 0;
        for (VipPatient.VipType vipType : VipPatient.VipType.values()) {
            System.out.println(++count + ". " + vipType);
        }
        String vipTypeChoice;
        String vipType = "";
        boolean flag2;
        do {
            do {
                System.out.print("Your choice: ");
                vipTypeChoice = sc.nextLine();
                if (!vipTypeChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.");
                }
            } while (!vipTypeChoice.matches(CHOICE_REGEX));
            flag2 = false;
            switch (Integer.parseInt(vipTypeChoice)) {
                case 1:
                    vipType = VipPatient.VipType.VIP1.getValue();
                    break;
                case 2:
                    vipType = VipPatient.VipType.VIP2.getValue();
                    break;
                case 3:
                    vipType = VipPatient.VipType.VIP3.getValue();
                    break;
                default:
                    System.out.println("Please enter from 1 to 3.");
                    flag2 = true;
            }
        } while (flag2);

        String vipDuration =inputVipDuration();

        VipPatient vipPatient = new VipPatient(id, medicalRecordCode, patientCode, patientName, dateOfAdmission, dateOfDischarge, reason, vipType, vipDuration);
        List<VipPatient> vipPatients = new LinkedList<>();
        vipPatients.add(vipPatient);

        ReadAndWriteCSVFile.writeListToCSVFile(vipPatients, DATA_FILE_PATH, true);
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

    private String inputVipDuration() {
        System.out.print("Enter vip duration: ");
        return RegexData.regexStr(sc.nextLine(), DATE_REGEX, "Wrong format of date.");
    }
}
