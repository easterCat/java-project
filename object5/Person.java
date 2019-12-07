public class Main {
    public static void main(String[] args) {
        Student ahua = new Student("liuliu",12,116);
        ahua.setScore(22);
        System.out.println(ahua.getScore());
        System.out.println(ahua.info());
    }
}

class Person {
    protected String name = "default";
    protected int age = 101;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Student extends Person {
    private int score;

    public Student(String name,int age,int score){
        super(name,age);
        this.score = score;
    }

    public String info(){
        return super.name + "-" + age + "-" + this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
}