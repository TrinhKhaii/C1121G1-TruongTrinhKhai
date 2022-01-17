package ss13_thuat_toan_tim_kiem.optional_bai_tap.find_the_longest_consecutive_string;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (list.size() > 1 && str.charAt(i) <= list.getLast() && list.contains(str.charAt(i))) {
                list.clear();
            }
            list.add(str.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }
        for (Character c : max) {
            System.out.print(c);
        }
        System.out.println();
    }
}
/*************************************************
 * Tính toán độ phức tạp của thuật toán này:
 *  1 vòng lặp : n
 *  1 vòng lặp * 1 câu lệnh : 1
 *  T(n) = n + 1
 *  T(n) = O(n)
 *  Độ phức tạp của bài toán là O(n)
 *************************************************/