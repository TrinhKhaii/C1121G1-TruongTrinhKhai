//
// created by Trinh Khai at 16:50 26/1/2022
//

package services.impl;

import models.Customer;
import services.ICustomerService;
import utils.ReadAndWriteCSVFile;
import utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static controllers.FuramaController.CHOICE_REGEX;

public class CustomerServiceImpl implements ICustomerService {
    public static final String CUSTOMER_FILE_PATH = "src/data/Customer.csv";
    public static final String EDIT_REGEX = "^\\d{1,2}$";
    public static final String ID_REGEX = "^\\d+$";
    public static final String STRING_REGEX = "^\\w+( \\w+)*$";
    public static final String DATE_LEAP_YEAR = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String GENDER_REGEX = "^Male|Female|Unknow$";
    public static final String CMND_REGEX = "^\\d{12}$";
    public static final String VN_PHONE_NUMBER_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    public static final String EMAIL_REGEX = "^(([^<>()[\\]\\\\.,;:\\s@\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    static Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        System.out.println("-------Add new customer-------");

        int id = Integer.parseInt(inputId());

        String name = inputName();

        String dateOfBirth = inputDate();

        String gender = inputGender();

        String cmnd = inputCmnd();

        String phoneNumber = inputPhoneNumber();

        String email = inputEmail();

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

        String address = inputAddress();

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
                        int newId = Integer.parseInt(inputId());
                        customerList.get(index).setId(newId);
                        break;
                    case 2:
                        System.out.println("Current name: " + customerList.get(index).getName());
                        System.out.print("Enter new name: ");
                        String newName = inputName();
                        customerList.get(index).setName(newName);
                        break;
                    case 3:
                        System.out.println("Current date of birth: " + customerList.get(index).getDateOfBirth());
                        System.out.print("Enter new date of birth: ");
                        String newDateOfBirth = inputDate();
                        customerList.get(index).setDateOfBirth(newDateOfBirth);
                        break;
                    case 4:
                        System.out.println("Current gender: " + customerList.get(index).getGender());
                        System.out.print("Enter new gender: ");
                        String newGender = inputGender();
                        customerList.get(index).setGender(newGender);
                        break;
                    case 5:
                        System.out.println("Current cmnd: " + customerList.get(index).getCmnd());
                        System.out.print("Enter new cmnd: ");
                        String newCmnd = inputCmnd();
                        customerList.get(index).setCmnd(newCmnd);
                        break;
                    case 6:
                        System.out.println("Current phone number: " + customerList.get(index).getPhoneNumber());
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = inputPhoneNumber();
                        customerList.get(index).setPhoneNumber(newPhoneNumber);
                        break;
                    case 7:
                        System.out.println("Current email: " + customerList.get(index).getEmail());
                        System.out.print("Enter new email: ");
                        String newEmail = inputEmail();
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
                        String newAddress = inputAddress();
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

    private String inputId() {
        System.out.print("Enter id: ");
        return RegexData.regexStr(sc.nextLine(), ID_REGEX, "Id must be a positive number");
    }

    private String inputName() {
        System.out.print("Enter name: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Name cannot have any extra spaces or no characters");
    }

    private String inputDate() {
        System.out.print("Enter date of birth: ");
        return RegexData.regexStr(sc.nextLine(), DATE_LEAP_YEAR, "Date must be in dd/mm/yyyy format and exist");
    }

    private String inputGender() {
        System.out.print("Enter gender: ");
        return RegexData.regexStr(sc.nextLine(), GENDER_REGEX, "Gender must be Male, Female or Unknow");
    }

    private String inputCmnd() {
        System.out.print("Enter cmnd: ");
        return RegexData.regexStr(sc.nextLine(), CMND_REGEX, "Cmnd must be an 12 digit number");
    }

    private String inputPhoneNumber() {
        System.out.print("Enter phone number: ");
        return RegexData.regexStr(sc.nextLine(), VN_PHONE_NUMBER_REGEX, "Wrong format of phone number");
    }

    private String inputEmail() {
        System.out.print("Enter email: ");
        return RegexData.regexStr(sc.nextLine(), EMAIL_REGEX, "Wrong format of email");
    }

    private String inputAddress() {
        System.out.print("Enter address: ");
        return RegexData.regexStr(sc.nextLine(), STRING_REGEX, "Address cannot have any extra spaces or no characters");
    }
}
