package case_study.bank_account_management_c08.services.impl;

import case_study.bank_account_management_c08.models.Bank;

import case_study.bank_account_management_c08.models.SavingsBankAccount;
import case_study.bank_account_management_c08.services.IService;
import case_study.bank_account_management_c08.utils.ReadAndWriteCSVFile;
import case_study.bank_account_management_c08.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static case_study.bank_account_management_c08.services.impl.CheckingBankAccountServiceImpl.*;

public class SavingsBankAccountServiceImpl implements IService {
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        List<Bank> bankList = case_study.bank_account_management_c08.utils.ReadAndWriteCSVFile.readBankAccountFromCSVFile(BANK_ACCOUNT_FILE_PATH);
        System.out.println("--------Add new savings bank account--------");

        int id;
        if (bankList.isEmpty()) {
            id = 1;
        } else {
            id = bankList.get(bankList.size()-1).getId() + 1;
        }

        String code = inputCode();

        String name = inputName();

        String creationDate = inputCreationDate();

        int savingsDepositAmount = Integer.parseInt(inputSavingsDepositAmount());

        String savingsDate = inputSavingsDate();

        int interestRate = Integer.parseInt(inputInterestRate());

        int term = Integer.parseInt(inputTerm());

        SavingsBankAccount savingsBankAccount = new SavingsBankAccount(id, code, name, creationDate, savingsDepositAmount, savingsDate, interestRate, term);
        List<Bank> banks = new LinkedList<>();
        banks.add(savingsBankAccount);

        ReadAndWriteCSVFile.writeListToCSVFile(banks, BANK_ACCOUNT_FILE_PATH, true);
    }

    private String inputCode() {
        System.out.print("Enter code: ");
        return RegexData.regexStr(sc.nextLine(), CODE_REGEX, "The account code must be an 9 digit number");
    }

    private String inputName() {
        System.out.print("Enter name: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Name cannot have any extra spaces or no characters");
    }

    private String inputCreationDate() {
        System.out.print("Enter creation date: ");
        return RegexData.regexStr(sc.nextLine(), DATE_REGEX, "Date must be in dd/mm/yyyy format");
    }

    private String inputSavingsDepositAmount() {
        System.out.print("Enter savings deposit amount: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "The amount must be a positive number");
    }

    private String inputSavingsDate() {
        System.out.print("Enter savings date: ");
        return RegexData.regexStr(sc.nextLine(), DATE_REGEX, "Date must be in dd/mm/yyyy format");
    }

    private String inputInterestRate() {
        System.out.print("Enter interest rate: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "The interest rate must be a positive number");
    }

    private String inputTerm() {
        System.out.print("Enter term: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Term must be a positive number");
    }
}
