public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6};
        Double[] douArr = {1.1, 2.2, 3.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        printArray(intArr);
        printArray(douArr);
        printArray(charArray);
    }

    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}
