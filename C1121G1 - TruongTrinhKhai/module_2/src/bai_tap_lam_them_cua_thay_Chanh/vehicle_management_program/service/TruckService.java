package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service;

import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Manufacturer;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Truck;
import java.util.ArrayList;
import java.util.Scanner;

import static bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Manufacturer.manufacturerList;

public class TruckService implements IVehicleService {
    ArrayList<Truck> truckList = new ArrayList<Truck>();

    Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        System.out.print("Enter control plate: ");
        String controlPlate = sc.nextLine();

        System.out.println("Manufacturer's name: ");
        int count = 1;
        for (Manufacturer item : manufacturerList) {
            System.out.println("\t" + count + ". " + item.getName() + ".");
            count++;
        }
        int manufactureChoice;
        do {
            System.out.print("Your choice: ");
            manufactureChoice = Integer.parseInt(sc.nextLine());
        } while (manufactureChoice < 0 && manufactureChoice > count);

        Manufacturer manufacturerName = null;
        for (int i = 0; i < manufacturerList.size(); i++){
            if (i == (manufactureChoice - 1)) {
                manufacturerName = manufacturerList.get(i);
                break;
            }
        }

        System.out.print("Enter year of manufacture: ");
        int yearOfManufacture = Integer.parseInt(sc.nextLine());

        System.out.print("Enter owner name: ");
        String ownerName = sc.nextLine();

        System.out.print("Enter num of payload: ");
        int payload = Integer.parseInt(sc.nextLine());


        truckList.add(new Truck(controlPlate, manufacturerName, yearOfManufacture, ownerName, payload));

    }

    @Override
    public void delete(String controlPlate) {
        for (int i = 0; i < truckList.size(); i++) {
            if (truckList.get(i).getControlPlate().equals(controlPlate)) {
                System.out.println("Are you sure?");
                System.out.println(" 1. YES.\n" +
                        " 2. NO.\n");
                boolean check = true;
                do {
                    System.out.print("Your choice: ");
                    int yourChoice = Integer.parseInt(sc.nextLine());
                    switch (yourChoice) {
                        case 1:
                            truckList.remove(i);
                            System.out.println("Delete truck success!");
                            break;
                        case 2:
                            break;
                        default:
                            check = false;
                    }
                } while (!check);
            }
        }
    }

    @Override
    public void display() {
        if (truckList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            int count = 0;
            for (Truck truck : truckList) {
                System.out.println("Truck " + (++count));
                System.out.println(" Control plate: " + truck.getControlPlate());
                System.out.println(" Manufactuturer's name: " + truck.getManufacturerName());
                System.out.println(" Year of manufactuture: " + truck.getYearOfManufacture());
                System.out.println(" Owner name: " + truck.getOwnerName());
                System.out.println(" Payload: " + truck.getPayload());
                System.out.println("--------------------");
            }
        }
    }
}
