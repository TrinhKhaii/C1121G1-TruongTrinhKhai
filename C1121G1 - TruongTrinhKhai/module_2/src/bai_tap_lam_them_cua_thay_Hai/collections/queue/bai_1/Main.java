package bai_tap_lam_them_cua_thay_Hai.collections.queue.bai_1;

/*
Do những ngày hè quá nóng bức và nhàm chán nên Tide đã nghĩ ra một trò chơi khá thú vị với queue.
Ban đầu trong queue có 5 số 1, 2, 3, 4, 5 với mỗi lượt chơi
Tide sẽ xóa phần tử ở đầu queue và cho 2 phần tử đó xuống cuối của queue
và cứ tiếp tục cho đến khi Tide cảm thấy mệt và không chơi được nữa.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static Queue<Integer> tideQueue = new LinkedList<>();
    static {
        tideQueue.add(1);
        tideQueue.add(2);
        tideQueue.add(3);
        tideQueue.add(4);
        tideQueue.add(5);
    }
    public static void popAndDoubleAdd() {
        int temp = tideQueue.remove();
        for (int i = 0; i < 2; i++) {
            tideQueue.add(temp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of times played by tide: ");
        int num = Integer.parseInt(sc.nextLine());
        System.out.print("Queue of Tide: ");
        System.out.println(tideQueue);
        for (int i = 0; i< num; i++) {
            popAndDoubleAdd();
        }
        System.out.print("After: ");
        System.out.println(tideQueue);
        System.out.print("Result: ");
        System.out.println(tideQueue.peek());

    }
}
