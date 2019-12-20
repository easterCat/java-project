public class TestArray {
    public static void main(String[] args) {

        double[] myList = {1, 2, 3, 4, 5, 6, 3, 3, 23};
        int length = myList.length;
        double[] reList = this.reverse(myList);
        for (double item : reList) {
            System.out.println(item);
        }
    }

    public static int[] reverse(double[] list) {
        int length = list.length;
        double[] result = new double[length];


        for (int i = 0, j = result.length - 1; i < length; i++, j--) {
            result[j] = list[i];
        }

        return result;
    }
}