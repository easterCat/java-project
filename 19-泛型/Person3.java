public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return this.t;
    }

    public static void main(String[] args) {
        Box<Double> box1 = new Box<Double>();
        Box<String> box2 = new Box<String>();

        box1.add(new Double(2.23333));
        box2.add(new String("hello world"));

        System.out.printf("%.2f\n", box1.get());
        System.out.printf("%s", box2.get());
    }
}