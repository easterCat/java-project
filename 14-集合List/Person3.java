import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Method1();
        Method2();
        Method3();
        Method4();
    }

    // 第一种是调用toArray()方法直接返回一个Object[]数组：
    // 这种方法会丢失类型信息，所以实际应用很少
    public static void Method1() {
        List<String> list = List.of("asdasd", "aaaaaa", "bbbbbb"); // 创建list
        Object[] array = list.toArray();
        for (Object s : array) {
            System.out.println(s);
        }
    }

    // 第二种方式是给toArray(T[])传入一个类型相同的Array，List内部自动把元素复制到传入的Array中：
    public static void Method2() {
        List<Integer> list = List.of(12, 33, 55);
        Integer[] array = list.toArray(new Integer[3]);
        for (Integer n : array) {
            System.out.println(n);
        }
    }

    // 注意到这个toArray(T[])方法的泛型参数<T>并不是List接口定义的泛型参数<E>，所以，我们实际上可以传入其他类型的数组，例如我们传入Number类型的数组，返回的仍然是Number类型：
    public static void Method3() {
        List<Integer> list = List.of(12, 34, 56);
        Number[] array = list.toArray(new Number[3]);
        for (Number n : array) {
            System.out.println(n);
        }
    }

    // Array变为List就简单多了，通过List.of(T...)方法
    public static void Method4() {
        Integer[] array = {1, 2, 3};
        List<Integer> list = List.of(array);

        for (Number value : list) {
            System.out.println(value);
        }
    }
}