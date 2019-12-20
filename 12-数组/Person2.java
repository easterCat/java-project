public class TestArray {
    public static void main(String[] args) {

        double[] myList = {1, 2, 3, 4, 5, 6, 3, 3, 23};
        int length = myList.length;

        for (int i = 0; i < length; i++) {
            System.out.println(myList[i]);
        }

        double total = 0;

        for (int i = 0; i < length; i++) {
            total += myList[i];
        }

        double max = myList[0];

        for (int i = 1; i < length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
        }
        System.out.println(total);
        System.out.println(max);
    }
}