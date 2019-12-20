// 选择排序
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20, 60, 51, 81, 285, 12, 165, 51, 81, 318, 186, 9, 70};
        for (int a : arr) {
            System.out.print(a + " ");
        }

        System.out.println("\n" + "---------------从小到大---------------");

        arr = toSmall(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }

        System.out.println("\n" + "---------------从大到小---------------");

        arr = toBig(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static int[] toSmall(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int k = i + 1; k < length; k++) {
                if (arr[k] < arr[i]) {
                    int number = arr[i];
                    arr[i] = arr[k];
                    arr[k] = number;
                }
            }
        }
        return arr;
    }

    public static int[] toBig(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int k = i + 1; k < length; k++) {
                if (arr[k] > arr[i]) {
                    int number = arr[i];
                    arr[i] = arr[k];
                    arr[k] = number;
                }
            }
        }
        return arr;
    }
}