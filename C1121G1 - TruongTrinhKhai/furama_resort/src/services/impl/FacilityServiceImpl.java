//
// created by Trinh Khai at 16:49 26/1/2022
//

package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.IFacilityService;
import utils.ReadAndWriteCSVFile;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    private static final String FACILITY_FILE_PATH = "src/data/Facility.csv";
    public static final String VILLA_FILE_PATH = "src/data/Villa.csv";
    public static final String HOUSE_FILE_PATH = "src/data/House.csv";
    public static final String ROOM_FILE_PATH = "src/data/Room.csv";

    public static final String CHOICE_REGEX = "^\\d{1}$";
    public static final String VILLA_ID_REGEX = "^SVVL-\\d{4}$";
    public static final String HOUSE_ID_REGEX = "^SVHO-\\d{4}$";
    public static final String ROOM_ID_REGEX = "^SVRO-\\d{4}$";
    public static final String RENTAL_COST_REGEX = "^[1-9]\\d*$";
    public static final String SERVICE_NAME_REGEX = "^[A-Z][a-z]+\\s\\d+$";
    public static final String USABLE_AREA_REGEX = "^[0-9]+(\\.\\d+)*$";
    public static final String MAXXIMUN_AREA_REGEX = "^[1-9]+$";

    static Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        String addChoice;
        boolean flag = true;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n");
            do {
                System.out.print("Your choice: ");
                addChoice = sc.nextLine();
                if (!addChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.\n");
                }
            } while (!addChoice.matches(CHOICE_REGEX));
            switch (Integer.parseInt(addChoice)) {
                case 1:
                    addNewVilla();
                    System.out.println("Add New Villa success!");
                    break;
                case 2:
                    addNewHouse();
                    System.out.println("Add New House success!");
                    break;
                case 3:
                    addNewRoom();
                    System.out.println("Add New Room success!");
                    break;
                case 4:
                    System.out.println("Back to menu");
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter from 1 to 4.\n");
            }
        } while (flag);
    }

    @Override
    public void display() {
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
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Villa, Integer> villaMap = ReadAndWriteCSVFile.readVillaFromCSVFile(VILLA_FILE_PATH);
        Map<House, Integer> houseMap = ReadAndWriteCSVFile.readHouseFromCSVFile(HOUSE_FILE_PATH);
        Map<Room, Integer> roomMap = ReadAndWriteCSVFile.readRoomFromCSVFile(ROOM_FILE_PATH);
        System.out.println("-----------Facility maintenance list-----------");
        Set<Villa> villaSet = villaMap.keySet();
        for (Villa key: villaSet) {
            if (villaMap.get(key) > 5 || villaMap.get(key) == 5) {
                System.out.println(key + ", number of times to rent: " + villaMap.get(key));
            }
        }
        Set<House> houseSet = houseMap.keySet();
        for (House key: houseSet) {
            if (houseMap.get(key) > 5 || houseMap.get(key) == 5) {
                System.out.println(key + ", number of times to rent: " + houseMap.get(key));
            }
        }
        Set<Room> roomSet = roomMap.keySet();
        for (Room key: roomSet) {
            if (roomMap.get(key) > 5 || roomMap.get(key) == 5) {
                System.out.println(key + ", number of times to rent: " + roomMap.get(key));
            }
        }

    }

    private static void addNewVilla() {
        String id;
        do{
            System.out.print("Enter id: ");
            id = sc.nextLine();
            if (!id.matches(VILLA_ID_REGEX)) {
                System.out.println("Id must be in SVVL-YYYY format where YYYY are numbers from 0 to 9");
                System.out.println("Please try again.\n");
            }
        } while (!id.matches(VILLA_ID_REGEX));

        String serviceName;
        do {
            System.out.print("Enter service name: ");
            serviceName = sc.nextLine();
            if (!serviceName.matches(SERVICE_NAME_REGEX)) {
                System.out.println("Service name must capitalize the first character, the following characters are normal characters");
                System.out.println("Please try again.\n");
            }
        } while (!serviceName.matches(SERVICE_NAME_REGEX));

        String usableArea;
        do {
            System.out.print("Enter usable area: ");
            usableArea = sc.nextLine();
            if (!usableArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(usableArea) < 30) {
                System.out.println("Usable area must be real numbers greater than 30m2");
                System.out.println("Please try again.\n");
            }
        } while (!usableArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(usableArea) < 30);

        String rentalCost;
        do {
            System.out.print("Enter rental cost: ");
            rentalCost = sc.nextLine();
            if (!rentalCost.matches(RENTAL_COST_REGEX)) {
                System.out.println("Rental cost must be positive.");
                System.out.println("Please try again.\n");
            }
        } while (!rentalCost.matches(RENTAL_COST_REGEX));

        String maximumNumberOfPeople;
        do {
            System.out.print("Enter maximum number of people: ");
            maximumNumberOfPeople = sc.nextLine();
            if (!maximumNumberOfPeople.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(maximumNumberOfPeople) > 20) {
                System.out.println("The maximum number of people must greater than 0 and less than 20.");
                System.out.println("Please try again.\n");
            }
        } while (!maximumNumberOfPeople.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(maximumNumberOfPeople) > 20);

        System.out.println("--------Rent Type list--------");
        int count = 0;
        for (Facility.RentType rentType: Facility.RentType.values()) {
            System.out.println(++count + ". " + rentType);
        }
        String rentTypeChoice;
        String rentType = "";
        boolean flag;
        do {
            do {
                System.out.print("Your rent type choice: ");
                rentTypeChoice = sc.nextLine();
                if (!rentTypeChoice.matches(CHOICE_REGEX)) {
                    System.out.print("Please try again.");
                }
            } while (!rentTypeChoice.matches(CHOICE_REGEX));
            flag = false;
            switch (Integer.parseInt(rentTypeChoice)) {
                case 1:
                    rentType = Facility.RentType.YEAR.getValue();
                    break;
                case 2:
                    rentType = Facility.RentType.MONTH.getValue();
                    break;
                case 3:
                    rentType = Facility.RentType.DAY.getValue();
                    break;
                case 4:
                    rentType = Facility.RentType.HOUR.getValue();
                    break;
                default:
                    System.out.print("Please enter from 1 to 4.\n");
                    flag = true;
            }
        } while (flag);

        System.out.println("--------Room standard list--------");
        count = 0;
        for (Villa.RoomStandard roomStandard: Villa.RoomStandard.values()) {
            System.out.println(++count + ". " + roomStandard);
        }
        String roomStandardChoice;
        String roomStandard = "";
        do {
            do {
                System.out.print("Your room standard choice: ");
                roomStandardChoice = sc.nextLine();
                if (!roomStandardChoice.matches(CHOICE_REGEX)) {
                    System.out.print("Please try again.");
                }
            } while (!roomStandardChoice.matches(CHOICE_REGEX));
            flag = false;
            switch (Integer.parseInt(roomStandardChoice)) {
                case 1:
                    roomStandard = Villa.RoomStandard.DIAMOND.getValue();
                    break;
                case 2:
                    roomStandard = Villa.RoomStandard.PLATINIUM.getValue();
                    break;
                case 3:
                    roomStandard = Villa.RoomStandard.GOLD.getValue();
                    break;
                case 4:
                    roomStandard = Villa.RoomStandard.SILVER.getValue();
                    break;
                default:
                    System.out.print("Please enter from 1 to 4.\n");
                    flag = true;
            }
        } while (flag);

        String poolArea;
        do {
            System.out.print("Enter pool area: ");
            poolArea = sc.nextLine();
            if (!poolArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(poolArea) < 30) {
                System.out.println("Pool area must be real numbers greater than 30m2");
                System.out.println("Please try again.\n");
            }
        } while (!poolArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(poolArea) < 30);

        String numberOfFloors;
        do {
            System.out.print("Enter number of floors: ");
            numberOfFloors = sc.nextLine();
            if (!numberOfFloors.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(numberOfFloors) > 10) {
                System.out.println("Number of floors must be a positive integer and less than 10.");
                System.out.println("Please try again.\n");
            }
        } while (!numberOfFloors.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(numberOfFloors) > 10);

        Villa villa = new Villa(id, serviceName, Float.parseFloat(usableArea), Integer.parseInt(rentalCost), Integer.parseInt(maximumNumberOfPeople), rentType,0, roomStandard, Float.parseFloat(poolArea), Integer.parseInt(numberOfFloors));
        Map<Villa, Integer> villaList = new LinkedHashMap<>();
        villaList.put(villa, villa.getNumberOfTimesToRent());
        ReadAndWriteCSVFile.writeMapToCSVFile(villaList, FACILITY_FILE_PATH, true);
        ReadAndWriteCSVFile.writeMapToCSVFile(villaList, VILLA_FILE_PATH, true);
    }

    private static void addNewHouse() {
        String id;
        do{
            System.out.print("Enter id: ");
            id = sc.nextLine();
            if (!id.matches(HOUSE_ID_REGEX)) {
                System.out.println("Id must be in SVHO-YYYY format where YYYY are numbers from 0 to 9");
                System.out.println("Please try again.\n");
            }
        } while (!id.matches(HOUSE_ID_REGEX));

        String serviceName;
        do {
            System.out.print("Enter service name: ");
            serviceName = sc.nextLine();
            if (!serviceName.matches(SERVICE_NAME_REGEX)) {
                System.out.println("Service name must capitalize the first character, the following characters are normal characters");
                System.out.println("Please try again.\n");
            }
        } while (!serviceName.matches(SERVICE_NAME_REGEX));

        String usableArea;
        do {
            System.out.print("Enter usable area: ");
            usableArea = sc.nextLine();
            if (!usableArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(usableArea) < 30) {
                System.out.println("Usable area must be real numbers greater than 30m2");
                System.out.println("Please try again.\n");
            }
        } while (!usableArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(usableArea) < 30);

        String rentalCost;
        do {
            System.out.print("Enter rental cost: ");
            rentalCost = sc.nextLine();
            if (!rentalCost.matches(RENTAL_COST_REGEX)) {
                System.out.println("Rental cost must be positive.");
                System.out.println("Please try again.\n");
            }
        } while (!rentalCost.matches(RENTAL_COST_REGEX));

        String maximumNumberOfPeople;
        do {
            System.out.print("Enter maximum number of people: ");
            maximumNumberOfPeople = sc.nextLine();
            if (!maximumNumberOfPeople.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(maximumNumberOfPeople) > 20) {
                System.out.println("The maximum number of people must greater than 0 and less than 20.");
                System.out.println("Please try again.\n");
            }
        } while (!maximumNumberOfPeople.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(maximumNumberOfPeople) > 20);

        System.out.println("--------Rent Type list--------");
        int count = 0;
        for (Facility.RentType rentType: Facility.RentType.values()) {
            System.out.println(++count + ". " + rentType);
        }
        String rentTypeChoice;
        String rentType = "";
        boolean flag;
        do {
            do {
                System.out.print("Your rent type choice: ");
                rentTypeChoice = sc.nextLine();
                if (!rentTypeChoice.matches(CHOICE_REGEX)) {
                    System.out.print("Please try again.");
                }
            } while (!rentTypeChoice.matches(CHOICE_REGEX));
            flag = false;
            switch (Integer.parseInt(rentTypeChoice)) {
                case 1:
                    rentType = Facility.RentType.YEAR.getValue();
                    break;
                case 2:
                    rentType = Facility.RentType.MONTH.getValue();
                    break;
                case 3:
                    rentType = Facility.RentType.DAY.getValue();
                    break;
                case 4:
                    rentType = Facility.RentType.HOUR.getValue();
                    break;
                default:
                    System.out.print("Please enter from 1 to 4.\n");
                    flag = true;
            }
        } while (flag);

        System.out.println("--------Room standard list--------");
        count = 0;
        for (Villa.RoomStandard roomStandard: Villa.RoomStandard.values()) {
            System.out.println(++count + ". " + roomStandard);
        }
        String roomStandardChoice;
        String roomStandard = "";
        do {
            do {
                System.out.print("Your room standard choice: ");
                roomStandardChoice = sc.nextLine();
                if (!roomStandardChoice.matches(CHOICE_REGEX)) {
                    System.out.print("Please try again.");
                }
            } while (!roomStandardChoice.matches(CHOICE_REGEX));
            flag = false;
            switch (Integer.parseInt(roomStandardChoice)) {
                case 1:
                    roomStandard = House.RoomStandard.DIAMOND.getValue();
                    break;
                case 2:
                    roomStandard = House.RoomStandard.PLATINIUM.getValue();
                    break;
                case 3:
                    roomStandard = House.RoomStandard.GOLD.getValue();
                    break;
                case 4:
                    roomStandard = House.RoomStandard.SILVER.getValue();
                    break;
                default:
                    System.out.print("Please enter from 1 to 4.\n");
                    flag = true;
            }
        } while (flag);

        String numberOfFloors;
        do {
            System.out.print("Enter number of floors: ");
            numberOfFloors = sc.nextLine();
            if (!numberOfFloors.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(numberOfFloors) < 10) {
                System.out.println("Number of floors must be a positive integer and less than 10.");
                System.out.println("Please try again.\n");
            }
        } while (!numberOfFloors.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(numberOfFloors) < 10);

        House house = new House(id, serviceName, Float.parseFloat(usableArea), Integer.parseInt(rentalCost), Integer.parseInt(maximumNumberOfPeople), rentType,0, roomStandard, Integer.parseInt(numberOfFloors));
        Map<House, Integer> houseList = new LinkedHashMap<>();
        houseList.put(house, house.getNumberOfTimesToRent());
        ReadAndWriteCSVFile.writeMapToCSVFile(houseList, FACILITY_FILE_PATH, true);
        ReadAndWriteCSVFile.writeMapToCSVFile(houseList, HOUSE_FILE_PATH, true);
    }

    public static void addNewRoom() {
        String id;
        do{
            System.out.print("Enter id: ");
            id = sc.nextLine();
            if (!id.matches(ROOM_ID_REGEX)) {
                System.out.println("Id must be in SVRO-YYYY format where YYYY are numbers from 0 to 9");
                System.out.println("Please try again.\n");
            }
        } while (!id.matches(ROOM_ID_REGEX));

        String serviceName;
        do {
            System.out.print("Enter service name: ");
            serviceName = sc.nextLine();
            if (!serviceName.matches(SERVICE_NAME_REGEX)) {
                System.out.println("Service name must capitalize the first character, the following characters are normal characters");
                System.out.println("Please try again.\n");
            }
        } while (!serviceName.matches(SERVICE_NAME_REGEX));

        String usableArea;
        do {
            System.out.print("Enter usable area: ");
            usableArea = sc.nextLine();
            if (!usableArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(usableArea) < 30) {
                System.out.println("Usable area must be real numbers greater than 30m2");
                System.out.println("Please try again.\n");
            }
        } while (!usableArea.matches(USABLE_AREA_REGEX) && Float.parseFloat(usableArea) < 30);

        String rentalCost;
        do {
            System.out.print("Enter rental cost: ");
            rentalCost = sc.nextLine();
            if (!rentalCost.matches(RENTAL_COST_REGEX)) {
                System.out.println("Rental cost must be positive.");
                System.out.println("Please try again.\n");
            }
        } while (!rentalCost.matches(RENTAL_COST_REGEX));

        String maximumNumberOfPeople;
        do {
            System.out.print("Enter maximum number of people: ");
            maximumNumberOfPeople = sc.nextLine();
            if (!maximumNumberOfPeople.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(maximumNumberOfPeople) > 20) {
                System.out.println("The maximum number of people must greater than 0 and less than 20.");
                System.out.println("Please try again.\n");
            }
        } while (!maximumNumberOfPeople.matches(MAXXIMUN_AREA_REGEX) && Integer.parseInt(maximumNumberOfPeople) > 20);

        System.out.println("--------Rent Type list--------");
        int count = 0;
        for (Facility.RentType rentType: Facility.RentType.values()) {
            System.out.println(++count + ". " + rentType);
        }
        String rentTypeChoice;
        String rentType = "";
        boolean flag;
        do {
            do {
                System.out.print("Your rent type choice: ");
                rentTypeChoice = sc.nextLine();
                if (!rentTypeChoice.matches(CHOICE_REGEX)) {
                    System.out.print("Please try again.");
                }
            } while (!rentTypeChoice.matches(CHOICE_REGEX));
            flag = false;
            switch (Integer.parseInt(rentTypeChoice)) {
                case 1:
                    rentType = Facility.RentType.YEAR.getValue();
                    break;
                case 2:
                    rentType = Facility.RentType.MONTH.getValue();
                    break;
                case 3:
                    rentType = Facility.RentType.DAY.getValue();
                    break;
                case 4:
                    rentType = Facility.RentType.HOUR.getValue();
                    break;
                default:
                    System.out.print("Please enter from 1 to 4.\n");
                    flag = true;
            }
        } while (flag);

        System.out.print("Enter free service included: ");
        String freeServiceIncluded = sc.nextLine();

        Room room = new Room(id, serviceName, Float.parseFloat(usableArea), Integer.parseInt(rentalCost), Integer.parseInt(maximumNumberOfPeople), rentType,0, freeServiceIncluded);
        Map<Room, Integer> roomMap = new LinkedHashMap<>();
        roomMap.put(room, room.getNumberOfTimesToRent());
        ReadAndWriteCSVFile.writeMapToCSVFile(roomMap, FACILITY_FILE_PATH, true);
        ReadAndWriteCSVFile.writeMapToCSVFile(roomMap, ROOM_FILE_PATH, true);
    }
}
