package utils;

import models.*;
import services.impl.BookingServiceImpl;
import services.impl.SortByDate;

import java.io.*;
import java.util.*;

import static services.impl.CustomerServiceImpl.CUSTOMER_FILE_PATH;

public class ReadAndWriteCSVFile {
     static List<Customer> customerList = ReadAndWriteCSVFile.readCustomerFromCVSFile(CUSTOMER_FILE_PATH);


    public static <E> void writeListToCSVFile(List<E> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E element: list) {
                if (element instanceof Employee) {
                    bufferedWriter.write(((Employee)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof Customer) {
                    bufferedWriter.write(((Customer)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof Contract) {
                    bufferedWriter.write(((Contract)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
//            bufferedWriter.flush();
//            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <K> void writeMapToCSVFile(Map<K, Integer> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<K> set = list.keySet();
            for (K key: set) {
                if (key instanceof Villa) {
                    bufferedWriter.write(((Villa)key).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (key instanceof House) {
                    bufferedWriter.write(((House)key).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (key instanceof Room) {
                    bufferedWriter.write(((Room)key).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> void writeSetToCSVFile(Set<E> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E element: list) {
                if (element instanceof Booking) {
                    bufferedWriter.write(((Booking)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeFromCSVFile(String filePath) {
        List<Employee> list = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Employee employee = new Employee(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8],Integer.parseInt(array[9]));
                list.add(employee);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Customer> readCustomerFromCVSFile(String filePath) {
        List<Customer> list = new LinkedList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Customer customer = new Customer(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
                list.add(customer);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<Villa, Integer> readVillaFromCSVFile(String filePath) {
        Map<Villa, Integer> list = new LinkedHashMap<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Villa villa = new Villa(array[0], array[1], Float.parseFloat(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]), array[7], Float.parseFloat(array[8]), Integer.parseInt(array[9]));
                list.put(villa, villa.getNumberOfTimesToRent());
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<House, Integer> readHouseFromCSVFile(String filePath) {
        Map<House, Integer> list = new LinkedHashMap<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                House house = new House(array[0], array[1], Float.parseFloat(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]), array[7], Integer.parseInt(array[8]));
                list.put(house, house.getNumberOfTimesToRent());
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<Room, Integer> readRoomFromCSVFile(String filePath) {
        Map<Room, Integer> list = new LinkedHashMap<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                Room room = new Room(array[0], array[1], Float.parseFloat(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]), array[7]);
                list.put(room, room.getNumberOfTimesToRent());
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Set<Booking> readBookingFromCSVFile(String filePath) {
        Set<Booking> list = new TreeSet<>(new SortByDate());
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                for (Customer element : customerList) {
                    if (element.getId() == Integer.parseInt(array[3])) {
                        Booking booking = new Booking(array[0], array[1], array[2], element, array[4], array[5]);
                        list.add(booking);
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Queue<Contract> readContractFromCSVFile(String filePath) {
        Queue<Contract> list = new LinkedList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                for (Customer element : customerList) {
                    if (element.getId() == Integer.parseInt(array[4])) {
                        Contract contract = new Contract(Integer.parseInt(array[0]), array[1],
                                Float.parseFloat(array[2]), Float.parseFloat(array[3]), element);
                        list.add(contract);
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
