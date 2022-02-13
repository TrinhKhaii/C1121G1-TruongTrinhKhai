//
// created by Trinh Khai at 16:03 26/1/2022
//

package models;

public class Employee extends Person {
    public enum Qualification {
        INTERMEDIATE("Intermediate"),
        COLLEGE("College"),
        UNDERGRADUATE("Undergraduate"),
        GRADUATE("Graduate");
        private final String value;
        Qualification(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }
    public enum Position {
        RECEPTIONIST("Receptionist"),
        WAITER("Waiter"),
        SPECIALIST("Specialist"),
        SUPERVISOR("Supervisor"),
        MANAGER("Manager"),
        DIRECTOR("Director");
        private final String value;
        Position(final String value) {
            this.value = value;
        }
        public String getValue() { return value; }
    }

    private String qualification;
    private String position;
    private int salary;

    public Employee(int id, String name, String dateOfBirth, String gender, String cmnd, String phoneNumber, String email) {
        super(id, name, dateOfBirth, gender, cmnd, phoneNumber, email);
    }

    public Employee(int id, String name, String dateOfBirth, String gender, String cmnd, String phoneNumber, String email, String qualification, String position, int salary) {
        super(id, name, dateOfBirth, gender, cmnd, phoneNumber, email);
        this.qualification = qualification;
        this.position = position;
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", qualification=" + qualification +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getName() + "," + this.getDateOfBirth() + "," + this.getGender() +
                "," + this.getCmnd() + "," + this.getPhoneNumber() + "," + this.getEmail() +
                "," + this.getQualification() + "," + this.getPosition() + "," + this.getSalary();
    }
}
