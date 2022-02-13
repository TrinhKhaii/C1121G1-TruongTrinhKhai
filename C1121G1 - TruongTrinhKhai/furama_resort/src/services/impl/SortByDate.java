package services.impl;

import models.Booking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortByDate implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate1;
        Date endDate1;
        Date startDate2;
        Date endDate2;
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        int returnNumber = 0;
        try {
            startDate1 = formatter.parse(o1.getStartDay());
            endDate1 = formatter.parse(o1.getEndDay());
            startDate2 = formatter.parse(o2.getStartDay());
            endDate2 = formatter.parse(o2.getEndDay());
            if (startDate1.getTime() == startDate2.getTime()) {
                if (endDate1.before(endDate2)) {
                    returnNumber =  -1;
                } else if (endDate2.before(endDate1)) {
                    returnNumber =  1;
                }
            } else if (startDate1.before(startDate2)) {
                returnNumber =  -1;
            } else if (startDate2.before(startDate1)) {
                returnNumber =  1;
            }
        } catch (ParseException e) {
            System.out.println("Sai định dạng ngày.");
        }
        return returnNumber;
    }
}
