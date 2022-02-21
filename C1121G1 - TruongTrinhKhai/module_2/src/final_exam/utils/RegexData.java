package final_exam.utils;

import final_exam.utils.exceptions.DateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner sc = new Scanner(System.in);

    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = sc.nextLine();
            }
        } while (check);
        return temp;
    }

    public static String regexDateOfDischarge(String temp, String dateOfAdmission, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate endDay = LocalDate.parse(temp, formatter);
                    LocalDate startDay = LocalDate.parse(dateOfAdmission, formatter);
                    if (endDay.isAfter(startDay)) {
                        check = false;
                    } else {
                        throw new DateException("Date of discharge must after date of admission");
                    }
                } else {
                    throw new DateException("Wrong format of date");
                }
            } catch (DateException e) {
                e.printStackTrace();
                temp = sc.nextLine();
            }
        }
        return temp;
    }
}
