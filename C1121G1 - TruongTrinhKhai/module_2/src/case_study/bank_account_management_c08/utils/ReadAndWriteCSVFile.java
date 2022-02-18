package case_study.bank_account_management_c08.utils;

import case_study.bank_account_management_c08.models.Bank;
import case_study.bank_account_management_c08.models.CheckingBankAccount;
import case_study.bank_account_management_c08.models.SavingsBankAccount;
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
                if (element instanceof SavingsBankAccount) {
                    bufferedWriter.write(((SavingsBankAccount)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof CheckingBankAccount) {
                    bufferedWriter.write(((CheckingBankAccount)element).getInfoToWriteCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Bank> readBankAccountFromCSVFile(String filePath) {
        List<Bank> bankList = new LinkedList<>();
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
                    SavingsBankAccount savingsBankAccount = new SavingsBankAccount(Integer.parseInt(array[0]), array[1], array[2], array[3], Integer.parseInt(array[4]), array[5], Integer.parseInt(array[6]),  Integer.parseInt(array[7]));
                    bankList.add(savingsBankAccount);
                } else {
                    CheckingBankAccount checkingBankAccount = new CheckingBankAccount(Integer.parseInt(array[0]), array[1], array[2], array[3], Long.parseLong(array[4]), Integer.parseInt(array[5]));
                    bankList.add(checkingBankAccount);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankList;
    }
}
