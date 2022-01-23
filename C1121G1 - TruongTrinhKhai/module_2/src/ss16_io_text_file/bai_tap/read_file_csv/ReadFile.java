package ss16_io_text_file.bai_tap.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Nation> readFile(String filePath) {
        List<Nation> nationList = new ArrayList<>();
        File file = new File(filePath);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedWriter = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedWriter.readLine()) != null) {
                array = line.split(",");
                Nation nation = new Nation(Integer.parseInt(array[0]), array[1] , array[2]);
                nationList.add(nation);
            }
        } catch (IOException e) {
            System.err.println("Read file error.");
        }
        return nationList;
    }

    public static void main(String[] args) {
        List<Nation> nationList = readFile("src/ss16_io_text_file/bai_tap/read_file_csv/NationsList.csv");
        for (Nation nation : nationList) {
            System.out.println(nation);
        }
    }
}
