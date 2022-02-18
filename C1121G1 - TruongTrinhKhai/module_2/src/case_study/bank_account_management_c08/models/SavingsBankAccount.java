package case_study.bank_account_management_c08.models;

public class SavingsBankAccount extends Bank{
    private int savingsDepositAmount;
    private String savingsDate;
    private int interestRate;
    private int term;

    public SavingsBankAccount(int id, String code, String name, String creationDate, int savingsDepositAmount, String savingsDate, int interestRate, int term) {
        super(id, code, name, creationDate);
        this.savingsDepositAmount = savingsDepositAmount;
        this.savingsDate = savingsDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public int getSavingsDepositAmount() {
        return savingsDepositAmount;
    }

    public void setSavingsDepositAmount(int savingsDepositAmount) {
        this.savingsDepositAmount = savingsDepositAmount;
    }

    public String getSavingsDate() {
        return savingsDate;
    }

    public void setSavingsDate(String savingsDate) {
        this.savingsDate = savingsDate;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "SavingsBankAccount{" +
                super.toString() +
                ", savingsDepositAmount=" + savingsDepositAmount +
                ", savingsDate='" + savingsDate + '\'' +
                ", interestRate=" + interestRate +
                ", term=" + term +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getCode() + "," + this.getName() + "," + this.getCreationDate() + ","
                + this.getSavingsDepositAmount() + "," + this.getSavingsDate() + "," + this.getInterestRate() + ","
                + this.getTerm();
    }
}
