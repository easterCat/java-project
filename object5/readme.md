## 继承

Person类

```$xslt
class Person {
    private String name;
    private int age;

    public String getName() {...}
    public void setName(String name) {...}
    public int getAge() {...}
    public void setAge(int age) {...}
}
```

Student类

```$xslt
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

Student类包含了Person类已有的字段和方法，只是多出了一个score字段和相应的getScore()、setScore()
方法。这时候就需要继承来减少样板代码。继承是面向对象编程中非常强大的一种机制，它首先可以复用代码。当我们让Student从Person继承时，Student就获得了Person的所有功能，我们只需要为Student编写新增的功能。

通过继承，Student只需要编写额外的功能，不再需要重复代码。

Java使用extends关键字来实现继承：

```$xslt
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

在OOP的术语中，我们把Person称为超类（super class），父类（parent class），基类（base class），把Student称为子类（subclass），扩展类（extended class）。

## 继承树

注意到我们在定义Person的时候，没有写extends。在Java中，没有明确写extends的类，编译器会自动加上extends Object。所以，任何类，除了Object，都会继承自某个类。下图是Person、Student的继承树：

![](https://raw.githubusercontent.com/easterCat/img-package/master/img/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-07%20%E4%B8%8B%E5%8D%888.46.59.png)

Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。

## protected

继承有个特点，就是子类无法访问父类的private字段或者private方法。例如，Student类就无法访问Person类的name和age字段：

为了让子类可以访问父类的字段，我们需要把private改为protected。用protected修饰的字段可以被子类访问：

```$xslt
    protected String name = "default";
    protected int age = 101;
```

protected关键字可以把字段和方法的访问权限控制在继承树内部，一个protected字段和方法可以被其子类，以及子类的子类所访问。

## super

super关键字表示父类（超类）。子类引用父类的字段时，可以用super.fieldName。例如：

```$xslt
    public String info(){
        return super.name + "-" + age + "-" + this.score;
    }
```

> 这里使用super.name，或者this.name，或者name，效果都是一样的。编译器会自动定位到父类的name字段。


在Java中，任何class的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();，所以，Student类的构造方法实际上是这样：

```$xslt
    public Student(String name,int age,int score){
        super();
        this.score = score;
    }
```

但是，Person类并没有无参数的构造方法，因此，编译失败。解决方法是调用Person类存在的某个构造方法。例如：

```$xslt
    public Student(String name,int age,int score){
        super(name,age);
        this.score = score;
    }
```

如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。

## 向上转型

如果一个引用变量的类型是Student，那么它可以指向一个Student类型的实例：

如果一个引用类型的变量是Person，那么它可以指向一个Person类型的实例：

如果Student是从Person继承下来的，一个引用类型为Person的变量，能指向Student类型的实例

```$xslt
Student s = new Student();
Person p = new Person();
Person p = new Student(); // ???
```

因为Student继承自Person，因此，它拥有Person的全部功能。Person类型的变量，如果指向Student类型的实例，对它进行操作，是没有问题的！这种把一个子类类型安全地变为父类类型的赋值，被称为向上转型（upcasting）。

> 向上转型实际上是把一个子类型安全地变为更加抽象的父类型

```$xslt
Student s = new Student();
Person p = s; // upcasting, ok
Object o1 = p; // upcasting, ok
Object o2 = s; // upcasting, ok
```

注意到继承树是Student > Person > Object，所以，可以把Student类型转型为Person，或者更高层次的Object。