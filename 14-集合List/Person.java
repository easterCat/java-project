import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("cccc");
        list.add("aaaa"); // 允许重复添加元素
        list.add("null"); // List还允许添加null
        System.out.println(list.size());
        System.out.println(list.get(3));
    }
}