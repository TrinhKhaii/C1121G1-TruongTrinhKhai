package case_study.bank_account_management_c08.services.impl;

import case_study.bank_account_management_c08.models.Bank;
import case_study.bank_account_management_c08.models.CheckingBankAccount;
import case_study.bank_account_management_c08.services.IService;
import case_study.bank_account_management_c08.utils.ReadAndWriteCSVFile;
import case_study.bank_account_management_c08.utils.RegexData;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CheckingBankAccountServiceImpl implements IService {
    public static final String BANK_ACCOUNT_FILE_PATH = "src/case_study/bank_account_management_c08/data/BankAccount.csv";
    static final String CODE_REGEX = "^\\d{9}$";
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
    private static final String CARD_NUMBER_REGEX = "^\\d{16}$";
    public static final String POSITIVE_NUMBER_REGEX = "^[+]?\\d+$";
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        List<Bank> bankList = case_study.bank_account_management_c08.utils.ReadAndWriteCSVFile.readBankAccountFromCSVFile(BANK_ACCOUNT_FILE_PATH);
        System.out.println("--------Add new checking bank account--------");

        int id;
        if (bankList.isEmpty()) {
            id = 1;
        } else {
            id = bankList.get(bankList.size() - 1).getId() + 1;
        }

        String code = inputCode();

        String name = inputName();

        String creationDate = inputCreationDate();

        Long cardNumber = Long.parseLong(inputCardNumber());

        int accountBalance = Integer.parseInt(inputAccountBalance());

        CheckingBankAccount checkingBankAccount = new CheckingBankAccount(id, code, name, creationDate, cardNumber, accountBalance);
        List<Bank> banks = new LinkedList<>();
        banks.add(checkingBankAccount);

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

    private String inputCardNumber() {
        System.out.print("Enter card number: ");
        return RegexData.regexStr(sc.nextLine(), CARD_NUMBER_REGEX, "The account code must be an 16 digit number");
    }

    private String inputAccountBalance() {
        System.out.print("Enter account balance: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "The balance must be a positive number");
    }
}