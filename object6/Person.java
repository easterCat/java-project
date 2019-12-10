public class Main {
    public static void main(String[] args) {
        Person s = new Student();
        s.run();
        System.out.println(s.hello());
    }
}


class Person {
    public void run() {
        System.out.println("person");
    }

    public String hello() {
        return "hello,person";
    }
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("student");
    }

    @java.lang.Override
    public String hello() {
        System.out.println("hello,student");
        return super.hello() + "!";
    }
}

