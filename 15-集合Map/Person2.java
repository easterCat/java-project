import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("apple", 123);
        map.put("pear", 4444);
        map.put("apple", 999);
        map.put("banana", 1023123);

        Method1(map);
        Method3(map);
    }

    // 对Map来说，要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合：
    public static void Method1(Map<String, Integer> map) {
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + "---" + value);
        }
    }


    // 遍历key和value可以使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射：
    public static void Method2(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "====" + value);
        }
    }
}
