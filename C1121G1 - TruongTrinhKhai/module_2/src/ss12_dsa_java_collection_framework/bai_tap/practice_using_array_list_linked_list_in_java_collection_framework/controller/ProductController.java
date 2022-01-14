package ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.controller;

import ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.service.ProductService;

import java.util.Scanner;

public class ProductController {
    static ProductService productService = new ProductService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        boolean flag = true;
        do {
            System.out.println(" Menu product manager: \n" +
                    "1. Add.\n" +
                    "2. Display.\n" +
                    "3. Edit.\n" +
                    "4. Delete.\n" +
                    "5. Search.\n" +
                    "6. Exit.\n");
            System.out.print("Your choice: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu) {
                case 1:
                    productService.add();
                    System.out.println("Add success!\n");
                    break;
                case 2:
                    productService.display();
                    System.out.println("Display success!\n");
                    break;
                case 3:
                    System.out.print("Enter the Student Id you want to edit: ");
                    int editId = sc.nextInt();
                    productService.edit(editId);
                    System.out.println("Edit success!\n");
                    break;
                case 4:
                    System.out.print("Enter the product id you want to delete: ");
                    int deleteId = sc.nextInt();
                    productService.delete(deleteId);
                    System.out.println("Delete success!\n");
                    break;
                case 5:
                    System.out.print("Enter the product name you want to search: ");
                    String searchName = sc.nextLine();
                    productService.search(searchName);
                    System.out.println("Search success!\n");
                    break;
                default:
                    flag = false;
            }
        } while (flag);


    }
}
