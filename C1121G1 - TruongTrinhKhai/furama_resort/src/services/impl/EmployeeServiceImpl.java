//
// created by Trinh Khai at 16:50 26/1/2022
//

package services.impl;

import models.Employee;
import services.IEmployeeService;
import utils.ReadAndWriteCSVFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static controllers.FuramaController.CHOICE_REGEX;

public class EmployeeServiceImpl implements IEmployeeService {
    private static final String EMPLOYEE_FILE_PATH = "src/data/Employee.csv";
    public static final String EDIT_REGEX = "^\\d{1,2}$";
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("-------Add new employee-------");
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter date of birth: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter cmnd: ");
        String cmnd = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        //Qualification
        System.out.println("--------Qualification list--------");
        int count = 0;
        for (Employee.Qualification qualification : Employee.Qualification.values()) {
            System.out.println(++count + ". " + qualification);
        }
        String qualificationChoice;
        String qualification = "";
        boolean flag;
        do {
            do {
                System.out.print("Your choice: ");
                qualificationChoice = sc.nextLine();
                if (!qualificationChoice.matches(CHOICE_REGEX)) {
                    System.out.println("Please try again.");
                }
            } while (!qualificationChoice.matches(CHOICE_REGEX));
            flag = false;
            switch (Integer.parseInt(qualificationChoice)) {
                case 1:
                    qualification = Employee.Qualification.INTERMEDIATE.getValue();
                    break;
                case 2:
                    qualification = Employee.Qualification.COLLEGE.getValue();
                    break;
                case 3:
                    qualification = Employee.Qualification.UNDERGRADUATE.getValue();
                    break;
                case 4:
                    qualification = Employee.Qualification.GRADUATE.getValue();
                    break;
                default:
                    System.out.println("Please enter from 1 to 4.");
                    flag = true;
            }
        } while (flag);

        // Position
        System.out.println("--------Position list--------");
        count = 0;
        for (Employee.Position position : Employee.Position.values()) {
            System.out.println(++count + ". " + position);
        }
        String positionChoice;
        String position = "";
        boolean flag2;
        do {
            do {
                System.out.print("Your choice: ");
                positionChoice = sc.nextLine();
                if (!positionChoice.matches(CHOICE_REGEX)) {
                    System.out.print("Please try again.");
                }
            } while (!positionChoice.matches(CHOICE_REGEX));
            flag2 = false;
            switch (Integer.parseInt(positionChoice)) {
                case 1:
                    position = Employee.Position.RECEPTIONIST.getValue();
                    break;
                case 2:
                    position = Employee.Position.WAITER.getValue();
                    break;
                case 3:
                    position = Employee.Position.SPECIALIST.getValue();
                    break;
                case 4:
                    position = Employee.Position.SUPERVISOR.getValue();
                    break;
                case 5:
                    position = Employee.Position.MANAGER.getValue();
                    break;
                case 6:
                    position = Employee.Position.DIRECTOR.getValue();
                    break;
                default:
                    System.out.println("Please enter from 1 to 6.");
                    flag2 = true;
            }
        } while (flag2);

        System.out.print("Enter salary: ");
        int salary = Integer.parseInt(sc.nextLine());

        Employee newEmployee = new Employee(id, name, dateOfBirth, gender, cmnd, phoneNumber, email, qualification, position, salary);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(newEmployee);
        ReadAndWriteCSVFile.writeListToCSVFile(employeeList, EMPLOYEE_FILE_PATH, true);
    }

    @Override
    public void display() {
        List<Employee> employeeList = ReadAndWriteCSVFile.readEmployeeFromCSVFile(EMPLOYEE_FILE_PATH);
        if (employeeList.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("-----------Employee list-----------");
            int count = 0;
            for (Employee employee : employeeList) {
                System.out.println("Employee " + ++count);
                System.out.println("Id: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Date of birth: " + employee.getDateOfBirth());
                System.out.println("Gender: " + employee.getGender());
                System.out.println("Cmnd: " + employee.getCmnd());
                System.out.println("Phone number: " + employee.getPhoneNumber());
                System.out.println("Email: " + employee.getEmail());
                System.out.println("Qualification: " + employee.getQualification());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Salary: " + employee.getSalary());
                System.out.println("------------------------");
            }
        }
    }

    @Override
    public void edit() {
        List<Employee> employeeList = ReadAndWriteCSVFile.readEmployeeFromCSVFile(EMPLOYEE_FILE_PATH);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println((i + 1) + ". " + employeeList.get(i));
        }
        String id;
        do {
            System.out.print("Enter employee id to edit: ");
            id = sc.nextLine();
            if (!id.matches(EDIT_REGEX)) {
                System.out.println("Please try again.\n");
            }
        } while (!id.matches(EDIT_REGEX));
        boolean check = false;
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == Integer.parseInt(id)) {
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
                System.out.println("1. Id.\n" +
                        "2. Name.\n" +
                        "3. Date of birth.\n" +
                        "4. Gender.\n" +
                        "5. Cmnd.\n" +
                        "6. Phone number.\n" +
                        "7. Email.\n" +
                        "8. Qualification\n" +
                        "9. Position.\n" +
                        "10. Salary.\n" +
                        "11.OK.");
                do {
                    System.out.print("Your choice: ");
                    editChoice = sc.nextLine();
                    if (!editChoice.matches(EDIT_REGEX)) {
                        System.out.println("Please try again.\n");
                    }
                } while (!editChoice.matches(EDIT_REGEX));
                switch (Integer.parseInt(editChoice)) {
                    case 1:
                        System.out.println("Current id: " + employeeList.get(index).getId());
                        System.out.print("Enter new id: ");
                        int newId = Integer.parseInt(sc.nextLine());
                        employeeList.get(index).setId(newId);
                        break;
                    case 2:
                        System.out.println("Current name: " + employeeList.get(index).getName());
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        employeeList.get(index).setName(newName);
                        break;
                    case 3:
                        System.out.println("Current date of birth: " + employeeList.get(index).getDateOfBirth());
                        System.out.print("Enter new date of birth: ");
                        String newDateOfBirth = sc.nextLine();
                        employeeList.get(index).setDateOfBirth(newDateOfBirth);
                        break;
                    case 4:
                        System.out.println("Current gender: " + employeeList.get(index).getGender());
                        System.out.print("Enter new gender: ");
                        String newGender = sc.nextLine();
                        employeeList.get(index).setGender(newGender);
                        break;
                    case 5:
                        System.out.println("Current cmnd: " + employeeList.get(index).getCmnd());
                        System.out.print("Enter new cmnd: ");
                        String newCmnd = sc.nextLine();
                        employeeList.get(index).setCmnd(newCmnd);
                        break;
                    case 6:
                        System.out.println("Current phone number: " + employeeList.get(index).getPhoneNumber());
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = sc.nextLine();
                        employeeList.get(index).setPhoneNumber(newPhoneNumber);
                        break;
                    case 7:
                        System.out.println("Current email: " + employeeList.get(index).getEmail());
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        employeeList.get(index).setEmail(newEmail);
                        break;
                    case 8:
                        System.out.println("Current qualification: " + employeeList.get(index).getQualification());
                        System.out.println("--------Qualification list--------");
                        int count = 0;
                        for (Employee.Qualification qualification : Employee.Qualification.values()) {
                            System.out.println(++count + ". " + qualification);
                        }
                        String qualificationChoice;
                        String qualification = "";
                        boolean flag2;
                        do {
                            do {
                                System.out.print("Your new choice: ");
                                qualificationChoice = sc.nextLine();
                                if (!qualificationChoice.matches(CHOICE_REGEX)) {
                                    System.out.println("Please try again.");
                                }
                            } while (!qualificationChoice.matches(CHOICE_REGEX));
                            flag2 = false;
                            switch (Integer.parseInt(qualificationChoice)) {
                                case 1:
                                    qualification = Employee.Qualification.INTERMEDIATE.getValue();
                                    break;
                                case 2:
                                    qualification = Employee.Qualification.COLLEGE.getValue();
                                    break;
                                case 3:
                                    qualification = Employee.Qualification.UNDERGRADUATE.getValue();
                                    break;
                                case 4:
                                    qualification = Employee.Qualification.GRADUATE.getValue();
                                    break;
                                default:
                                    System.out.println("Please enter from 1 to 4.");
                                    flag2 = true;
                            }
                        } while (flag2);
                        employeeList.get(index).setQualification(qualification);
                        break;
                    case 9:
                        System.out.println("Current position: " + employeeList.get(index).getPosition());
                        System.out.println("--------Position list--------");
                        count = 0;
                        for (Employee.Position position : Employee.Position.values()) {
                            System.out.println(++count + ". " + position);
                        }
                        String positionChoice;
                        String position = null;
                        boolean flag3;
                        do {
                            do {
                                System.out.print("Your new choice: ");
                                positionChoice = sc.nextLine();
                                if (!positionChoice.matches(CHOICE_REGEX)) {
                                    System.out.print("Please try again.");
                                }
                            } while (!positionChoice.matches(CHOICE_REGEX));
                            flag3 = false;
                            switch (Integer.parseInt(positionChoice)) {
                                case 1:
                                    position = Employee.Position.RECEPTIONIST.getValue();
                                    break;
                                case 2:
                                    position = Employee.Position.WAITER.getValue();
                                    break;
                                case 3:
                                    position = Employee.Position.SPECIALIST.getValue();
                                    break;
                                case 4:
                                    position = Employee.Position.SUPERVISOR.getValue();
                                    break;
                                case 5:
                                    position = Employee.Position.MANAGER.getValue();
                                    break;
                                case 6:
                                    position = Employee.Position.DIRECTOR.getValue();
                                    break;
                                default:
                                    System.out.println("Please enter from 1 to 6.");
                                    flag3 = true;
                            }
                        } while (flag3);
                        employeeList.get(index).setPosition(position);
                        break;
                    case 10:
                        System.out.println("Current salary: " + employeeList.get(index).getPosition());
                        System.out.print("Enter new salary: ");
                        int newSalary = Integer.parseInt(sc.nextLine());
                        employeeList.get(index).setSalary(newSalary);
                        break;
                    case 11:
                        flag = false;
                        break;
                    default:
                        System.out.println("Please enter from 1 to 10.");
                }
            } while (flag);
            ReadAndWriteCSVFile.writeListToCSVFile(employeeList, EMPLOYEE_FILE_PATH, false);
        }
    }
}
