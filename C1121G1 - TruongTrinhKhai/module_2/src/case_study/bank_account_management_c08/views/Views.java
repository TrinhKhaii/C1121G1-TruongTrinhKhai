package case_study.bank_account_management_c08.views;

import case_study.bank_account_management_c08.controllers.BankAccountManegementControllers;

public class Views {
    public static void main(String[] args) {
        BankAccountManegementControllers bankAccountManegementControllers = new BankAccountManegementControllers();
        bankAccountManegementControllers.displayMainMenu();
    }
}
