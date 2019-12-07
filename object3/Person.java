public class Main {
    public static void main(String[] args) {
        Person ming = new Person("xiaoming", 22);
        System.out.println(ming.getName() + "_" + ming.getAge());
    }
}

class Person {
    private String name = "default";
    private int age = 101;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}