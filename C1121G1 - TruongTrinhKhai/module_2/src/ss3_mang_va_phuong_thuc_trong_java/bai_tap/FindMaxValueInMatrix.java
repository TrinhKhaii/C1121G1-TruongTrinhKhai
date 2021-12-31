package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

public class FindMaxValueInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {2, 40, 6, 8},
                {21, 10, 12, 15}
        };
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max: " + max);
    }
}
