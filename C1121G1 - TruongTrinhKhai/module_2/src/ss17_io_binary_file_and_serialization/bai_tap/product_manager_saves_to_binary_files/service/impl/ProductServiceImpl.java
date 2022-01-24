package ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.service.impl;

import ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.model.Product;
import ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.service.IProductService;
import ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.util.ReadAndWriteCSVFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements IProductService {
    private static final String PRODUCT_PATH_FILE = "src/ss17_io_binary_file_and_serialization/bai_tap/product_manager_saves_to_binary_files/data/Product.csv";
    static List<Product> productList = new ArrayList<>();

    static {
        if (PRODUCT_PATH_FILE.length() == 0) {
            productList.add(new Product(1, "Tương ớt", "Chinsu", 15000));
            productList.add(new Product(2, "Tương cà", "Cholimex", 20000));
            productList.add(new Product(3, "Dầu ăn", "Neptune", 50000));

            ReadAndWriteCSVFile.writeObjectProductListToBinaryFile(productList, PRODUCT_PATH_FILE);
        }
    }

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new product information: ");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product newProduct = new Product(id, name, manufacturer, price);
        List<Product> productList1 = ReadAndWriteCSVFile.readObjectProductListToFromBiranyFile(PRODUCT_PATH_FILE);
        productList1.add(newProduct);
        ReadAndWriteCSVFile.writeObjectProductListToBinaryFile(productList1, PRODUCT_PATH_FILE);
    }

    @Override
    public void display() {
        List<Product> productList = ReadAndWriteCSVFile.readObjectProductListToFromBiranyFile(PRODUCT_PATH_FILE);
        for (Product product: productList) {
            System.out.println(product);
        }
    }

    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = ReadAndWriteCSVFile.readObjectProductListToFromBiranyFile(PRODUCT_PATH_FILE);
        System.out.print("Enter name of product you want to search: ");
        String searchName = sc.nextLine();
        System.out.println("Result of search: ");
        for (Product product: productList) {
            if (product.getName().contains(searchName)) {
                System.out.println(product);
            }
        }
    }
}
