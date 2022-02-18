package case_study.product_management_program_c10.services.impl;

import case_study.product_management_program_c10.models.ImportProduct;
import case_study.product_management_program_c10.models.Product;
import case_study.product_management_program_c10.services.IService;
import case_study.product_management_program_c10.utils.ReadAndWriteCSVFile;
import case_study.product_management_program_c10.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ImportProductServiceImpl implements IService {
    public static final String POSITIVE_NUMBER_REGEX = "^[+]?\\d+$";
    public static final String CODE_REGEX = "^SP\\d{5}$";
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";

    Scanner sc = new Scanner(System.in);
    static final String PRODUCT_FILE_PATH = "src/case_study/product_management_program_c10/data/Product.csv";

    @Override
    public void add() {
        List<Product> productList = ReadAndWriteCSVFile.readProductFromCSVFile(PRODUCT_FILE_PATH);
        System.out.println("--------Add new import product--------");

        int id;
        if (productList.isEmpty()) {
            id = 1;
        } else {
            id = productList.get(productList.size()-1).getId() + 1;
        }

        String code = inputCode();

        String name = inputName();

        int price = Integer.parseInt(inputPrice());

        int quantity = Integer.parseInt(inputQuantity());

        String manufacturer = inputManufacturer();

        int importPrice = Integer.parseInt(inputImportPrice());

        String importProvince = inputImportProvince();

        int importTax = Integer.parseInt(inputImportTax());

        ImportProduct importProduct = new ImportProduct(id, code, name, price, quantity, manufacturer, importPrice, importProvince, importTax);
        List<Product> products = new LinkedList<>();
        products.add(importProduct);

        ReadAndWriteCSVFile.writeListToCSVFile(products, PRODUCT_FILE_PATH, true);
    }

    private String inputCode() {
        System.out.print("Enter code: ");
        return RegexData.regexStr(sc.nextLine(), CODE_REGEX, "Product code must be in the format SPXXXXX where X is a natural number");
    }

    private String inputName() {
        System.out.print("Enter name: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Name cannot have any extra spaces or no characters");
    }

    private String inputPrice() {
        System.out.print("Enter price: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Price must be a positive number.");
    }

    private String inputQuantity() {
        System.out.print("Enter quantity: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Quantity must be a positive number.");
    }

    private String inputManufacturer() {
        System.out.print("Enter manufacturer: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Manufacturer cannot have any extra spaces or no characters");
    }

    private String inputImportPrice() {
        System.out.print("Enter import price: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Import price must be a positive number.");
    }

    private String inputImportProvince() {
        System.out.println("Enter import province: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Import province cannot have any extra spaces or no characters");
    }

    private String inputImportTax() {
        System.out.print("Enter import tax: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Import tax must be a positive number.");
    }
}
