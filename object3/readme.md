## 构造方法

创建实例的时候，我们经常需要同时初始化这个实例的字段

```java
Person ming = new Person();
ming.setName("小明");
ming.setAge(12);
```

使用的两个 method 进行的初始化,如果 field 多了呢.这时，我们就需要构造方法。能否在创建对象实例时就把内部字段全部初始化为合适的值

```java
public class Main {
    public static void main(String[] args) {
        Person ming = new Person("xiaoming", 22);
        System.out.println(ming.getName() + "_" + ming.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
```

- 构造方法的名称就是类名
- 构造方法的参数没有限制，在方法内部，也可以编写任意语句
- 构造方法没有返回值（也没有 void）
- new 操作符调用构造方法，

## 默认构造方法

如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句

```java
class Person {
    public Person() {
    }
}
```

> 如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法

如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来：

```java
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
```

> 没有在构造方法中初始化字段时，引用类型的字段默认是 null，数值类型的字段用默认值，int 类型默认值是 0，布尔类型默认值是 false：

也可以对字段直接进行初始化：

```java
class Person {
    private String name = "Unamed";
    private int age = 10;
}
```

#### 既对字段进行初始化，又在构造方法中对字段进行初始化：

```java
class Person {
    private String name = "Unamed";
    private int age = 10;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

在 Java 中，创建对象实例的时候，按照如下顺序进行初始化：

1. 先初始化字段，例如，int age = 10;表示字段初始化为 10，double salary;表示字段默认初始化为 0，String name;表示引用类型字段默认初始化为 null；
2. 执行构造方法的代码进行初始化。

## 多构造方法

可以定义多个构造方法，在通过 new 操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分

```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
        this.age = 12;
    }

    public Person() {
    }
}
```

一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是 this(…)：

```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 18); // 调用另一个构造方法Person(String, int)
    }

    public Person() {
        this("Unnamed"); // 调用另一个构造方法Person(String)
    }
}
```
