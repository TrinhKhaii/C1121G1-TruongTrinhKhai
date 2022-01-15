package ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.service;

import ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.model.IncreasingPriceComparator;
import ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductService implements Service {
    static ArrayList<Product> productArrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void add() {

        System.out.print("Enter Id: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter product price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Enter product origin: ");
        String origin = sc.nextLine();

        productArrayList.add(new Product(id, name, price, origin));
        Collections.sort(productArrayList, new IncreasingPriceComparator());
    }

    @Override
    public void display() {
        if (productArrayList.isEmpty()) {
            System.out.println("Empty List");
        } else {
            int count = 0;
            for (Product product : productArrayList) {
                System.out.println("Product " + (++count));
                System.out.println(" Id: " + product.getId());
                System.out.println(" Name: " + product.getName());
                System.out.println(" Price: " + product.getPrice());
                System.out.println(" Origin: " + product.getOrigin());
                System.out.println("--------------------");
            }
        }
    }

    @Override
    public void edit(int id) {
        if (productArrayList.isEmpty()) {
            System.out.println("Empty List");
        } else {
            for (Product productService : productArrayList) {
                if (productService.getId() == id) {
                    System.out.println(productService);

                    System.out.println("Edit product information: ");
                    System.out.println("Current Id: " + productService.getId());
                    System.out.print("New id: ");
                    int newId = Integer.parseInt(sc.nextLine());
                    productService.setId(newId);

                    System.out.println("Current name: " + productService.getName());
                    System.out.print("New product name: ");
                    String newName = sc.nextLine();
                    productService.setName(newName);

                    System.out.println("Current price: " + productService.getPrice());
                    System.out.print("New price: ");
                    double newPrice = sc.nextDouble();
                    productService.setPrice(newPrice);

                    System.out.println("Current origin: " + productService.getOrigin());
                    System.out.print("New origin: ");
                    String newOrigin = sc.nextLine();
                    productService.setOrigin(newOrigin);
                } else {
                    System.out.println("Product List dont have product Id " + id);
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        boolean check = true;
        if (productArrayList.isEmpty()) {
            System.out.println("Empty List");
        } else {
            for (Product product : productArrayList) {
                if (product.getId() == id) {
                    productArrayList.remove(product);
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("Cant find product with id " + id);
        }
    }

    @Override
    public void search(String input) {
        ArrayList<Product>  resultOfSearchProduct = new ArrayList<>();
        for (Product product : productArrayList) {
            if (product.getName().contains(input)) {
                resultOfSearchProduct.add(product);
            }
        }
        System.out.println("Result of search: ");
        for (Product product : resultOfSearchProduct) {
            System.out.println(" Id: " + product.getId());
            System.out.println(" Name: " + product.getName());
            System.out.println(" Price: " + product.getPrice());
            System.out.println(" Origin: " + product.getOrigin());
            System.out.println("--------------------");
        }
    }


}
