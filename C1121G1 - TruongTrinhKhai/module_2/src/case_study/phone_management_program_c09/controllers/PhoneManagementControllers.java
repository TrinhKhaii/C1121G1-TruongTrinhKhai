package case_study.phone_management_program_c09.controllers;

import case_study.phone_management_program_c09.services.impl.GenuinePhoneServiceImpl;
import case_study.phone_management_program_c09.services.impl.PhoneServiceImpl;
import case_study.phone_management_program_c09.services.impl.PortablePhoneServiceImpl;

import java.util.Scanner;

public class PhoneManagementControllers {
    private static final GenuinePhoneServiceImpl genuinePhone = new GenuinePhoneServiceImpl();
    private static final PortablePhoneServiceImpl portablePhone = new PortablePhoneServiceImpl();
    private static final PhoneServiceImpl phone = new PhoneServiceImpl();
    static Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("--------PHONE MANAGEMENT PROGRAM--------");
        boolean flag;
        do {
            flag = true;
            System.out.println();
            System.out.println("----------Menu----------\n" +
                    "1.\tAdd new.\n" +
                    "2.\tDelete.\n" +
                    "3.\tView phone list.\n" +
                    "4.\tSearch.\n" +
                    "5.\tExit.");
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
                    addNewPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    displayPhoneList();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    flag = false;
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 5.\n" +
                            "Please try again.\n");
            }
        } while (flag);
    }

    private static void addNewPhone() {
        System.out.println("------Add menu------\n" +
                "1.\tAdd genuine phone.\n" +
                "2.\tAdd portable phone.\n");
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
                    genuinePhone.add();
                    System.out.println("Add new genuine phone success!\n");
                    break;
                case 2:
                    portablePhone.add();
                    System.out.println("Add new portable phone success!\n");
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 5.\n" +
                            "Please try again.\n");
                    flag = true;
            }
        } while (flag);
    }

    private static void displayPhoneList() {
        System.out.println("------------Phone list------------");
        phone.display();
    }

    private static void deletePhone() {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter id of phone you want to delete: ");
                int id = Integer.parseInt(sc.nextLine());
                phone.delete(id);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private static void searchPhone() {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter id of phone you want to search: ");
                int searchId = Integer.parseInt(sc.nextLine());
                phone.search(searchId);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
