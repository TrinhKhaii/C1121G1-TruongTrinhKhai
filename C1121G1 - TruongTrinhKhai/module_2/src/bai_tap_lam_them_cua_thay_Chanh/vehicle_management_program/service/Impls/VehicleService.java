package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.Impls;

import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.model.Vehicle;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.IVehicle;

import java.util.List;
import java.util.Scanner;

public class VehicleService implements IVehicle {
    Scanner sc = new Scanner(System.in);

    @Override
    public void delete(String controlPlate, List<Vehicle> vehicleList) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getControlPlate().equals(controlPlate)) {
                System.out.println("Are you sure?");
                System.out.println(" 1. YES.\n" +
                        " 2. NO.\n");
                boolean check = true;
                do {
                    System.out.print("Your choice: ");
                    int yourChoice = Integer.parseInt(sc.nextLine());
                    switch (yourChoice) {
                        case 1:
                            vehicleList.remove(i);
                            System.out.println("Delete car success!");
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
}
