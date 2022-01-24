package ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.util;

import ss17_io_binary_file_and_serialization.bai_tap.product_manager_saves_to_binary_files.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSVFile {
    public static void writeObjectProductListToBinaryFile(List<Product> productList, String filepath) {
        File file = new File(filepath);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readObjectProductListToFromBiranyFile(String filePath) {
        List<Product> productList = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            if (file.length() > 0) {
                ois = new ObjectInputStream(fis);
                productList = (ArrayList<Product>) ois.readObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
