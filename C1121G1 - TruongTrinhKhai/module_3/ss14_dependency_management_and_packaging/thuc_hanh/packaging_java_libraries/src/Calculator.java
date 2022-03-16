/*
    Created by Trinh Khai
    Date: 16/03/2022
    Time: 16:02
*/

import java.security.NoSuchAlgorithmException;

public class Calculator {
    public static void main(String[] args) {

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) throws NoSuchAlgorithmException {
        if (b == 0) {
            throw new NoSuchAlgorithmException();
        }
        return a / b;
    }
}
