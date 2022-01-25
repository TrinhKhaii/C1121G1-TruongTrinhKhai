package ss19_string_and_regex.thuc_hanh.validate_account;

public class Main {
    public static final String ACCOUNT_NAME_REGEX = "^[_a-z0-9]{6,}$";

    public static void main(String[] args) {
        String[] validAccount = new String[] {"123abc_", "_abc123", "______", "123456","abcdefgh"};
        String[] invalidAccount = new String[] {".@", "12345", "1234_", "abcde"};

        for (String account: validAccount) {
            boolean isValid = account.matches(ACCOUNT_NAME_REGEX);
            System.out.println("Account name: " + account + " is valid: " + isValid);
        }
        for (String account: invalidAccount) {
            boolean isValid = account.matches(ACCOUNT_NAME_REGEX);
            System.out.println("Account name: " + account + " is valid: " + isValid);
        }
    }
}
