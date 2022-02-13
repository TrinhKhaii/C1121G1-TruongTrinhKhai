package ss17_io_binary_file_and_serialization.optional_bai_tap.copy_binary_file;

import java.io.*;

public class Main {
    public static void copyBinaryFile(File source, File dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int length;
        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            System.out.println("Copy completed.");
            System.out.println("Byte amount: " + source.length());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String sourcePath = "src/ss17_io_binary_file_and_serialization/optional_bai_tap/copy_binary_file/Source.cvs";
        String destPath = "src/ss17_io_binary_file_and_serialization/optional_bai_tap/copy_binary_file/Dest.csv";
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        copyBinaryFile(sourceFile, destFile);
    }
}
