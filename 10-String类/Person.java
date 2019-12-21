public class Main {
    public static void main(String[] args) {
        method1();
        method2();
        method3();
        method4();
    }

    public static void method1() {
        char[] hello = {'h', 'e', 'l', 'l', 'o'};
        String helloString = new String(hello);
        System.out.println(helloString);
    }

    public static void method2() {
        String site = "www.baidu.com";
        int len = site.length();
        System.out.println(len);
    }

    public static void method3() {
        String str1 = "今天吃";
        System.out.println(str1.concat("苹果"));
    }

    // +进行字符串连接
    public static void method4() {
        String str1 = "今天是个";
        System.out.println(str1 + "好日子");
    }

    public static void method5() {

    }
}