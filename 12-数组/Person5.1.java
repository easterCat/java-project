// 选择排序
// 执行顺序
//
//        - 给定的一组总记录，进过一轮比较后得到最小的记录
//        - 将该记录的位置与总记录首位进行对调
//        - 接着对不包括最小的记录之外的记录进行新一轮的比较,获取第二小的记录
//        - 然后将第二小的记录与总记录的第二位进行对调
//        - 重复进行比较=>对调过程
//        - ......
//        - 可以进行比较的数据只剩下最后一个,停止排序
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
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    int center = arr[j];
                    arr[j] = arr[i];
                    arr[i] = center;
                }
            }
        }
        return arr;
    }

    public static int[] toBig(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] < arr[j]) {
                    int center = arr[j];
                    arr[j] = arr[i];
                    arr[i] = center;
                }
            }
        }
        return arr;
    }
}