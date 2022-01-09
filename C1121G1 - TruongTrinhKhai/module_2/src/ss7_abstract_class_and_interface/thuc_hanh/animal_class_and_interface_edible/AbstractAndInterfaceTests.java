package ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible;

import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.animal.Animal;
import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.animal.Chicken;
import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.animal.Tiger;
import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.edible.Edible;
import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.fruit.Apple;
import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.fruit.Fruit;
import ss7_abstract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Edible) {
//                Edible edibler = (Chicken) animal;
//                System.out.println(edibler.howToEat());
                System.out.println(((Edible) animal).howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }

    }
}
