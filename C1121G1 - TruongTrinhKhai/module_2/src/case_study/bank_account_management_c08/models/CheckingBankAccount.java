package case_study.bank_account_management_c08.models;

public class CheckingBankAccount extends Bank{
    private long cardNumber;
    private int accountBalance;

    public CheckingBankAccount(int id, String code, String name, String creationDate, long cardNumber, int accountBalance) {
        super(id, code, name, creationDate);
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "CheckingBankAccount{" +
                super.toString() +
                ", cardNumber=" + cardNumber +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public String getInfoToWriteCSV() {
        return this.getId() + "," + this.getCode() + "," + this.getName() + "," + this.getCreationDate() + ","
                + this.getCardNumber() + "," + this.getAccountBalance();
    }
}
