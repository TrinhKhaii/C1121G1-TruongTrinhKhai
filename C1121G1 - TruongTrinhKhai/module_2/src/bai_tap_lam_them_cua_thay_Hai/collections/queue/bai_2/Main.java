package bai_tap_lam_them_cua_thay_Hai.collections.queue.bai_2;

import java.util.*;

/*
Ngân hàng BIG-Bank mở một chi nhánh ở Bucharest
và được trang bị một máy tính hiện đại với các công nghệ mới nhập, C2#,VC3+ ...
chỉ chuối mỗi cái là không ai biết lập trình.
Họ cần một phần mềm mô tả hoạt động của ngân hàng như sau:
mỗi khách hàng có một mã số là số nguyên K, và khi đến ngân hàng giao dịch,
họ sẽ nhận được 1 số P là thứ tự ưu tiên của họ. Các thao tác chính như sau:
0 Kết thúc phục vụ
1 K P Thêm khách hàng K vào hàng đợi với độ ưu tiên P
2 Phục vụ người có độ ưu tiên cao nhất và xóa khỏi danh sách hàng đợi
3 Phục vụ người có độ ưu tiên thấp nhất và xóa khỏi danh sách hàng đợi.
Tất nhiên là họ cần bạn giúp rồi.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static class CustomerComparatorHighestPriority implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.getPriority() > o2.getPriority()) {
                return -1;
            } else if (o1.getPriority() < o2.getPriority()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static class CustomerComparatorLowestPriority implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.getPriority() < o2.getPriority()) {
                return -1;
            } else if (o1.getPriority() > o2.getPriority()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Queue<Node> customerQueueHighest = new PriorityQueue<>(new CustomerComparatorHighestPriority());
        Queue<Node> customerQueueLowest = new PriorityQueue<>(new CustomerComparatorLowestPriority());

        boolean check = true;
        int yourChoice;
        do {
            System.out.println("Menu: ");
            System.out.println("0 Kết thúc phục vụ.\n" +
                    "1. K P Thêm khách hàng K vào hàng đợi với độ ưu tiên P.\n" +
                    "2. Phục vụ người có độ ưu tiên cao nhất và xóa khỏi danh sách hàng đợi.\n" +
                    "3. Phục vụ người có độ ưu tiên thấp nhất và xóa khỏi danh sách hàng đợi.\n");
            System.out.print("Your choice: ");
            yourChoice = Integer.parseInt(sc.nextLine());
            switch (yourChoice) {
                case 1:
                    System.out.print("Enter id of customer: ");
                    int cusId = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter prioty of customer: ");
                    int priority = Integer.parseInt(sc.nextLine());
                    customerQueueHighest.add(new Node(cusId, priority));
                    customerQueueLowest.add(new Node(cusId, priority));
                    break;
                case 2:
                    List<Node> lowestList = new ArrayList<>(customerQueueLowest);
                    lowestList.remove(customerQueueHighest.peek());
                    customerQueueLowest.clear();
                    customerQueueLowest.addAll(lowestList);
                    System.out.println("Remove: " + customerQueueHighest.remove().getCustomerId());
                    System.out.println("Highest: " + customerQueueHighest);
                    System.out.println("Lowest: " + customerQueueLowest);
                    break;
                case 3:
                    List<Node> highestList = new ArrayList<>(customerQueueHighest);
                    highestList.remove(customerQueueLowest.peek());
                    customerQueueHighest.clear();
                    customerQueueHighest.addAll(highestList);
                    System.out.println("Remove: " + customerQueueLowest.remove().getCustomerId());
                    System.out.println("Highest: " + customerQueueHighest);
                    System.out.println("Lowest: " + customerQueueLowest);
                    break;
                case 0:
                    System.out.println("Thanks!");
                    check = false;
                    break;
                default:
                    System.out.println("Please try again!");
            }
        } while (check);

    }
}
