public class TestArray {
    public static void main(String[] args) {
        int size = 10;

        double[] myList = new double[size];
        myList[0] = 5.6;
        myList[1] = 5.6;
        myList[2] = 5.6;
        myList[3] = 5.6;
        myList[4] = 5.6;
        myList[5] = 5.6;
        myList[6] = 5.6;
        myList[7] = 5.6;
        myList[8] = 5.6;

        double total = 0;

        for (int i = 0; i < size; i++) {
            total += myList[i];
        }
        System.out.println(total);
    }
}