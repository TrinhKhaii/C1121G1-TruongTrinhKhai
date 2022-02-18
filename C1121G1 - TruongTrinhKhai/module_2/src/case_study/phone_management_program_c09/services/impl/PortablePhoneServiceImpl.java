package case_study.phone_management_program_c09.services.impl;

import case_study.phone_management_program_c09.models.Phone;
import case_study.phone_management_program_c09.models.PortablePhone;
import case_study.phone_management_program_c09.services.IPhoneService;
import case_study.phone_management_program_c09.utils.ReadAndWriteCSVFile;
import case_study.phone_management_program_c09.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static case_study.phone_management_program_c09.services.impl.GenuinePhoneServiceImpl.POSITIVE_NUMBER_REGEX;

public class PortablePhoneServiceImpl implements IPhoneService {
    private static final String PHONE_FILE_PATH = "src/case_study/phone_management_program/data/Phone.csv";

    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        List<Phone> phones = ReadAndWriteCSVFile.readPhoneFromCSVFile(PHONE_FILE_PATH);
        System.out.println("----------Add new potable phone----------");

        int id = phones.get(phones.size()-1).getId() + 1;

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        int price = Integer.parseInt(inputPrice());

        int quantity = Integer.parseInt(inputQuantity());

        System.out.print("Enter manufacturer: ");
        String manufacturer = sc.nextLine();

        String portableCountry = inputPortableCountry();

        System.out.println("-------Status list-------");
        int count = 0;
        for (PortablePhone.Status status : PortablePhone.Status.values()) {
            System.out.println(++count + ". " + status);
        }
        boolean flag;
        int statusChoice;
        String status = null;
        while (true) {
            try {
                System.out.println();
                System.out.print("Enter your choice: ");
                statusChoice = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        do {
            flag = false;
            switch (statusChoice) {
                case 1:
                    status = PortablePhone.Status.REPAIRED.getValue();
                    break;
                case 2:
                    status = PortablePhone.Status.UNREPAIRED.getValue();
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 2.\n" +
                            "Please try again.\n");
                    flag = true;
            }
        } while (flag);

        PortablePhone portablePhone = new PortablePhone(id, name, price, quantity, manufacturer, portableCountry, status);
        List<PortablePhone> portablePhoneList = new LinkedList<>();
        portablePhoneList.add(portablePhone);
        ReadAndWriteCSVFile.writeListToCSVFile(portablePhoneList, PHONE_FILE_PATH, true);
    }

    private String inputPrice() {
        System.out.print("Enter price: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Price must be positive number.");
    }

    private String inputQuantity() {
        System.out.print("Enter quantity: ");
        return RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER_REGEX, "Quantity must be positive number.");
    }

    private String inputPortableCountry() {
        String portableCountry;
        do {
            System.out.print("Enter portable country: ");
            portableCountry = sc.nextLine();
            if (portableCountry.equals("VietNam")) {
                System.out.println("Portable country can not be VietNam");
            }
        } while(portableCountry.equals("VietNam"));
        return portableCountry;
    }
}
