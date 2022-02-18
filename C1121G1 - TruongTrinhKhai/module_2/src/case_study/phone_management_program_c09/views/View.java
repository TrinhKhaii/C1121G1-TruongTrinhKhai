package case_study.phone_management_program_c09.views;

import case_study.phone_management_program_c09.controllers.PhoneManagementControllers;

public class View {
    public static void main(String[] args) {
        PhoneManagementControllers phoneManagementControllers = new PhoneManagementControllers();
        phoneManagementControllers.displayMainMenu();
    }
}
