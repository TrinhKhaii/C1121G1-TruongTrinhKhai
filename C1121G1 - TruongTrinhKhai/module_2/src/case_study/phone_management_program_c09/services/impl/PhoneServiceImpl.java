package case_study.phone_management_program_c09.services.impl;

import case_study.phone_management_program_c09.models.GenuinePhone;
import case_study.phone_management_program_c09.models.Phone;
import case_study.phone_management_program_c09.models.PortablePhone;
import case_study.phone_management_program_c09.services.IService2;
import case_study.phone_management_program_c09.utils.Exceptions;
import case_study.phone_management_program_c09.utils.ReadAndWriteCSVFile;

import java.util.List;
import java.util.Scanner;

import static case_study.phone_management_program_c09.services.impl.GenuinePhoneServiceImpl.PHONE_FILE_PATH;

public class PhoneServiceImpl implements IService2 {
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        List<Phone> phoneList = ReadAndWriteCSVFile.readPhoneFromCSVFile(PHONE_FILE_PATH);
        if (phoneList.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("---------Phone list---------");
            for (Phone phone: phoneList) {
                    System.out.println("Id: " + phone.getId());
                    System.out.println("Name: " + phone.getName());
                    System.out.println("Price: " + phone.getPrice());
                    System.out.println("Quantity: " + phone.getQuantity());
                    System.out.println("Manufacturer: " + phone.getManufacturer());
                if (phone instanceof GenuinePhone) {
                    System.out.println("Warranty period: " + ((GenuinePhone)phone).getWarrantyPeriod());
                    System.out.println("Warranty coverage: " + ((GenuinePhone)phone).getWarrantyCoverage());
                    System.out.println("\t-------------------------");
                } else if (phone instanceof PortablePhone) {
                    System.out.println("Warranty period: " + ((PortablePhone)phone).getPortableCountry());
                    System.out.println("Warranty coverage: " + ((PortablePhone)phone).getStatus());
                    System.out.println("\t-------------------------");
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            int index = 0;
            List<Phone> phoneList = ReadAndWriteCSVFile.readPhoneFromCSVFile(PHONE_FILE_PATH);
            boolean check = false;
            for (int i = 0; i < phoneList.size(); i++) {
                if (phoneList.get(i).getId() == id) {
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
                            phoneList.remove(index);
                            System.out.println("Phone list: ");
                            System.out.println(phoneList);
                            ReadAndWriteCSVFile.writeListToCSVFile(phoneList, PHONE_FILE_PATH, false);
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
    public void search(int id) {
        List<Phone> phoneList = ReadAndWriteCSVFile.readPhoneFromCSVFile(PHONE_FILE_PATH);
        boolean check = false;
        for (Phone phone: phoneList) {
            if (phone.getId() == id) {
                check = true;
                System.out.println("\t-------------------------");
                System.out.println("Id: " + phone.getId());
                System.out.println("Name: " + phone.getName());
                System.out.println("Price: " + phone.getPrice());
                System.out.println("Quantity: " + phone.getQuantity());
                System.out.println("Manufacturer: " + phone.getManufacturer());
                if (phone instanceof GenuinePhone) {
                    System.out.println("Warranty period: " + ((GenuinePhone)phone).getWarrantyPeriod());
                    System.out.println("Warranty coverage: " + ((GenuinePhone)phone).getWarrantyCoverage());
                    System.out.println("\t-------------------------");
                } else if (phone instanceof PortablePhone) {
                    System.out.println("Warranty period: " + ((PortablePhone)phone).getPortableCountry());
                    System.out.println("Warranty coverage: " + ((PortablePhone)phone).getStatus());
                    System.out.println("\t-------------------------");
                }
                break;
            }
        }
        if (!check) {
            System.out.println("Phone id does not exist.");
        }
    }
}
