public class Main{
    public static void main(String[] args) {
        City bj = new City();
        bj.name = "beijing";
        bj.la = 39;
        bj.lo = 33;
        System.out.println(bj.name);
        System.out.println("location: " + bj.la + ", " + bj.lo);
    }
}

class City{
    public String name;
    public int la;
    public int lo;
}