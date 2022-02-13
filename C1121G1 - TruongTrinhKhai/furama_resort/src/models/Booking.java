//
// created by Trinh Khai at 16:12 26/1/2022
//

package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Booking  {
    private String bookingId;
    private String startDay;
    private String endDay;
    private int customerId;
    private String serviceId;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingId, String startDay, String endDay, int customerId, String serviceId, String serviceType) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.serviceType = serviceType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceId;
    }

    public void setServiceName(String serviceName) {
        this.serviceId = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", customerId=" + customerId +
                ", serviceName='" + serviceId + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getBookingId() + "," + this.getStartDay() + "," + this.getEndDay() +
                "," + this.getCustomerId() + "," + this.getServiceName() + "," + this.getServiceType();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(startDay, booking.startDay) &&
                Objects.equals(endDay, booking.endDay) &&
                Objects.equals(serviceId, booking.serviceId) &&
                Objects.equals(serviceType, booking.serviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, startDay, endDay, customerId, serviceId, serviceType);
    }
}
