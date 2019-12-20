import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Method1(); // for循环根据索引配合get(int)方法遍历
        Method2(); // 迭代器Iterator
        Method3();
    }

    public static void Method1() {
        List<String> list = List.of("asdasd", "aaaaaa", "bbbbbb"); // 创建list
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }

    public static void Method2() {
        List<String> list = List.of("1111111", "22222222", "33333333");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }

    public static void Method3() {
        List<String> list = List.of("阿达硕大的所", "嘎嘎嘎嘎嘎", "发");
        for (String s : list) {
            System.out.println(s);
        }
    }
}