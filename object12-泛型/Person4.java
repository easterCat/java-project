import java.util.*;

public class GenericTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Double> number = new ArrayList<Double>();
        List<Integer> age = new ArrayList<Integer>();

        name.add("lacy");
        number.add(123.5);
        age.add(21);

        getData(name, "name");
        getData(number, "number");
        getData(age, "age");
    }

    public static void getData(List<?> data, String label) {
        System.out.println(label + " :" + data.get(0) + "\n");
    }
}