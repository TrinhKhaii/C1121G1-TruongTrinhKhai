package ss13_thuat_toan_tim_kiem.optional_bai_tap.implement_binary_search_algorithm_using_recursion;

public class BinarySearchRecursion {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearchRecursion(int[] array, int left, int right ,int value) {
        int mid = (left + right) / 2;
        if (value == list[mid]) {
            return mid;
        } else if (value < list[mid] && left < right) {
            mid = binarySearchRecursion(list, left, mid - 1, value);
        } else if (value > list[mid] && left < right) {
            mid = binarySearchRecursion(list, mid + 1, right, value);
        } else {
            mid = -1;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(binarySearchRecursion(list, 0, list.length - 1, 10));
        System.out.println(binarySearchRecursion(list, 0, list.length - 1, 59));
        System.out.println(binarySearchRecursion(list, 0, list.length - 1, 60));
        System.out.println(binarySearchRecursion(list, 0, list.length - 1, 79));
        System.out.println(binarySearchRecursion(list, 0, list.length - 1, 80));

    }
}
