package final_exam.utils;


import final_exam.models.MedicalRecord;
import final_exam.models.NormalPatient;
import final_exam.models.VipPatient;

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
                if (element instanceof NormalPatient) {
                    bufferedWriter.write(((NormalPatient)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof VipPatient) {
                    bufferedWriter.write(((VipPatient)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<MedicalRecord> readCaseFromCSVFile(String filePath) {
        List<MedicalRecord> medicalRecordList = new LinkedList<>();
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
                if (array.length == 8) {
                    NormalPatient normalPatient = new NormalPatient(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5], array[6], Float.parseFloat(array[7]));
                    medicalRecordList.add(normalPatient);
                } else {
                    VipPatient vipPatient = new VipPatient(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4], array[5] , array[6], array[7], array[8]);
                    medicalRecordList.add(vipPatient);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return medicalRecordList;
    }
}
