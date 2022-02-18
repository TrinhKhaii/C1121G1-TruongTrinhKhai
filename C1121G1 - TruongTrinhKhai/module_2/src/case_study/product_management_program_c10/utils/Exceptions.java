package case_study.product_management_program_c10.utils;

public class Exceptions {
    public static void NotFoundProductException() throws Exception {
        throw new Exception("Your id does not exist.");
    }
}
