package case_study.phone_management_program_c09.services.impl;

import case_study.phone_management_program_c09.models.GenuinePhone;
import case_study.phone_management_program_c09.models.Phone;
import case_study.phone_management_program_c09.services.IPhoneService;
import case_study.phone_management_program_c09.utils.ReadAndWriteCSVFile;
import case_study.phone_management_program_c09.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class GenuinePhoneServiceImpl implements IPhoneService {
    static final String PHONE_FILE_PATH = "src/case_study/phone_management_program/data/Phone.csv";
    public static final String POSITIVE_NUMBER_REGEX = "^[+]?\\d+$";
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        List<Phone> phones = ReadAndWriteCSVFile.readPhoneFromCSVFile(PHONE_FILE_PATH);
        System.out.println("----------Add new genuine phone----------");

        int id = phones.get(phones.size()-1).getId() + 1;

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        int price = Integer.parseInt(inputPrice());

        int quantity = Integer.parseInt(inputQuantity());

        System.out.print("Enter manufacturer: ");
        String manufacturer = sc.nextLine();

        int warrantyPeriod = Integer.parseInt(inputWarrantyPeriod());

        System.out.println("-------Warranty coverage list-------");
        int count = 0;
        for (GenuinePhone.WarrantyCoverage warrantyCoverage: GenuinePhone.WarrantyCoverage.values()) {
            System.out.println(++count + ". " + warrantyCoverage);
        }
        boolean flag;
        int warrantyCoverageChoice;
        String warrantyCoverage = null;
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter your choice: ");
                warrantyCoverageChoice = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        do {
            flag = false;
            switch (warrantyCoverageChoice) {
                case 1:
                    warrantyCoverage = GenuinePhone.WarrantyCoverage.DOMESTIC.getValue();
                    break;
                case 2:
                    warrantyCoverage = GenuinePhone.WarrantyCoverage.INTERNATIONAL.getValue();
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 2.\n" +
                            "Please try again.\n");
                    flag = true;
            }
        } while (flag);

        GenuinePhone genuinePhone = new GenuinePhone(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyCoverage);
        List<Phone> genuinePhoneList = new LinkedList<>();
        genuinePhoneList.add(genuinePhone);

        ReadAndWriteCSVFile.writeListToCSVFile(genuinePhoneList, PHONE_FILE_PATH, true);
    }

    private String inputPrice() {
        System.out.print("Enter price: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Price must be positive number.");
    }

    private String inputQuantity() {
        System.out.print("Enter quantity: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Quantity must be positive number.");
    }

    private String inputWarrantyPeriod() {
        String warrantyPeriod;
        do {
            System.out.print("Enter warranty period: ");
            warrantyPeriod = RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Warranty period must be positive number.");
            if (Integer.parseInt(warrantyPeriod) > 730) {
                System.out.println("Warranty period must less than 730");
            }
        } while (Integer.parseInt(warrantyPeriod) > 730);
        return warrantyPeriod;
    }
}
