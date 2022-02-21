package final_exam.utils.exceptions;

public class Exceptions {
    public static void NotFoundMedicalRecordException() throws Exception {
        throw new Exception("Your medical record does not exist.");
    }
}

