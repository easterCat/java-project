// 快速排序
// 挖坑填数+分治法
// 执行顺序
//
//        - 先从数列中取出一个数作为基准数
//        - 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
//        - 再对左右区间重复第二步，直到各区间只有一个数
public class main {
    public static void main(String[] args) {
        int[] arr = {20, 60, 51, 81, 285, 12, 165, 51, 81, 318, 186, 9, 70};

        System.out.println("\n" + "---------------快速排序---------------");

        quickSort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void quickSort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    s[i++] = s[j];
                }
                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }
}