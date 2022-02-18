package case_study.program_data_dictionary_james.controllers;

import java.util.Scanner;

public class DictionaryControllers {
    Scanner sc = new Scanner(System.in);
    public void displayMainMenu() {
        System.out.println("----------Welcome to dictionary----------");
        int menuChoice;
        boolean flag = true;
        do {
            System.out.println("-------------Menu-------------\n" +
                    "1.\tLook up.\n" +
                    "2.\tAdditional definition.\n" +
                    "3.\tDelete.\n" +
                    "4.\tDatabase export.\n" +
                    "5.\tExit.");
            while (true) {
                try {
                    System.out.println();
                    System.out.print("Your choice: ");
                    menuChoice = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            switch (menuChoice) {
                case 1:
                    lookUpFeature();
                    System.out.println("Search success!\n");
                    break;
                case 2:
                    additionalDefinitionFeature();
                    System.out.println("Additional definition success!\n");
                    break;
                case 3:
                    deleteFeature();
                    System.out.println("Delete success!\n");
                    break;
                case 4:
                    databaseExportFeature();
                    System.out.println("Database export success!");
                    break;
                case 5:
                    System.out.println("-------Thank you-------");
                    flag = false;
                    break;
                default:
                    System.out.println("Your choice must be from 1 to 5.");
                    System.out.println("Please try again.\n");
            }
        } while (flag);
    }

    private static void lookUpFeature() {

    }

    private static void additionalDefinitionFeature() {

    }

    private static void deleteFeature() {

    }

    private static void databaseExportFeature() {

    }
}
