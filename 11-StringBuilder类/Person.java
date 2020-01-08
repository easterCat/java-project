public class Person {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        StringBuffer sBuf = new StringBuffer("今天要做什么呢?");
        sBuf.append("吃");
        sBuf.append("喝");
        sBuf.append("玩");
        sBuf.append("乐");
        System.out.println(sBuf);
    }
}