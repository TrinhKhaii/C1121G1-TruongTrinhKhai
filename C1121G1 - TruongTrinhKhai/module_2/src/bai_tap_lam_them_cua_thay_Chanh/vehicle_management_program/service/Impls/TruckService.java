package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.Impls;

import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Manufacturer;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Truck;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Vehicle;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.IVehicleService;

import java.util.ArrayList;
import java.util.Scanner;

import static bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Manufacturer.manufacturerList;

public class TruckService implements IVehicleService {
    ArrayList<Vehicle> truckList = new ArrayList<>();

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
        new VehicleService().delete(controlPlate, truckList);
    }

    @Override
    public void display() {
        if (truckList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            int count = 0;
            for (Vehicle truck : truckList) {
                System.out.println("Truck " + (++count));
                System.out.println(" Control plate: " + truck.getControlPlate());
                System.out.println(" Manufactuturer's name: " + truck.getManufacturerName());
                System.out.println(" Year of manufactuture: " + truck.getYearOfManufacture());
                System.out.println(" Owner name: " + truck.getOwnerName());
                System.out.println(" Payload: " + ((Truck)truck).getPayload());
                System.out.println("--------------------");
            }
        }
    }
}
