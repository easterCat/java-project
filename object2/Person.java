public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setName("Xiao Ming"); // name has private access in Person
        ming.setAge(33);
        ming.setBirthday(2019);
        System.out.println(ming.getName() + "-" + ming.getAge() + "岁" + "-" + ming.getBirthDay() + "年"); // Xiao Ming-33岁-1986年
        ming.setHighAndWeight(177,66);
        System.out.println(ming.getHW());
        ming.setFamily("Xiao Ming", "Xiao Hong", "Xiao Jun");

        String[] friends = new String[] {"liuliu","xixi"};
        ming.setFriend(friends);
        System.out.println(ming.getFriend());
        friends[0] = "changed";
        System.out.println(ming.getFriend());
    }
}

class Person{
    private String name;
    private int age;
    private int birthDay;
    private int high;
    private int weight;
    private String[] family;
    private String[] friend;

    public String getName(){
        return this.name; // 相当于this.name
    }

    public void setName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip();
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        if(age < 0) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }

    public void setBirthday(int currentYear){
        this.birthDay = calcBirthday(currentYear);
    }

    public int getBirthDay(){
        return this.birthDay;
    }

    private int calcBirthday(int currentYear){
        return currentYear - this.age;
    }

    public void setHighAndWeight(int high,int weight){
        this.high = high;
        this.weight = weight;
    }

    public String getHW(){
        return this.high + "-" + this.weight;
    }

    public void setFamily(String... family){
        this.family = family;
    }

    public void setFriend(String[] friend){
        this.friend = friend;
    }

    public String getFriend(){
        return this.friend[0] + "-" + this.friend[1];
    }
}