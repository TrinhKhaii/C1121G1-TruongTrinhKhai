package ss11_dsa_stack_queue.optional_bai_tap.demerging_using_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Khai", "Male", "21/12/2001"));
        personArrayList.add(new Person("Giang", "Female", "16/12/2001"));
        personArrayList.add(new Person("Nhi", "Female", "23/03/2001"));
        personArrayList.add(new Person("Anh", "Male", "08/04/2001"));
        System.out.println("Before: ");
        for (Person person : personArrayList) {
            System.out.println(person);
        }
        Collections.sort(personArrayList);
        Queue<Person> maleQueue = new LinkedList<>();
        Queue<Person> femaleQueue = new LinkedList<>();
        for (int i = 0; i < personArrayList.size(); i++) {
            if (personArrayList.get(i).getGender().equals("Male")) {
                maleQueue.add(personArrayList.get(i));
                personArrayList.remove(i);
                i--;
            } else {
                femaleQueue.add(personArrayList.get(i));
                personArrayList.remove(i);
                i--;
            }
        }
        while (!maleQueue.isEmpty()) {
            personArrayList.add(maleQueue.remove());
        }
        while ((!femaleQueue.isEmpty())) {
            personArrayList.add(femaleQueue.remove());
        }
        System.out.println("After: ");
        for (Person person : personArrayList) {
            System.out.println(person);
        }
    }
}
