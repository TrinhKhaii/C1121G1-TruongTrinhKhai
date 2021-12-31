package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

public class FindMinValueInArray {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, -8, 1, 6, 9};
        System.out.println("The smallest element in the array is: " + minValue(arr));
    }

    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
