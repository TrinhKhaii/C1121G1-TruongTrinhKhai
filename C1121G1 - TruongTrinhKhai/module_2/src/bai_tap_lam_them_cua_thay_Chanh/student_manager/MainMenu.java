package bai_tap_lam_them_cua_thay_Chanh.student_manager;

import java.util.Scanner;


public class MainMenu {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();

        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        boolean flag = true;
        do {
            System.out.println(" Menu student manager: \n" +
                    "1. Add.\n" +
                    "2. Display.\n" +
                    "3. Edit.\n" +
                    "4. Delete.\n" +
                    "5. Search.\n" +
                    "6. Exit.\n");
            System.out.print("Your choice: ");
            chooseMenu = sc.nextInt();
            switch (chooseMenu) {
                case 1:
                    studentManager.add();
                    System.out.println("Add success!\n");
                    break;
                case 2:
                    studentManager.display();
                    System.out.println("Display success!\n");
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Enter the Student Id you want to edit: ");
                    int editId = sc.nextInt();
                    studentManager.edit(editId);
                    System.out.println("Edit success!\n");
                    break;
                case 4:
                    System.out.println();
                    System.out.print("Enter the Student Id you want to delete: ");
                    int deleteId = sc.nextInt();
                    studentManager.delete(deleteId);
                    System.out.println("Delete success!\n");
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Enter the Student Id you want to search: ");
                    int searchId = sc.nextInt();
                    studentManager.search(searchId);
                    System.out.println("Search success!\n");
                    break;
                case 6:
                    flag = false;
            }
        } while (flag);
    }
}
