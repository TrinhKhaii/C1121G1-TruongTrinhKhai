package ss19_string_and_regex.bai_tap.validate_phone_number;


public class Main {
    private static final String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)-\\(\\d{10,11}\\)$";

    public static void main(String[] args) {
        String phoneNumber = "(84)-(0901960757)";
        boolean check = phoneNumber.matches(PHONE_NUMBER_REGEX);
        System.out.println("Result: " + check);
    }
}
