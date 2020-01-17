## public / private

直接把 field 用 public 暴露给外部可能会破坏封装性。为了避免外部代码直接去访问 field，我们可以用 private 修饰 field，拒绝外部访问：

```java
public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.name = "Xiao Ming"; // 对字段name赋值
        ming.age = 12; // 对字段age赋值
        System.out.println(ming.name);
    }
}

class Person{
    public String name;
    public int age;
}
```

使用 private

```java
public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
         // name has private access in Person
        ming.name = "Xiao Ming";
        ming.age = 12;
        System.out.println(ming.name);
    }
}

class Person{
    private String name;
    private int age;
}
```

把 field 从 public 改成 private，外部代码不能访问这些 field，那我们我们需要使用方法（method）来让外部代码可以间接修改 field

## 方法

```java
public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        // name has private access in Person
        ming.setName("Xiao Ming");
        ming.setAge(33);
        System.out.println(ming.getName() + "-" + ming.getAge() + "岁");
    }
}

class Person{
    private String name;
    private int age;

    public String getName(){
        return this.name;
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
}
```

虽然外部代码不能直接修改 private 字段，但是，外部代码可以调用方法 setName()和 setAge()来间接修改 private 字段。在方法内部，我们就有机会检查参数对不对。

同样，外部代码不能直接读取 private 字段，但可以通过 getName()和 getAge()间接获取 private 字段的值。

所以，一个类通过定义方法，就可以给外部代码暴露一些操作的接口，同时，内部自己保证逻辑一致性。

调用方法的语法是实例变量.方法名(参数);。一个方法调用就是一个语句，所以不要忘了在末尾加;。

#### 定义方法

```java
修饰符 方法返回类型 方法名(方法参数列表) {
    若干方法语句;
    return 方法返回值;
}
```

方法返回值通过 return 语句实现，如果没有返回值，返回类型设置为 void，可以省略 return。

#### private 方法

有 public 方法，自然就有 private 方法。和 private 字段一样，private 方法不允许外部调用，内部方法是可以调用 private 方法的。

```java
public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        // name has private access in Person
        ming.setName("Xiao Ming");
        ming.setAge(33);
        ming.setBirthday(2019);
        // Xiao Ming-33岁-1986年
        System.out.println(ming.getName() + "-" + ming.getAge() + "岁" + "-" + ming.getBirthDay() + "年");
    }
}

class Person{
    private String name;
    private int age;
    private int birthDay;

    public String getName(){
        return this.name;
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
}
```

calcBirthday()是一个 private 方法，外部代码无法调用，但是，内部方法 setBirthday()可以调用它。

#### this 变量

在方法内部，可以使用一个隐含的变量 this，它始终指向当前实例。因此，通过 this.field 就可以访问当前实例的字段。

如果没有命名冲突，可以省略 this。例如：

```java
    private String name;

    public String getName(){
        return this.name; // 相当于this.name
    }
```

但是，如果有局部变量和字段重名，那么局部变量优先级更高，就必须加上 this：

```java
    public void setName(String name){
        this.name = name.strip();
    }
```

#### 方法参数

方法可以包含 0 个或任意个参数。方法参数用于接收传递给方法的变量值。调用方法时，必须严格按照参数的定义一一传递

```java
    private int high;
    private int weight;

    public void setHighAndWeight(int high,int weight){
        this.high = high;
        this.weight = weight;
    }

    public String getHW(){
        return this.high + "-" + this.weight;
    }
```

调用这个 setHighAndWeight()方法时，必须有两个参数

```java
   ming.setHighAndWeight(177,66);
   System.out.println(ming.getHW());
```

#### 可变参数

可变参数用类型...定义，可变参数相当于数组类型：

```java
    private String[] family;

    public void setFamily(String... family){
        this.family = family;
    }
```

调用

```java
    ming.setFamily("Xiao Ming", "Xiao Hong", "Xiao Jun");
    ming.setFamily("Xiao Ming", "Xiao Hong");
    ming.setFamily();
```

> 可以把可变参数改写为 String[]类型。但是，调用方需要自己先构造 String[]，比较麻烦。调用方可以传入 null。而可变参数可以保证无法传入 null，因为传入 0 个参数时，接收到的实际值是一个空数组而不是 null。

#### 参数绑定

调用方把参数传递给实例方法时，调用时传递的值会按参数位置一一绑定。

基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。

引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方。

```java
    private String[] friend;

    public void setFriend(String[] friend){
        this.friend = friend;
    }

    public String getFriend(){
        return this.friend[0] + "-" + this.friend[1];
    }
```

调用

```java
    String[] friends = new String[] {"liuliu","xixi"};
    ming.setFriend(friends);
    System.out.println(ming.getFriend());
    friends[0] = "changed";
    System.out.println(ming.getFriend());
```
