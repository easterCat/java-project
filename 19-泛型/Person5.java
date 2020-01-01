import java.util.*;

public class GenericTest {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Double> number = new ArrayList<Double>();
        List<Integer> age = new ArrayList<Integer>();

        name.add("leo");
        number.add(11.33);
        age.add(23);

        //        getUpterNumber(name);
        getUpterNumber(number);
        getUpterNumber(age);
    }

    public static void getUpterNumber(List<? extends Number> data) {
        System.out.printf("data:" + data.get(0) + "\n");
    }
}