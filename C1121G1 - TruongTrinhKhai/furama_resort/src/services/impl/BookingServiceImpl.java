package services.impl;

import models.*;
import services.IBookingService;
import utils.ReadAndWriteCSVFile;

import java.util.*;

import static services.impl.CustomerServiceImpl.CUSTOMER_FILE_PATH;
import static services.impl.CustomerServiceImpl.EDIT_REGEX;
import static services.impl.FacilityServiceImpl.*;

public class BookingServiceImpl implements IBookingService {
    public static final String BOOKING_FILE_PATH = "src/data/Booking.csv";
    public static final String BOOKING_HAS_NOT_YET_CREATE_A_CONTRACT_FILE_PATH = "src/data/BookingHasNotYetCreatedAContract.csv";
    public static final String CONTRACT_FILE_PATH = "src/data/Contract.csv";
    Scanner sc = new Scanner(System.in);

    public static final String CUSTOMER_ID_REGEX = "^\\d+$";
    public static final String SERVICE_ID_REGEX = "^SV(VL|RO|HO)-\\d{4}$";
    public static final String DATE_REGEX = "^^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$$";

    @Override
    public void add() {
        List<Customer> customerList = ReadAndWriteCSVFile.readCustomerFromCVSFile(CUSTOMER_FILE_PATH);
        System.out.println("-----------Customer list-----------");
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
        System.out.println("-----------------------------------");
        String customerId;
        boolean flag;
        do {
            do {
                System.out.print("Enter customer id: ");
                customerId = sc.nextLine();
                if (!customerId.matches(CUSTOMER_ID_REGEX)) {
                    System.out.println("Customer id must be an integer positive.");
                    System.out.println("Please try again.\n");
                }
            } while (!customerId.matches(CUSTOMER_ID_REGEX));
            flag = true;
            for (Customer customer: customerList) {
                if (customer.getId() == Integer.parseInt(customerId)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Customer with id " + customerId + " does not exist.");
                System.out.println("Please try again.\n");
            }
        } while (flag);
        System.out.println();

        Map<Villa, Integer> villaMap = ReadAndWriteCSVFile.readVillaFromCSVFile(VILLA_FILE_PATH);
        Map<House, Integer> houseMap = ReadAndWriteCSVFile.readHouseFromCSVFile(HOUSE_FILE_PATH);
        Map<Room, Integer> roomMap = ReadAndWriteCSVFile.readRoomFromCSVFile(ROOM_FILE_PATH);
        if (villaMap.isEmpty() && houseMap.isEmpty() && roomMap.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("-----------Facility list-----------");
            if (!villaMap.isEmpty()) {
                System.out.println(" Villa list: ");
                Set<Villa> set = villaMap.keySet();
                for (Villa key: set) {
                    System.out.println(key + ", number of times to rent: " + villaMap.get(key));
                }
            }
            if (!houseMap.isEmpty()) {
                System.out.println("\n House list: ");
                Set<House> set = houseMap.keySet();
                for (House key: set) {
                    System.out.println(key + ", number of times to rent: " + houseMap.get(key));
                }
            }
            if (!roomMap.isEmpty()) {
                System.out.println("\n Room list: ");
                Set<Room> set = roomMap.keySet();
                for (Room key: set) {
                    System.out.println(key + ", number of times to rent: " + roomMap.get(key));
                }
            }
        }
        System.out.println("----------------------------------");
        String serviceId;
        do {
            do{
                System.out.print("Enter service id: ");
                serviceId = sc.nextLine();
                if (!serviceId.matches(SERVICE_ID_REGEX)) {
                    System.out.println("Id must be in SVXX-YYYY format where XX is VL, RO or HO, YYYY are numbers from 0 to 9");
                    System.out.println("Please try again.\n");
                }
            } while (!serviceId.matches(SERVICE_ID_REGEX));
            flag = true;
            if (serviceId.matches(VILLA_ID_REGEX)) {
                Set<Villa> villaSet = villaMap.keySet();
                for (Villa key: villaSet) {
                    if ((key.getId()).equals(serviceId)) {
                        flag = false;
                        break;
                    }
                }
            } else if (serviceId.matches(ROOM_ID_REGEX)) {
                Set<Room> roomSet = roomMap.keySet();
                for (Room key: roomSet) {
                    if ((key.getId()).equals(serviceId)) {
                        flag = false;
                        break;
                    }
                }
            } else if (serviceId.matches(HOUSE_ID_REGEX)) {
                Set<House> houseSet = houseMap.keySet();
                for (House key: houseSet) {
                    if ((key.getId()).equals(serviceId)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("Service with id " + serviceId + " does not exist.");
                System.out.println("Please try again.\n");
            }
        } while (flag);
        System.out.println();

        String startDay;
        do {
            System.out.print("Enter start day: ");
            startDay = sc.nextLine();
            if (!startDay.matches(DATE_REGEX)) {
                System.out.println("Date must be in dd/mm/yyyy format");
                System.out.println("Please try again.\n");
            }
        } while (!startDay.matches(DATE_REGEX));

        String endDay;
        do {
            System.out.print("Enter end day: ");
            endDay = sc.nextLine();
            if (!endDay.matches(DATE_REGEX)) {
                System.out.println("Date must be in dd/mm/yyyy format");
                System.out.println("Please try again.\n");
            }
        } while (!endDay.matches(DATE_REGEX));

        System.out.print("Enter booking id: ");
        String bookingId = sc.nextLine();

        String serviceType = "";
        String type = serviceId.substring(2,4);
        switch (type) {
            case "VL":
                serviceType = "Villa";
                break;
            case "RO":
                serviceType = "Room";
                break;
            case "HO":
                serviceType = "House";
                break;
        }

        Booking newBooking = new Booking(bookingId, startDay, endDay, Integer.parseInt(customerId), serviceId, serviceType);
        Set<Booking> bookings = new TreeSet<>(new SortByDate());
        bookings = ReadAndWriteCSVFile.readBookingFromCSVFile(BOOKING_FILE_PATH);
        bookings.add(newBooking);
        ReadAndWriteCSVFile.writeSetToCSVFile(bookings, BOOKING_FILE_PATH, false);
        ReadAndWriteCSVFile.writeSetToCSVFile(bookings, BOOKING_HAS_NOT_YET_CREATE_A_CONTRACT_FILE_PATH, false);
    }

    @Override
    public void createNewContract() {
        Set<Booking> bookingList = ReadAndWriteCSVFile.readBookingFromCSVFile(BOOKING_HAS_NOT_YET_CREATE_A_CONTRACT_FILE_PATH);
        Queue<Booking> bookingQueue = new LinkedList<>();
        for (Booking booking: bookingList) {
            if (booking.getServiceType().equals("Villa") || booking.getServiceType().equals("House")) {
                bookingQueue.add(booking);
            }
        }
        Booking booking = bookingQueue.remove();

        System.out.print("Enter contract id: ");
        int contractId = Integer.parseInt(sc.nextLine());

        String bookingId = booking.getBookingId();

        System.out.print("Enter advance deposit amount: ");
        Float advanceDepositAmount = Float.parseFloat(sc.nextLine());

        System.out.print("Enter total payment amount: ");
        Float totalPaymentAmount = Float.parseFloat(sc.nextLine());

        int customerId = booking.getCustomerId();
        Contract contract = new Contract(contractId, bookingId, advanceDepositAmount, totalPaymentAmount, customerId);
        System.out.println("contract ne: ");
        System.out.println(contract);
        List<Contract> contracts = new LinkedList<>();
        contracts.add(contract);

        System.out.println("contracts ne: ");
        System.out.println(contracts);
        ReadAndWriteCSVFile.writeListToCSVFile(contracts, CONTRACT_FILE_PATH, true);

        Set<Booking> newBooking = new HashSet<>();
        for (Booking element: bookingQueue) {
            newBooking.add(element);
        }
        ReadAndWriteCSVFile.writeSetToCSVFile(newBooking, BOOKING_HAS_NOT_YET_CREATE_A_CONTRACT_FILE_PATH, false);
    }

    @Override
    public void displayContracts() {
        Queue<Contract> contractList = ReadAndWriteCSVFile.readContractFromCSVFile(CONTRACT_FILE_PATH);
        System.out.println("------------Contract list------------");
        for (Contract contract: contractList) {
            System.out.println(contract);
        }
        System.out.println("------------------------------------");
    }

    @Override
    public void display() {
        System.out.println("------------Booking list------------");
        Set<Booking> bookings = ReadAndWriteCSVFile.readBookingFromCSVFile(BOOKING_FILE_PATH);
        for (Booking booking: bookings) {
            System.out.println(booking);
        }
        System.out.println("------------------------------------");
    }

    @Override
    public void edit() {
        Queue<Contract> contractList = ReadAndWriteCSVFile.readContractFromCSVFile(CONTRACT_FILE_PATH);
        List<Contract> contracts = new ArrayList<>();
        System.out.println("------------Contract list------------");
        for (Contract contract: contractList) {
            System.out.println(contract);
            contracts.add(contract);
        }
        System.out.println("------------------------------------");
        String contractId;
        do {
            System.out.print("Enter contract id you want to edit: ");
            contractId = sc.nextLine();
            if (!contractId.matches(CUSTOMER_ID_REGEX)) {
                System.out.println("Contract id must be a positive integer.");
                System.out.println("Please try again.\n");
            }
        } while (!contractId.matches(CUSTOMER_ID_REGEX));
        boolean check = false;
        int index = -1;
        int size = contractList.size();
        for (int i = 0; i < size; i++) {
            if ((contractList.remove()).getContractNumber() == Integer.parseInt(contractId)) {
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
                System.out.println("1. Contract number.\n" +
                        "2. Booking id.\n" +
                        "3. Advance deposit amount.\n" +
                        "4. Total payment amount.\n" +
                        "5. Customer id.\n" +
                        "6. Done.\n");
                do {
                    System.out.print("Your choice: ");
                    editChoice = sc.nextLine();
                    if (!editChoice.matches(EDIT_REGEX)) {
                        System.out.println("Please try again.\n");
                    }
                } while (!editChoice.matches(EDIT_REGEX));
                switch (Integer.parseInt(editChoice)) {
                    case 1:
                        System.out.println("Current contract id: " + contracts.get(index).getContractNumber());
                        System.out.print("Enter new contract id: ");
                        int newContractId = Integer.parseInt(sc.nextLine());
                        contracts.get(index).setContractNumber(newContractId);
                        break;
                    case 2:
                        System.out.println("Current booking id: " + contracts.get(index).getBookingId());
                        System.out.print("Enter new booking id: ");
                        String newBookingId = sc.nextLine();
                        contracts.get(index).setBookingId(newBookingId);
                        break;
                    case 3:
                        System.out.println("Current advance deposit amount: " + contracts.get(index).getAdvanceDepositAmount());
                        System.out.print("Enter new advance deposit amount: ");
                        Float newAdvanceDepositAmount = Float.parseFloat(sc.nextLine());
                        contracts.get(index).setAdvanceDepositAmount(newAdvanceDepositAmount);
                        break;
                    case 4:
                        System.out.println("Current total payment amount: " + contracts.get(index).getTotalPaymentAmount());
                        System.out.print("Enter new total payment amount: ");
                        Float newTotalPaymentAmount = Float.parseFloat(sc.nextLine());
                        contracts.get(index).setTotalPaymentAmount(newTotalPaymentAmount);
                        break;
                    case 5:
                        System.out.println("Current customer id: " + contracts.get(index).getCustomerId());
                        System.out.print("Enter new customer id: ");
                        int newCustomerId = Integer.parseInt(sc.nextLine());
                        contracts.get(index).setCustomerId(newCustomerId);
                        break;
                    case 6:
                        flag = false;
                        break;
                    default:
                        System.out.println("Please enter from 1 to 6.");
                }
            } while (flag);
            ReadAndWriteCSVFile.writeListToCSVFile(contracts, CONTRACT_FILE_PATH, false);
        }
    }
}
