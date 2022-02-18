package case_study.phone_management_program_c09.utils;

import case_study.phone_management_program_c09.models.GenuinePhone;
import case_study.phone_management_program_c09.models.Phone;
import case_study.phone_management_program_c09.models.PortablePhone;
import case_study.product_management_program_c10.models.Product;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCSVFile {
    public static <E> void writeListToCSVFile(List<E> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E element: list) {
                if (element instanceof GenuinePhone) {
                    bufferedWriter.write(((GenuinePhone)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof PortablePhone) {
                    bufferedWriter.write(((PortablePhone) element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String NUMBER_REGEX = "^\\d+$";
    public static List<Phone> readPhoneFromCSVFile(String filePath) {
        List<Phone> PhoneList = new LinkedList<>();
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
                if (array[5].matches(NUMBER_REGEX)) {
                    GenuinePhone genuinePhone = new GenuinePhone(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4], Integer.parseInt(array[5]), array[6]);
                    PhoneList.add(genuinePhone);
                } else {
                    PortablePhone portablePhone = new PortablePhone(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[4], array[5], array[6]);
                    PhoneList.add(portablePhone);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PhoneList;
    }

}
