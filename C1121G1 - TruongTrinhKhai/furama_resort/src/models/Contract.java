//
// created by Trinh Khai at 16:20 26/1/2022
//

package models;

public class Contract {
    private int contractNumber;
    private String bookingId;
    private float advanceDepositAmount;
    private float totalPaymentAmount;
    private Customer customerId;

    public Contract() {}

    public Contract(int contractNumber, String bookingId, float advanceDepositAmount, float totalPaymentAmount, Customer customerId) {
        this.contractNumber = contractNumber;
        this.bookingId = bookingId;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customerId = customerId;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public float getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(float advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public float getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(float totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingId='" + bookingId + '\'' +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", customerId=" + customerId.getId() +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getContractNumber() + "," + this.getBookingId() + "," +
                this.getAdvanceDepositAmount() + "," + this.getTotalPaymentAmount() +
                "," + this.getCustomerId().getId();
    }
}
