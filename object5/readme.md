## 继承

Person 类

```java
class Person {
    private String name;
    private int age;

    public String getName() {...}
    public void setName(String name) {...}
    public int getAge() {...}
    public void setAge(int age) {...}
}
```

Student 类

```java
class Student {
    private String name;
    private int age;
    private int score;

    public String getName() {...}
    public void setName(String name) {...}
    public int getAge() {...}
    public void setAge(int age) {...}
    public int getScore() { … }
    public void setScore(int score) { … }
}
```

Student 类包含了 Person 类已有的字段和方法，只是多出了一个 score 字段和相应的 getScore()、setScore()
方法。这时候就需要继承来减少样板代码。继承是面向对象编程中非常强大的一种机制，它首先可以复用代码。当我们让 Student 从 Person 继承时，Student 就获得了 Person 的所有功能，我们只需要为 Student 编写新增的功能。

通过继承，Student 只需要编写额外的功能，不再需要重复代码。

Java 使用 extends 关键字来实现继承：

```java
public class Main {
    public static void main(String[] args) {
        Student ahua = new Student();
        ahua.setScore(22);
        System.out.println(ahua.getScore());
    }
}

class Person {
    private String name = "default";
    private int age = 101;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Student extends Person {
    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
}
```

在 OOP 的术语中，我们把 Person 称为超类（super class），父类（parent class），基类（base class），把 Student 称为子类（subclass），扩展类（extended class）。

## 继承树

注意到我们在定义 Person 的时候，没有写 extends。在 Java 中，没有明确写 extends 的类，编译器会自动加上 extends Object。所以，任何类，除了 Object，都会继承自某个类。下图是 Person、Student 的继承树：

![](https://raw.githubusercontent.com/easterCat/img-package/master/img/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-07%20%E4%B8%8B%E5%8D%888.46.59.png)

Java 只允许一个 class 继承自一个类，因此，一个类有且仅有一个父类。只有 Object 特殊，它没有父类。

## protected

继承有个特点，就是子类无法访问父类的 private 字段或者 private 方法。例如，Student 类就无法访问 Person 类的 name 和 age 字段：

为了让子类可以访问父类的字段，我们需要把 private 改为 protected。用 protected 修饰的字段可以被子类访问：

```java
    protected String name = "default";
    protected int age = 101;
```

protected 关键字可以把字段和方法的访问权限控制在继承树内部，一个 protected 字段和方法可以被其子类，以及子类的子类所访问。

## super

super 关键字表示父类（超类）。子类引用父类的字段时，可以用 super.fieldName。例如：

```java
    public String info(){
        return super.name + "-" + age + "-" + this.score;
    }
```

> 这里使用 super.name，或者 this.name，或者 name，效果都是一样的。编译器会自动定位到父类的 name 字段。

在 Java 中，任何 class 的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句 super();，所以，Student 类的构造方法实际上是这样：

```java
    public Student(String name,int age,int score){
        super();
        this.score = score;
    }
```

但是，Person 类并没有无参数的构造方法，因此，编译失败。解决方法是调用 Person 类存在的某个构造方法。例如：

```java
    public Student(String name,int age,int score){
        super(name,age);
        this.score = score;
    }
```

如果父类没有默认的构造方法，子类就必须显式调用 super()并给出参数以便让编译器定位到父类的一个合适的构造方法。子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。

## 向上转型

如果一个引用变量的类型是 Student，那么它可以指向一个 Student 类型的实例：

如果一个引用类型的变量是 Person，那么它可以指向一个 Person 类型的实例：

如果 Student 是从 Person 继承下来的，一个引用类型为 Person 的变量，能指向 Student 类型的实例

```java
Student s = new Student();
Person p = new Person();
Person p = new Student(); // ???
```

因为 Student 继承自 Person，因此，它拥有 Person 的全部功能。Person 类型的变量，如果指向 Student 类型的实例，对它进行操作，是没有问题的！这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。

> 向上转型实际上是把一个子类型安全地变为更加抽象的父类型

```java
Student s = new Student();
Person p = s; // upcasting, ok
Object o1 = p; // upcasting, ok
Object o2 = s; // upcasting, ok
```

注意到继承树是 Student > Person > Object，所以，可以把 Student 类型转型为 Person，或者更高层次的 Object。

## 向下转型

和向上转型相反，如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）。

```java
Person p1 = new Student(); // upcasting, ok
Person p2 = new Person();
Student s1 = (Student) p1; // ok
Student s2 = (Student) p2; // runtime error! ClassCastException!
```

在向下转型的时候，把 p1 转型为 Student 会成功，把 p2 转型为 Student 会失败，因为 p2 的实际类型是 Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。

为了避免向下转型出错，Java 提供了 instanceof 操作符，可以先判断一个实例究竟是不是某种类型

```java
Person p = new Person();
System.out.println(p instanceof Person); // true
System.out.println(p instanceof Student); // false

Student s = new Student();
System.out.println(s instanceof Person); // true
System.out.println(s instanceof Student); // true

Student n = null;
System.out.println(n instanceof Student); // false
```

instanceof 实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。如果一个引用变量为 null，那么对任何 instanceof 的判断都为 false。

利用 instanceof，在向下转型前可以先判断

```java
Person p = new Student();
if (p instanceof Student) {
    // 只有判断成功才会向下转型:
    Student s = (Student) p; // 一定会成功
}
```

## 区分继承和组合

添加一个 Book 的类,具有 name 字段.

```java
class Book {
    protected String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// error
class Student extends Book {
    protected int score;
}
```

从逻辑上讲，这是不合理的，Student 不应该从 Book 继承，而应该从 Person 继承。

究其原因，是因为 Student 是 Person 的一种，它们是 is 关系，而 Student 并不是 Book。实际上 Student 和 Book 的关系是 has 关系。

具有 has 关系不应该使用继承，而是使用组合，即 Student 可以持有一个 Book 实例：

```java
class Student extends Person {
    protected Book book;
    protected int score;
}
```

因此，继承是 is 关系，组合是 has 关系。
