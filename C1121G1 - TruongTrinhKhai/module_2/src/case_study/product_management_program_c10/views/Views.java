package case_study.product_management_program_c10.views;

import case_study.product_management_program_c10.controllers.ProductManagementControllers;

public class Views {
    public static void main(String[] args) {
        ProductManagementControllers productManagementControllers = new ProductManagementControllers();
        productManagementControllers.displayMainMenu();
    }
}
