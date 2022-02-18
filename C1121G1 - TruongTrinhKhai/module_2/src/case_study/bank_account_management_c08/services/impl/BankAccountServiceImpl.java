package case_study.bank_account_management_c08.services.impl;

import case_study.bank_account_management_c08.models.Bank;
import case_study.bank_account_management_c08.models.CheckingBankAccount;
import case_study.bank_account_management_c08.models.SavingsBankAccount;
import case_study.bank_account_management_c08.services.IService2;
import case_study.bank_account_management_c08.utils.ReadAndWriteCSVFile;
import case_study.product_management_program_c10.models.ExportProduct;
import case_study.product_management_program_c10.models.ImportProduct;
import case_study.product_management_program_c10.models.Product;
import case_study.product_management_program_c10.utils.Exceptions;

import java.util.List;
import java.util.Scanner;

import static case_study.bank_account_management_c08.services.impl.CheckingBankAccountServiceImpl.BANK_ACCOUNT_FILE_PATH;

public class BankAccountServiceImpl implements IService2 {
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        List<Bank> bankList = ReadAndWriteCSVFile.readBankAccountFromCSVFile(BANK_ACCOUNT_FILE_PATH);
        if (bankList.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("---------Product list---------");
            for (Bank bankAccount: bankList) {
                System.out.println("Id: " + bankAccount.getId());
                System.out.println("Code: " + bankAccount.getCode());
                System.out.println("Name: " + bankAccount.getName());
                System.out.println("Creation date: " + bankAccount.getCreationDate());
                if (bankAccount instanceof CheckingBankAccount) {
                    System.out.println("Card number: " + ((CheckingBankAccount) bankAccount).getCardNumber());
                    System.out.println("Account balance: " + ((CheckingBankAccount) bankAccount).getAccountBalance());
                    System.out.println("\t-------------------------");
                } else if (bankAccount instanceof SavingsBankAccount) {
                    System.out.println("Savings deposit amount: " + ((SavingsBankAccount) bankAccount).getSavingsDepositAmount());
                    System.out.println("Savings date: " + ((SavingsBankAccount) bankAccount).getSavingsDate());
                    System.out.println("Interest rate: " + ((SavingsBankAccount) bankAccount).getInterestRate());
                    System.out.println("Term: " + ((SavingsBankAccount) bankAccount).getTerm());
                    System.out.println("\t-------------------------");
                }
            }
        }
    }

    @Override
    public void search(String code) {
        List<Bank> bankList = ReadAndWriteCSVFile.readBankAccountFromCSVFile(BANK_ACCOUNT_FILE_PATH);
        boolean check = false;
        for (Bank bankAccount: bankList) {
            if (bankAccount.getCode().contains(code)) {
                check = true;
                System.out.println("Id: " + bankAccount.getId());
                System.out.println("Code: " + bankAccount.getCode());
                System.out.println("Name: " + bankAccount.getName());
                System.out.println("Creation date: " + bankAccount.getCreationDate());
                if (bankAccount instanceof CheckingBankAccount) {
                    System.out.println("Card number: " + ((CheckingBankAccount) bankAccount).getCardNumber());
                    System.out.println("Account balance: " + ((CheckingBankAccount) bankAccount).getAccountBalance());
                    System.out.println("\t-------------------------");
                } else if (bankAccount instanceof SavingsBankAccount) {
                    System.out.println("Savings deposit amount: " + ((SavingsBankAccount) bankAccount).getSavingsDepositAmount());
                    System.out.println("Savings date: " + ((SavingsBankAccount) bankAccount).getSavingsDate());
                    System.out.println("Interest rate: " + ((SavingsBankAccount) bankAccount).getInterestRate());
                    System.out.println("Term: " + ((SavingsBankAccount) bankAccount).getTerm());
                    System.out.println("\t-------------------------");
                }
            }
        }
        if (!check) {
            System.out.println("Bank account id does not exist.");
        }
    }

    @Override
    public void delete(int id) {
        try {
            int index = 0;
            List<Bank> bankList = ReadAndWriteCSVFile.readBankAccountFromCSVFile(BANK_ACCOUNT_FILE_PATH);
            boolean check = false;
            for (int i = 0; i < bankList.size(); i++) {
                if (bankList.get(i).getId() == id) {
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
                            bankList.remove(index);
                            System.out.println("Phone list: ");
                            System.out.println(bankList);
                            ReadAndWriteCSVFile.writeListToCSVFile(bankList, BANK_ACCOUNT_FILE_PATH, false);
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
                Exceptions.NotFoundProductException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
