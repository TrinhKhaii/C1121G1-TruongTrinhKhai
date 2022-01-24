package ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.controller;


import ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class MainMenu {
    public void mainMenu() {
        ProductServiceImpl productService = new ProductServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int chooseMenu;
        boolean flag = true;
        do {
            System.out.println("Menu:");
            System.out.println(" 1.Add\n" +
                    " 2.Display\n" +
                    " 3.Search by name\n" +
                    " 4.Exit\n");
            System.out.print("Your choose: ");
            chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    productService.add();
                    System.out.println("Add success!");
                    break;
                case 2:
                    productService.display();
                    System.out.println("Display success!");
                    break;
                case 3:
                    productService.search();
                    System.out.println("Search success!");
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Please try again!");
            }
        } while (flag);
    }
}


