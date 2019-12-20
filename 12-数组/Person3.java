public class TestArray {
    public static void main(String[] args) {

        double[] myList = {1, 2, 3, 4, 5, 6, 3, 3, 23};
        int length = myList.length;

        for (double element : myList) {
            System.out.println(element);
        }
    }
}