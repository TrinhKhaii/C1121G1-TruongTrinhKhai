/*
    Created by Trinh Khai
    Date: 16/03/2022
    Time: 16:14
*/

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sum: " + Calculator.sum(5, 9));
        System.out.println("Sub: " + Calculator.sub(5, 9));
        System.out.println("Mul: " + Calculator.mul(5, 9));
        try {
            System.out.println("Div: " + Calculator.div(5, 9));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
