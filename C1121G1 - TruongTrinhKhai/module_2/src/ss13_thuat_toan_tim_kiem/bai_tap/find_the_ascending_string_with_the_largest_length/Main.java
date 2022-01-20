package ss13_thuat_toan_tim_kiem.bai_tap.find_the_ascending_string_with_the_largest_length;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                }
            }
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


/***********************************************
 *  Tính toán độ phức tạp:                     *
 *  vòng lặp ngoài : n                         *
 *  vòng lặp trong : n - 1                     *
 *  1 vòng lặp * 1 câu lệnh : 1                *
 *  T(n) = (n * (n - 1) + (1 + 1))             *
 *  T(n) = O(n^2) + O(n)                       *
 *  T(N) = O(N^2)                              *
 *  -> Độ phức tạp của chương trình: O(n^2)    *
 ***********************************************/
