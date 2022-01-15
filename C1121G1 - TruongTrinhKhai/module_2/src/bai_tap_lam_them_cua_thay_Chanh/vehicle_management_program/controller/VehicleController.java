package bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.controller;



import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.CarService;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.MotocycleService;
import bai_tap_lam_them_cua_thay_Chanh.vehicle_management_program.service.TruckService;

import java.util.Scanner;

public class VehicleController {
    static CarService carController = new CarService();
    static MotocycleService motocycleController = new MotocycleService();
    static TruckService truckController = new TruckService();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        boolean flag = true;
        do {
            System.out.println("Vehicle Management Program: ");
            System.out.println(" 1. Add new vehicle.\n" +
                    " 2. Vehicle display.\n" +
                    " 3. Delete vehicle.\n" +
                    " 4. Exit.");
            System.out.print("Your choice: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu) {
                case 1:
                    boolean check = true;
                    do {
                        System.out.println("Which vehicle do you want to add: ");
                        System.out.println(" 1. Car\n" +
                                " 2. Motorcycle\n" +
                                " 3. Truck\n" +
                                " 4. Back.");
                        System.out.print("Your choice: ");
                        int vehicleChoice = Integer.parseInt(sc.nextLine());

                        switch (vehicleChoice) {
                            case 1:
                                carController.add();
                                System.out.println("Add car success!");
                                break;
                            case 2:
                                motocycleController.add();
                                System.out.println("Add motocycle success!");
                                break;
                            case 3:
                                truckController.add();
                                System.out.println("Add truck success!");
                                break;
                            case 4:
                                System.out.println("Thank you!");
                                check = false;
                                break;
                            default:
                                System.out.println("Please try again!");
                        }
                    } while (check);
                    System.out.println();
                    break;
                case 2:
                    boolean check2 = true;
                    do {
                        System.out.println("Which vehicle do you want to display: ");
                        System.out.println(" 1. Car.\n" +
                                " 2. Motorcycle.\n" +
                                " 3. Truck.\n" +
                                " 4. Back.\n");
                        System.out.print("Your choice: ");
                        int vehicleChoice = Integer.parseInt(sc.nextLine());

                        switch (vehicleChoice) {
                            case 1:
                                carController.display();
                                System.out.println("Display Car success!");
                                break;
                            case 2:
                                motocycleController.display();
                                System.out.println("Display Motorcycle success!");
                                break;
                            case 3:
                                truckController.display();
                                System.out.println("Display Truck success!");
                                break;
                            case 4:
                                System.out.println("Thank you!");
                                check2 = false;
                                break;
                            default:
                                System.out.println("Please try again!");
                        }
                    } while (check2);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter control plate of the vehicle you want to delete: ");
                    String deleteControlPlate = sc.nextLine();
                    carController.delete(deleteControlPlate);
                    truckController.delete(deleteControlPlate);
                    motocycleController.delete(deleteControlPlate);
                    break;
                case 4:
                    System.out.println("Thank you!");
                    flag = false;
                    break;
                default:
                    System.out.println("Please try again!");
            }
        } while (flag);
    }

}
