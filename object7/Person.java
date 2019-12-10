public class Main {
    public static void main(String[] args) {
        Person s = new Student();
        Person t = new Teacher();
        Person p = new Police();
        // 不关心Person变量的具体子类型:
        s.run();
        t.run();
        p.run();
    }
}

abstract class Person {
    public abstract void run();
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("S is runing");
    }
}

class Teacher extends Person {
    @Override
    public void run() {
        System.out.println("T is runing");
    }
}

class Police extends Person {
    @Override
    public void run() {
        System.out.println("P is runing");
    }
}