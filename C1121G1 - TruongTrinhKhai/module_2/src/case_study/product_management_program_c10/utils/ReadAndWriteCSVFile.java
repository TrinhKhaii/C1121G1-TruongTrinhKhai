package case_study.product_management_program_c10.utils;

import case_study.phone_management_program_c09.models.GenuinePhone;
import case_study.phone_management_program_c09.models.Phone;
import case_study.phone_management_program_c09.models.PortablePhone;
import case_study.product_management_program_c10.models.ExportProduct;
import case_study.product_management_program_c10.models.ImportProduct;
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
                if (element instanceof ImportProduct) {
                    bufferedWriter.write(((ImportProduct)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof ExportProduct) {
                    bufferedWriter.write(((ExportProduct)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readProductFromCSVFile(String filePath) {
        List<Product> productList = new LinkedList<>();
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
                if (array.length == 9) {
                    ImportProduct importProduct = new ImportProduct(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]), array[7], Integer.parseInt(array[8]));
                    productList.add(importProduct);
                } else {
                    ExportProduct exportProduct = new ExportProduct(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]), array[5] , Integer.parseInt(array[6]), array[7]);
                    productList.add(exportProduct);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
