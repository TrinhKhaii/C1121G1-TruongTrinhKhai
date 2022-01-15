package ss11_dsa_stack_queue.optional_bai_tap.demerging_using_queue;

public class Person implements Comparable<Person>{
    private String name;
    private String gender;
    private String birthday;

    public Person() {
    }

    public Person(String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.getBirthday().compareTo(o.getBirthday());
    }
}
