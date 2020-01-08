public class ArrayTest {
    public static void main(String[] args) {
        Array arr = new Array(20);
        arr.push(32);
        arr.push(122);
        arr.push(25);
        arr.push(53);
        arr.push(3);
        arr.push(61);
        arr.push(152);
        arr.push(31);
        arr.push(68);
        arr.push(88);
        arr.push(1000); // 尾部推入1000
        arr.unshift(0); // 头部推入0
        arr.pop(); // 尾部删除
        arr.shift(); // 头部删除
        arr.show();
        System.out.println(arr.find(152) == 1 ? "存在" : "不存在");
        System.out.println(arr.length);
        arr.update(6, 888);
        arr.show();
        System.out.println(arr.include(88) ? "存在" : "不存在");
        System.out.println("冒泡排序");
        arr.bubbleSort();
        System.out.println("选择排序");
        arr.selectSort();
    }
}