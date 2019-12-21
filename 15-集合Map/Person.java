import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("xiao qiang", 12);
        Map<String, Student> map = new HashMap<>();
        map.put("xiao huang", s);
        Student target = map.get("xiao qiang");
        System.out.println(target == s);
        System.out.println(target.score);
        Student anothor = map.get("bob");
        System.out.println(anothor);

    }
}

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}