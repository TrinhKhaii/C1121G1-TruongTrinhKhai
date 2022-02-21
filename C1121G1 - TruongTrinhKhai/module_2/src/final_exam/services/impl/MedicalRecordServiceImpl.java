package final_exam.services.impl;

import final_exam.models.MedicalRecord;
import final_exam.models.NormalPatient;
import final_exam.models.VipPatient;
import final_exam.services.IService2;
import final_exam.utils.exceptions.Exceptions;
import final_exam.utils.ReadAndWriteCSVFile;

import java.util.List;
import java.util.Scanner;

import static final_exam.services.impl.NormalPatientServiceImpl.DATA_FILE_PATH;

public class MedicalRecordServiceImpl implements IService2 {
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        List<MedicalRecord> medicalRecordList = ReadAndWriteCSVFile.readCaseFromCSVFile(DATA_FILE_PATH);
        if (medicalRecordList.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("---------Product list---------");
            for (MedicalRecord medicalRecord: medicalRecordList) {
                System.out.println("Id: " + medicalRecord.getId());
                System.out.println("Medical record code: " + medicalRecord.getMedicalRecordCode());
                System.out.println("Patient code: " + medicalRecord.getPatientCode());
                System.out.println("Patient name: " + medicalRecord.getPatientName());
                System.out.println("Date of admission: " + medicalRecord.getDateOfAdmission());
                System.out.println("Date of discharge: " + medicalRecord.getDateOfDischarge());
                System.out.println("Reason: " + medicalRecord.getReason());
                if (medicalRecord instanceof NormalPatient) {
                    System.out.println("Fee: " + ((NormalPatient)medicalRecord).getFee());
                    System.out.println("\t-------------------------");
                } else if (medicalRecord instanceof VipPatient) {
                    System.out.println("Vip type: " + ((VipPatient)medicalRecord).getVipType());
                    System.out.println("Vip duration: " + ((VipPatient)medicalRecord).getVipDuration());
                    System.out.println("\t-------------------------");
                }
            }
        }
    }

    @Override
    public void delete(String medicalRecordCode) {
        try {
            int index = 0;
            List<MedicalRecord> medicalRecords = ReadAndWriteCSVFile.readCaseFromCSVFile(DATA_FILE_PATH);
            boolean check = false;
            for (int i = 0; i < medicalRecords.size(); i++) {
                if (medicalRecords.get(i).getMedicalRecordCode().equals(medicalRecordCode)) {
                    index = i;
                    check = true;
                    break;
                }
            }
            if (check) {
                boolean flag = false;
                do {
                    flag = false;
                    int option = 0;
                    try {
                        System.out.println("Are you sure?");
                        System.out.println("1\tYes.");
                        System.out.println("2\tNo.");
                        option = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    switch (option) {
                        case 1:
                            medicalRecords.remove(index);
                            System.out.println("Medical record list after delete: ");
                            System.out.println(medicalRecords);
                            ReadAndWriteCSVFile.writeListToCSVFile(medicalRecords, DATA_FILE_PATH, false);
                            break;
                        case 2:
                            break;
                        default:
                            flag = true;
                            System.out.println("Your choice must be from 1 to 2");
                            System.out.println("Please try again.\n");
                    }
                } while (flag);
            } else {
                Exceptions.NotFoundMedicalRecordException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
