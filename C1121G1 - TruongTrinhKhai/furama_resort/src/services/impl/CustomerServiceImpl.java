//
// created by Trinh Khai at 16:50 26/1/2022
//

package services.impl;

import models.Customer;
import services.ICustomerService;
import utils.ReadAndWriteCSVFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static controllers.FuramaController.CHOICE_REGEX;

public class CustomerServiceImpl implements ICustomerService {
    public static final String CUSTOMER_FILE_PATH = "src/data/Customer.csv";
    public static final String EDIT_REGEX = "^\\d{1,2}$";
    Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        System.out.println("-------Add new customer-------");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter date of birth: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter cmnd: ");
        String cmnd = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        // Customer type
        System.out.println("--------Customer type list--------");
        int count = 0;
        for (Customer.CustomerType customerType : Customer.CustomerType.values()) {
            System.out.println(++count + ". " + customerType);
        }
        String customerTypeChoice;
        String customerType = "";
        boolean flag2;
        do {
            do {
                System.out.print("Your choice: ");
                customerTypeChoice = sc.nextLine();
                if (!customerTypeChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.");
                }
            } while (!customerTypeChoice.matches(CHOICE_REGEX));
            flag2 = false;
            switch (Integer.parseInt(customerTypeChoice)) {
                case 1:
                    customerType = Customer.CustomerType.DIAMOND.getValue();
                    break;
                case 2:
                    customerType = Customer.CustomerType.PLATIUM.getValue();
                    break;
                case 3:
                    customerType = Customer.CustomerType.GOLD.getValue();
                    break;
                case 4:
                    customerType = Customer.CustomerType.SILVER.getValue();
                    break;
                case 5:
                    customerType = Customer.CustomerType.MEMBER.getValue();
                    break;
                default:
                    System.out.println("Please enter from 1 to 5.");
                    flag2 = true;
            }
        } while (flag2);

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        Customer newCustomer = new Customer(id, name, dateOfBirth, gender, cmnd, phoneNumber, email, customerType, address);
        List<Customer> customerList = new LinkedList<>();
        customerList.add(newCustomer);
        ReadAndWriteCSVFile.writeListToCSVFile(customerList, CUSTOMER_FILE_PATH, true);
    }

    @Override
    public void display() {
        List<Customer> customerList = ReadAndWriteCSVFile.readCustomerFromCVSFile(CUSTOMER_FILE_PATH);
        if (customerList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("-----------Customer list-----------");
            int count = 0;
            for (Customer customer : customerList) {
                System.out.println("Customer " + ++count);
                System.out.println("Id: " + customer.getId());
                System.out.println("Name: " + customer.getName());
                System.out.println("Date of birth: " + customer.getDateOfBirth());
                System.out.println("Gender: " + customer.getGender());
                System.out.println("Cmnd: " + customer.getCmnd());
                System.out.println("Phone number: " + customer.getPhoneNumber());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Customer type: " + customer.getCustomerType());
                System.out.println("Address: " + customer.getAddress());
                System.out.println("------------------------");
            }
        }
    }

    @Override
    public void edit() {
        List<Customer> customerList = ReadAndWriteCSVFile.readCustomerFromCVSFile(CUSTOMER_FILE_PATH);
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + ". " + customerList.get(i));
        }
        String id;
        do {
            System.out.print("Enter customer id to edit: ");
            id = sc.nextLine();
            if (!id.matches(EDIT_REGEX)) {
                System.out.println("Please try again.\n");
            }
        } while (!id.matches(EDIT_REGEX));
        boolean check = false;
        int index = -1;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == Integer.parseInt(id)) {
                check = true;
                index = i;
                break;
            }
        }
        if (!check) {
            System.out.println("Your input id does not exist in the list.");
        } else {
            String editChoice;
            boolean flag = true;
            do {
                System.out.println("Select the information to edit: ");
                System.out.println("1. Id.\n" +
                        "2. Name.\n" +
                        "3. Date of birth.\n" +
                        "4. Gender.\n" +
                        "5. Cmnd.\n" +
                        "6. Phone number.\n" +
                        "7. Email.\n" +
                        "8. Customer type.\n" +
                        "9. Address.\n" +
                        "10.OK.");
                do {
                    System.out.print("Your choice: ");
                    editChoice = sc.nextLine();
                    if (!editChoice.matches(EDIT_REGEX)) {
                        System.out.println("Please try again.\n");
                    }
                } while (!editChoice.matches(EDIT_REGEX));
                switch (Integer.parseInt(editChoice)) {
                    case 1:
                        System.out.println("Current id: " + customerList.get(index).getId());
                        System.out.print("Enter new id: ");
                        int newId = Integer.parseInt(sc.nextLine());
                        customerList.get(index).setId(newId);
                        break;
                    case 2:
                        System.out.println("Current name: " + customerList.get(index).getName());
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        customerList.get(index).setName(newName);
                        break;
                    case 3:
                        System.out.println("Current date of birth: " + customerList.get(index).getDateOfBirth());
                        System.out.print("Enter new date of birth: ");
                        String newDateOfBirth = sc.nextLine();
                        customerList.get(index).setDateOfBirth(newDateOfBirth);
                        break;
                    case 4:
                        System.out.println("Current gender: " + customerList.get(index).getGender());
                        System.out.print("Enter new gender: ");
                        String newGender = sc.nextLine();
                        customerList.get(index).setGender(newGender);
                        break;
                    case 5:
                        System.out.println("Current cmnd: " + customerList.get(index).getCmnd());
                        System.out.print("Enter new cmnd: ");
                        String newCmnd = sc.nextLine();
                        customerList.get(index).setCmnd(newCmnd);
                        break;
                    case 6:
                        System.out.println("Current phone number: " + customerList.get(index).getPhoneNumber());
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = sc.nextLine();
                        customerList.get(index).setPhoneNumber(newPhoneNumber);
                        break;
                    case 7:
                        System.out.println("Current email: " + customerList.get(index).getEmail());
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        customerList.get(index).setEmail(newEmail);
                        break;
                    case 8:
                        System.out.println("Current customer type: " + customerList.get(index).getCustomerType());
                        System.out.println("--------Customer type list--------");
                        int count = 0;
                        for (Customer.CustomerType customerType : Customer.CustomerType.values()) {
                            System.out.println(++count + ". " + customerType);
                        }
                        String customerTypeChoice;
                        String customerType = "";
                        boolean flag2;
                        do {
                            do {
                                System.out.print("Your new choice: ");
                                customerTypeChoice = sc.nextLine();
                                if (!customerTypeChoice.matches(CHOICE_REGEX)) {
                                    System.out.print("Please try again.");
                                }
                            } while (!customerTypeChoice.matches(CHOICE_REGEX));
                            flag2 = false;
                            switch (Integer.parseInt(customerTypeChoice)) {
                                case 1:
                                    customerType = Customer.CustomerType.DIAMOND.getValue();
                                    break;
                                case 2:
                                    customerType = Customer.CustomerType.PLATIUM.getValue();
                                    break;
                                case 3:
                                    customerType = Customer.CustomerType.GOLD.getValue();
                                    break;
                                case 4:
                                    customerType = Customer.CustomerType.SILVER.getValue();
                                    break;
                                case 5:
                                    customerType = Customer.CustomerType.MEMBER.getValue();
                                    break;
                                default:
                                    System.out.println("Please enter from 1 to 5.");
                                    flag2 = true;
                            }
                        } while (flag2);
                        customerList.get(index).setCustomerType(customerType);
                        break;
                    case 9:
                        System.out.println("Current address: " + customerList.get(index).getAddress());
                        System.out.print("Enter new address: ");
                        String newAddress = sc.nextLine();
                        customerList.get(index).setAddress(newAddress);
                        break;
                    case 10:
                        flag = false;
                        break;
                    default:
                        System.out.println("Please enter from 1 to 10.");
                }
            } while (flag);
            ReadAndWriteCSVFile.writeListToCSVFile(customerList, CUSTOMER_FILE_PATH, false);
        }
    }
}
