public class Main {
    public static void main(String[] args) {
        Person say = new Person();
        say.hello();
        say.hello("liuliu");
        say.hello("xiaohua", 12);
        say.hello("dahua", 44);
    }
}

class Person {
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}