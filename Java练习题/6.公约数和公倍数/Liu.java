import java.util.Scanner;

/**
 * 输入两个正整数m和n，求其最大公约数和最小公倍数。
 */
public class Liu {
    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int a = input.nextInt();
        System.out.println("请输入第二个数:");
        int b = input.nextInt();

        System.out.println(a + "和" + b + "的最大公约数为" + gcd(a, b));
        System.out.println(a + "和" + b + "的最小公倍数为" + lcm(a, b));
    }

    // 欧几里德算法 => 辗转相除
    // 两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数。最大公约数缩写为gcd。
    public static int gcd(int a, int b) {
        int center;
        while (b != 0) {
            center = a / b;
            a = b;
            b = center;
        }
        return a;
    }

    // 最小公倍数=两数的乘积/最大公约数，所以可在最大公约数的基础上求最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
