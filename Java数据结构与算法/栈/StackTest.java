public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push("abc");
        stack.push(123);
        stack.push("de");
        stack.push("cd");
        stack.push("er");
        stack.push("hello");
        stack.push(666);
        stack.push(545);
        stack.push("word");
        stack.push("me");
        stack.show();
        System.out.println(stack.size());
        // stack.clear();
        // stack.show();
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
        System.out.println(stack.peek());
        // abc 123 de cd er hello 666 545 word me
        // 10
        // false
        // abc 123 de cd er hello null null null null
        // hello
    }
}