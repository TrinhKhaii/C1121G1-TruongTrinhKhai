package ss16_io_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
//    public static int count;
    public List<Character> readFile(String filePath) {
        List<Character> characters = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(filePath);

            int character;
            String temp = "";
            while ((character = fileReader.read()) != -1) {
                characters.add((char) character);
//                count++;
            }
            fileReader.close();
        } catch (Exception e) {
            System.err.println("File does not exist or the content has errors.");
        }
        return characters;
    }

    public static int countOfChar(List<Character> characters) {
        return characters.size();
    }

    public void writeFile(String filePath, List<Character> characters, int count) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter br = new BufferedWriter(writer);
            for (Character i : characters) {
                br.write(i);
            }
            br.write("\nNumber of character in file: " + count);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        List<Character> characterList = copyFile.readFile("src/ss16_io_text_file/bai_tap/copy_file_text/Source.txt");
        int count = countOfChar(characterList);
        copyFile.writeFile("src/ss16_io_text_file/bai_tap/copy_file_text/Target.txt", characterList, count);
    }
}
