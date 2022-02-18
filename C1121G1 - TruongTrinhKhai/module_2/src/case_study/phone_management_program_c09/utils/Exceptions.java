package case_study.phone_management_program_c09.utils;


public class Exceptions {
    public static void NotFoundProductException() throws Exception {
        throw new Exception("Your id does not exist.");
    }
}
