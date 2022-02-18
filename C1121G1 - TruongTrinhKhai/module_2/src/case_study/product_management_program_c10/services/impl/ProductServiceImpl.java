package case_study.product_management_program_c10.services.impl;

import case_study.phone_management_program_c09.models.GenuinePhone;
import case_study.phone_management_program_c09.models.Phone;
import case_study.phone_management_program_c09.models.PortablePhone;
import case_study.product_management_program_c10.models.ExportProduct;
import case_study.product_management_program_c10.models.ImportProduct;
import case_study.product_management_program_c10.models.Product;
import case_study.product_management_program_c10.services.IService2;
import case_study.product_management_program_c10.utils.Exceptions;
import case_study.product_management_program_c10.utils.ReadAndWriteCSVFile;

import java.util.List;
import java.util.Scanner;


import static case_study.product_management_program_c10.services.impl.ExportProductServiceImpl.PRODUCT_FILE_PATH;

public class ProductServiceImpl implements IService2 {
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        List<Product> productList = ReadAndWriteCSVFile.readProductFromCSVFile(PRODUCT_FILE_PATH);
        if (productList.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("---------Product list---------");
            for (Product product: productList) {
                System.out.println("Id: " + product.getId());
                System.out.println("Code: " + product.getCode());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Manufacturer: " + product.getManufacturer());
                if (product instanceof ImportProduct) {
                    System.out.println("Import price: " + ((ImportProduct)product).getImportPrice());
                    System.out.println("Import province: " + ((ImportProduct)product).getImportProvince());
                    System.out.println("Import tax: " + ((ImportProduct)product).getImportTax());
                    System.out.println("\t-------------------------");
                } else if (product instanceof ExportProduct) {
                    System.out.println("Export price: " + ((ExportProduct)product).getExportPrice());
                    System.out.println("Country of import: " + ((ExportProduct)product).getCountryOfImport());
                    System.out.println("\t-------------------------");
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            int index = 0;
            List<Product> productList = ReadAndWriteCSVFile.readProductFromCSVFile(PRODUCT_FILE_PATH);
            boolean check = false;
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
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
                            productList.remove(index);
                            System.out.println("Phone list: ");
                            System.out.println(productList);
                            ReadAndWriteCSVFile.writeListToCSVFile(productList, PRODUCT_FILE_PATH, false);
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

    @Override
    public void search(String code) {
        List<Product> productList = ReadAndWriteCSVFile.readProductFromCSVFile(PRODUCT_FILE_PATH);
        boolean check = false;
        for (Product product: productList) {
            if (product.getCode().contains(code)) {
                check = true;
                System.out.println("\t-------------------------");
                System.out.println("Id: " + product.getId());
                System.out.println("Code: " + product.getCode());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Manufacturer: " + product.getManufacturer());
                if (product instanceof ImportProduct) {
                    System.out.println("Import price: " + ((ImportProduct)product).getImportPrice());
                    System.out.println("Import province: " + ((ImportProduct)product).getImportProvince());
                    System.out.println("Import tax: " + ((ImportProduct)product).getImportTax());
                    System.out.println("\t-------------------------");
                } else if (product instanceof ExportProduct) {
                    System.out.println("Export price: " + ((ExportProduct) product).getExportPrice());
                    System.out.println("Country of import: " + ((ExportProduct) product).getCountryOfImport());
                    System.out.println("\t-------------------------");
                }
            }
        }
        if (!check) {
            System.out.println("Product id does not exist.");
        }
    }
}
