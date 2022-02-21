package final_exam.controllers;

import final_exam.services.impl.MedicalRecordServiceImpl;
import final_exam.services.impl.NormalPatientServiceImpl;
import final_exam.services.impl.VipPatientServiceImpl;

import java.util.Scanner;

public class CaseManagementProgram {
    private static final NormalPatientServiceImpl normalPatientService = new NormalPatientServiceImpl();
    private static final VipPatientServiceImpl vipPatientService = new VipPatientServiceImpl();
    private static final MedicalRecordServiceImpl medicalRecordService = new MedicalRecordServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("--------MEDICAL RECORD MANAGEMENT PROGRAM--------");
        boolean flag;
        do {
            flag = true;
            System.out.println();
            System.out.println("----------Menu----------\n" +
                    "1.\tAdd new medical record.\n" +
                    "2.\tDelete.\n" +
                    "3.\tView medical record list.\n" +
                    "4.\tExit.");
            int chooseMenu;
            while (true) {
                try {
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    chooseMenu = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            switch (chooseMenu) {
                case 1:
                    addNewMedicalRecord();
                    break;
                case 2:
                    deleteMedicalRecord();
                    break;
                case 3:
                    displayMedicalRecord();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    flag = false;
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 4.\n" +
                            "Please try again.\n");
            }
        } while (flag);
    }

    private void addNewMedicalRecord() {
        System.out.println("------Add menu------\n" +
                "1.\tAdd new normal patient.\n" +
                "2.\tAdd new vip patient.\n");
        int chooseAddMenu;
        boolean flag;
        do {
            flag = false;
            while (true) {
                try {
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    chooseAddMenu = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            switch (chooseAddMenu) {
                case 1:
                    normalPatientService.add();
                    System.out.println("Add new normal patient success!\n");
                    break;
                case 2:
                    vipPatientService.add();
                    System.out.println("Add new vip patient success!\n");
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 2.\n" +
                            "Please try again.\n");
                    flag = true;
            }
        } while (flag);
    }

    private void deleteMedicalRecord() {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter medical record code of patient you want to delete: ");
                String searchIMedicalRecordCode = sc.nextLine();
                medicalRecordService.delete(searchIMedicalRecordCode);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayMedicalRecord() {
        medicalRecordService.display();
    }

}
