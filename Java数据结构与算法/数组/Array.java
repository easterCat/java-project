public class Array {
    private int[] intArray;
    private int index;
    public int length;

    public Array(int max) {
        this.length = max;
        this.intArray = new int[max];
        this.index = 0;
    }

    // 向最后添加一个元素
    public void push(int value) {
        intArray[index] = value;
        index++;
    }

    // 最后一个元素删除
    public boolean pop() {
        // 后面的数据往前移
        index--;
        return true;
    }

    // 第一个元素删除
    public boolean shift() {
        for (int i = 1; i < index; i++) {
            intArray[i - 1] = intArray[i];
        }
        index--;
        return true;
    }

    // 开头添加一个元素
    public void unshift(int value) {
        int[] newArray = new int[this.length + 1];
        for (int i = 0; i < index; i++) {
            newArray[i] = intArray[i];
        }
        for (int k = 0; k < index; k++) {
            intArray[k + 1] = newArray[k];
        }
        intArray[0] = value;
        index++;
    }

    // 查找下标所在内容
    public int find(int key) {
        int i;
        for (i = 0; i < index; i++) {
            if (intArray[i] == key) {
                break;
            }
        }
        if (i == index) {
            return -1;
        }
        return 1;
    }

    // 删除当前下标所在内容
    public boolean remove(int key) {
        int i = this.find(key);
        if (i == -1) {
            return false;
        }

        for (int k = 0; k < index; k++) {
            intArray[k] = intArray[k - 1];
        }
        index--;
        return true;
    }

    // 更新下标所在内容
    public boolean update(int key, int value) {
        intArray[key] = value;
        return true;
    }

    // 打印数组
    public void show() {
        for (int i = 0; i < index; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.print("\n");
    }

    // 数组中是否包含某个值
    public boolean include(int value) {
        boolean result = false;
        for (int i = 0; i < index; i++) {
            if (intArray[i] == value) {
                result = true;
            }
        }
        return result;
    }

    // 冒泡排序
    public void bubbleSort() {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                if (intArray[i] < intArray[j]) {
                    int tmp = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = tmp;
                }
            }
        }
        this.show();
    }

    // 选择排序
    public void selectSort() {
        for (int i = 0; i < index; i++) {
            for (int j = i; i < index; i++) {
                if (intArray[j] > intArray[j + 1]) {
                    int tmp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = tmp;
                }
            }
        }
        this.show();
    }
}