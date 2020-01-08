/**
 * 判断101-200之间有多少个素数，并输出所有素数。
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。 质数（prime
 * number）又称素数，有无限个。质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。(这个数与除1之外小于它的数取余不为0)
 */
public class Liu {
    public static void main(String[] args) {
        totalPrime(200, 1000);
    }

    public static void totalPrime(int m, int n) {
        int count = 0;
        for (int i = m; i < n; i++) {
            if (isPrime(i)) {
                count++;
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("在" + m + "和" + n + "之间共有" + count + "个素数");
    }

    public static boolean isPrime(int n) {
        boolean flag = true;
        if (n == 1)
            flag = false;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if ((n % i) == 0 || n == 1) {
                    flag = false;
                    break;
                } else
                    flag = true;
            }
        }
        return flag;
    }
}