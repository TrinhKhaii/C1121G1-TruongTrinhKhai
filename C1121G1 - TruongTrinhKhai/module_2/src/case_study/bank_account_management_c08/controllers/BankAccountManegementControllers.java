package case_study.bank_account_management_c08.controllers;

import case_study.bank_account_management_c08.services.impl.BankAccountServiceImpl;
import case_study.bank_account_management_c08.services.impl.CheckingBankAccountServiceImpl;
import case_study.bank_account_management_c08.services.impl.SavingsBankAccountServiceImpl;

import java.util.Scanner;

public class BankAccountManegementControllers {
    private static final CheckingBankAccountServiceImpl checkingBankAccount = new CheckingBankAccountServiceImpl();
    private static final SavingsBankAccountServiceImpl savingsBankAccount = new SavingsBankAccountServiceImpl();
    private static final BankAccountServiceImpl bankAccount = new BankAccountServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("--------BANK ACCOUNT MANAGEMENT PROGRAM--------");
        boolean flag;
        do {
            flag = true;
            System.out.println();
            System.out.println("----------Menu----------\n" +
                    "1.\tAdd new.\n" +
                    "2.\tDelete.\n" +
                    "3.\tView account list.\n" +
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
                    addNewBankAccount();
                    break;
                case 2:
                    deleteBankAccount();
                    break;
                case 3:
                    displayBankAccountList();
                    break;
                case 4:
                    searchBankAccount();
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

    private void addNewBankAccount() {
        System.out.println("------Add menu------\n" +
                "1.\tAdd new checking bank account.\n" +
                "2.\tAdd new savings bank account.\n");
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
                    checkingBankAccount.add();
                    System.out.println("Add new import product success!\n");
                    break;
                case 2:
                    savingsBankAccount.add();
                    System.out.println("Add new export product success!\n");
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 2.\n" +
                            "Please try again.\n");
                    flag = true;
            }
        } while (flag);
    }

    private void deleteBankAccount() {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter id of bank account you want to delete: ");
                int searchId = Integer.parseInt(sc.nextLine());
                bankAccount.delete(searchId);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayBankAccountList() {
        bankAccount.display();
    }

    private void searchBankAccount() {
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter code of bank account you want to search: ");
                String searchCode = sc.nextLine();
                bankAccount.search(searchCode);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
