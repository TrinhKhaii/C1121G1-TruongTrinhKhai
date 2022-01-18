package bai_tap_lam_them_cua_thay_Hai.collections.queue.bai_2;

import java.util.Objects;

public class Node {
    private int customerId;
    private int priority;

    public Node() {
        this.customerId = 0;
        this.priority = 0;
    }

    public Node(int customerId, int prioty) {
        this.customerId = customerId;
        this.priority = prioty;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Node{" +
                "customerId=" + customerId +
                ", prioty=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return customerId == node.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
