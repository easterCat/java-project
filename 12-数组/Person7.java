import java.util.Arrays;

public class Person7 {
    public static void main(String[] args) {
        int[] ns = {1, 3, 4, 5, 6, 11, 52};
        int length = ns.length;
        System.out.println(Arrays.toString(ns));
        for (int i = length - 1; i >= 0; i--) {
            System.out.println(ns[i]);
        }
    }
}