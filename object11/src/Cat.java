package animals;

public class Cat implements Animal {

    public void eat() {
        System.out.println("Cat eats");
    }

    public void travel() {
        System.out.println("Cat travels");
    }

    public int noOfLegs() {
        return 0;
    }

    public static void main(String args[]) {
        Cat m = new Cat();
        m.eat();
        m.travel();
    }
}