package ss2_vong_lap_trong_java.bai_tap;


public class DisplayPrimesLessThan100 {
    public static void main(String[] args) {
        System.out.println("Primes less than 100: ");
        for (int i = 2; i < 100; i++) {
            boolean check = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(i + ", ");
            }
        }
    }
}
