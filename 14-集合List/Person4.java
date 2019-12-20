import java.util.List;

public class Main {
    public static void main(String[] args) {
        Method1();
    }

    // boolean contains(Object o)方法来判断List是否包含某个指定元素
    // int indexOf(Object o)方法可以返回某个元素的索引，如果元素不存在，就返回-1
    public static void Method1() {
        List<String> list = List.of("11111", "22222", "33333"); // 创建list
        System.out.println(list.contains("11111"));
        System.out.println(list.contains("444"));
        System.out.println(list.indexOf("22222"));
        System.out.println(list.indexOf("555"));
    }
}