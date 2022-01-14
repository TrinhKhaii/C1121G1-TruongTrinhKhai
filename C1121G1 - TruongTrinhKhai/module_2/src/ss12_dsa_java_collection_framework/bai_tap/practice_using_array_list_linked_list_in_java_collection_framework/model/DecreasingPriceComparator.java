package ss12_dsa_java_collection_framework.bai_tap.practice_using_array_list_linked_list_in_java_collection_framework.model;

import java.util.Comparator;

public class DecreasingPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
