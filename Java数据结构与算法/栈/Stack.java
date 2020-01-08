import java.util.Arrays;

public class Stack {
    private Object[] array;
    private int size;
    public int top;

    public Stack(int size) {
        if (size > 0) {
            this.array = new Object[size];
            this.size = size;
            top = -1;
        } else {
            throw new RuntimeException("size=" + size);
        }
    }

    public void push(Object value) {
        grow();
        array[++top] = value;
    }

    // 删除栈顶元素
    public Object pop() {
        Object result = peek();
        array[top--] = null;
        return result;
    }

    // 查看栈顶元素
    public Object peek() {
        if (top != -1) {
            return array[top];
        } else {
            throw new RuntimeException("stack is null");
        }
    }

    public void grow() {
        if (top == size - 1) {
            size = size << 1;
            array = Arrays.copyOf(array, size);
        }
    }

    public boolean isEmpty() {
        if (top != -1) {
            return false;
        } else {
            return true;
        }
    }

    public void clear() {
        this.array = new Object[0];
        this.size = 0;
        top = -1;
    }

    public int size() {
        return this.size;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
    }
}
