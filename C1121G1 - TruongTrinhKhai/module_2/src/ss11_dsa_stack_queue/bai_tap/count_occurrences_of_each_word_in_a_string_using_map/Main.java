package ss11_dsa_stack_queue.bai_tap.count_occurrences_of_each_word_in_a_string_using_map;


import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String myStr = "i can do this can day";
        Map<String, Integer> stringMap = new TreeMap<>();
        String[] myStrList = myStr.split(" ");
        for (String word : myStrList) {
            if (!stringMap.containsKey(word)) {
                stringMap.put(word, 1);
            } else {
                stringMap.replace(word, stringMap.get(word) + 1);
            }
        }
        System.out.println(stringMap);
    }
}
