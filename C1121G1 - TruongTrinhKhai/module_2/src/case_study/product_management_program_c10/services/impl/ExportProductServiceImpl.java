package case_study.product_management_program_c10.services.impl;

import case_study.product_management_program_c10.models.ExportProduct;
import case_study.product_management_program_c10.models.ImportProduct;
import case_study.product_management_program_c10.models.Product;
import case_study.product_management_program_c10.services.IService;
import case_study.product_management_program_c10.utils.ReadAndWriteCSVFile;
import case_study.product_management_program_c10.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static case_study.product_management_program_c10.services.impl.ImportProductServiceImpl.*;

public class ExportProductServiceImpl implements IService {
    Scanner sc = new Scanner(System.in);
    static final String PRODUCT_FILE_PATH = "src/case_study/product_management_program_c10/data/Product.csv";

    @Override
    public void add() {
        List<Product> productList = ReadAndWriteCSVFile.readProductFromCSVFile(PRODUCT_FILE_PATH);
        System.out.println("--------Add new export product--------");

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

        int exportPrice = Integer.parseInt(inputExportPrice());

        String countryOfImport = inputCountryOfImport();

        ExportProduct exportProduct = new ExportProduct(id, code, name, price, quantity, manufacturer, exportPrice, countryOfImport);
        List<Product> products = new LinkedList<>();
        products.add(exportProduct);

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

    private String inputExportPrice() {
        System.out.print("Enter export price: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Export price must be a positive number.");
    }

    private String inputCountryOfImport() {
        System.out.print("Enter country of import: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Country of eimport cannot have any extra spaces or no characters");
    }
}
