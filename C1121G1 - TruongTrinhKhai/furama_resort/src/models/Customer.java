//
// created by Trinh Khai at 16:09 26/1/2022
//

package models;

public class Customer extends Person{
    public enum CustomerType {
        DIAMOND("Diamond"),
        PLATIUM("Platinium"),
        GOLD("Gold"),
        SILVER("Silver"),
        MEMBER("Member");
        private final String value;
        CustomerType(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }

    private String customerType;
    private String address;

    public Customer(int id, String name, String dateOfBirth, String gender, String cmnd, String phoneNumber, String email) {
        super(id, name, dateOfBirth, gender, cmnd, phoneNumber, email);
    }

    public Customer(int id, String name, String dateOfBirth, String gender, String cmnd, String phoneNumber, String email, String customerType, String address) {
        super(id, name, dateOfBirth, gender, cmnd, phoneNumber, email);
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public java.lang.String toString() {
        return "Customer{" +
                super.toString() +
                ", customerType='" + customerType + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public java.lang.String getInfoToWriteCSV() {
        return this.getId() + "," + this.getName() + "," + this.getDateOfBirth() + "," + this.getGender() +
                "," + this.getCmnd() + "," + this.getPhoneNumber() + "," + this.getEmail() +
                "," + this.getCustomerType() + "," + this.getAddress();
    }
}
