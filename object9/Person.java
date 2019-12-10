public class Main {
    public static void main(String[] args) {
        Person ming = new Person("xiao ming", 22);
        Person hong = new Person("xiao hong", 44);
        ming.number = 88;
        System.out.println(hong.number);
        hong.number = 99;
        System.out.println(ming.number);
        System.out.println(hong.number);
        Person.setNumber(101);
        System.out.println(Person.number);
    }
}

class Person {
    public String name;
    public int age;

    public static int number;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void setNumber(int value){
        number = value;
    }
}