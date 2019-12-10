public class Main {
    public static void main(String[] args) {
        Person s = new Student("liuliu");
        s.run();
        System.out.println(s.getName());
    }
}

interface Person {
    default void run(){
        System.out.println(getName() + " run");
    };
    String getName();
}

class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}