import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Method1();
    }

    public static void Method1() {
        List<Student> list = List.of(
                new Student("Bob", 78),
                new Student("Alice", 85),
                new Student("cccc", 3333),
                new Student("dddd", 444));
        var holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
}

class Students {
    public List<Student> list;
    public Map<String, Integer> cache;

    Students(List<Student> list) {
        this.list = list;
        this.cache = new HashMap<>();
    }

    public int getScore(String name) {
        Integer score = this.cache.get(name);
        if (score == null) {
            score = findInList(name);
        } else {
            cache.put(name, score);
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for (var ss : this.list) {
            if (ss.name.equals(name)) {
                return ss.score;
            }
        }
        return null;
    }
}

class Student {
    public String name;
    public int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
