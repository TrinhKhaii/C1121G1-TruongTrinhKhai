//
// created by Trinh Khai at 14:03 26/1/2022
//

package controllers;

import models.Employee;
import services.impl.*;

import java.util.Scanner;

public class FuramaController {
    public static final String CHOICE_REGEX = "^\\d{1}$";

    private static final CustomerServiceImpl customer = new CustomerServiceImpl();
    private static final EmployeeServiceImpl employee = new EmployeeServiceImpl();
    private static final FacilityServiceImpl facility = new FacilityServiceImpl();
    private static final BookingServiceImpl booking = new BookingServiceImpl();
    private static final PromotionServiceImpl promotion = new PromotionServiceImpl();
    static Scanner sc = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("Welcome to Furama Resort!");
        String chooseMenu;
        boolean flag = true;
        do {
            System.out.println("--------Menu--------");
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management\n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            do {
                System.out.print("Your choice: ");
                chooseMenu = sc.nextLine();
                if (!chooseMenu.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!chooseMenu.matches(CHOICE_REGEX));
            switch (Integer.parseInt(chooseMenu)) {
                case 1:
                    displayEmployeeManagement();
                    break;
                case 2:
                    displayCustomerManagement();
                    break;
                case 3:
                    displayFacilityManagement();
                    break;
                case 4:
                    displayBookingManagement();
                    break;
                case 5:
                    displayPromotionManagement();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    flag = false;
                    break;
                default:
                    System.out.println("Please choose from 1 to 6.");
                    System.out.println();
            }
        } while (flag);
    }

    private static void displayEmployeeManagement() {
        String employeeChoice;
        boolean flag = true;
        do {
            System.out.println("--------Employee Management--------");
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");
            do {
                System.out.print("Your choice: ");
                employeeChoice = sc.nextLine();
                if (!employeeChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!employeeChoice.matches(CHOICE_REGEX));

            switch (Integer.parseInt(employeeChoice)) {
                case 1:
                    employee.display();
                    System.out.println("Display list employees success!");
                    break;
                case 2:
                    employee.add();
                    System.out.println("Add new employee success!");
                    break;
                case 3:
                    employee.edit();
                    System.out.println("Edit employee success!");
                    break;
                case 4:
                    System.out.println("Return main menu");
                    System.out.println();
                    flag = false;
                    break;
                default:
                    System.out.println("Please choose from 1 to 4.");
                    System.out.println();
            }
        } while (flag);
    }

    private static void displayCustomerManagement() {
        String customerChoice;
        boolean flag = true;
        do {
            System.out.println("--------Customer Management--------");
            System.out.println("1\tDisplay list customers\n" +
                    "2\tAdd new customer\n" +
                    "3\tEdit customer\n" +
                    "4\tReturn main menu\n");
            do {
                System.out.print("Your choice: ");
                customerChoice = sc.nextLine();
                if (!customerChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!customerChoice.matches(CHOICE_REGEX));
            switch (Integer.parseInt(customerChoice)) {
                case 1:
                    customer.display();
                    System.out.println("Display list customers");
                    break;
                case 2:
                    customer.add();
                    System.out.println("Add new customer");
                    break;
                case 3:
                    customer.edit();
                    System.out.println("Edit customer");
                    break;
                case 4:
                    System.out.println("Return main menu");
                    System.out.println();
                    flag = false;
                    break;
                default:
                    System.out.println("Please choose from 1 to 4.");
                    System.out.println();
            }
        } while (flag);
    }

    private static void displayFacilityManagement() {
        String facilityChoice;
        boolean flag = true;
        do {
            System.out.println("--------Facility Management--------");
            System.out.println("1\tDisplay facility list\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay facility maintenance list\n" +
                    "4\tReturn main menu\n");
            do {
                System.out.print("Your choice: ");
                facilityChoice = sc.nextLine();
                if (!facilityChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!facilityChoice.matches(CHOICE_REGEX));
            switch (Integer.parseInt(facilityChoice)) {
                case 1:
                    facility.display();
                    System.out.println("Display facility list success!");
                    break;
                case 2:
                    facility.add();
                    System.out.println("Add new facility success!");
                    break;
                case 3:
                    facility.displayFacilityMaintenance();
                    System.out.println("Display facility maintenance success!");
                    break;
                case 4:
                    System.out.println("Return main menu\n");
                    flag = false;
                    break;
                default:
                    System.err.println("Please choose from 1 to 4.\n");
            }
        } while (flag);
    }

    private static void displayBookingManagement() {
        String bookingChoice;
        boolean flag = true;
        do {
        System.out.println("--------Booking Management--------");
        System.out.println("1.\tAdd new booking\n" +
                "2.\tDisplay list booking\n" +
                "3.\tCreate new constracts\n" +
                "4.\tDisplay list contracts\n" +
                "5.\tEdit contracts\n" +
                "6.\tReturn main menu\n");
            do {
                System.out.print("Your choice: ");
                bookingChoice = sc.nextLine();
                if (!bookingChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!bookingChoice.matches(CHOICE_REGEX));
            switch (Integer.parseInt(bookingChoice)) {
                case 1:
                    booking.add();
                    System.out.println("Add new booking success!");
                    break;
                case 2:
                    booking.display();
                    System.out.println("Display booking list success!");
                    break;
                case 3:
                    booking.createNewContract();
                    System.out.println("Create new constracts success!");
                    break;
                case 4:
                    booking.displayContracts();
                    System.out.println("Display list contracts success!");
                    break;
                case 5:
                    booking.edit();
                    System.out.println("Edit contracts");
                    break;
                case 6:
                    System.out.println("Return main menu");
                    System.out.println();
                    flag = false;
                    break;
                default:
                    System.err.println("Please choose from 1 to 6.");
                    System.out.println();
            }
        } while (flag);
    }

    private static void displayPromotionManagement() {
        String promotionChoice;
        boolean flag = true;
        do {
            System.out.println("--------Promotion Management--------");
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n");
            do {
                System.out.print("Your choice: ");
                promotionChoice = sc.nextLine();
                if (!promotionChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!promotionChoice.matches(CHOICE_REGEX));
            switch (Integer.parseInt(promotionChoice)) {
                case 1:
                    promotion.displayListCustumersUseService();
                    System.out.println("Display list customers use service success!");
                    break;
                case 2:
                    promotion.displayListCustumersGetVoucher();
                    System.out.println("Display list customers get voucher success!");
                    break;
                case 3:
                    System.out.println("Return main menu");
                    System.out.println();
                    flag = false;
                    break;
                default:
                    System.err.println("Please choose from 1 to 3.");
                    System.out.println();
            }
        } while (flag);
    }

}
