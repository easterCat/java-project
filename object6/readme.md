## 覆写

在继承关系中，子类如果定义了一个与父类方法签名完全相同的方法，被称为覆写（Override）。

```
public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.run();
    }
}


class Person {
    public void run() {
        System.out.println("person");
    }
}

class Student extends Person {
    public void run() {
        System.out.println("student");
    }
}
```

Override和Overload不同的是，如果方法签名如果不同，就是Overload，Overload方法是一个新方法；如果方法签名相同，并且返回值也相同，就是Override。

>  注意：方法名相同，方法参数相同，但方法返回值不同，也是不同的方法。在Java程序中，出现这种情况，编译器会报错。

```
    // 不是Override，因为参数不同:
    public void run(String s) { … }
    // 不是Override，因为返回值不同:
    public int run() { … }
```

加上@Override可以让编译器帮助检查是否进行了正确的覆写。希望进行覆写，但是不小心写错了方法签名，编译器会报错。

```
    @Override
    public void run() {
        System.out.println("student");
    }
```

特殊的情况

```
  public static void main(String[] args) {
        Person p = new Student();
        p.run(); // 应该打印Person.run还是Student.run?
    }
```

那么，一个实际类型为Student，引用类型为Person的变量，调用其run()方法，调用的是Student的run()方法

结论：Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。这个非常重要的特性在面向对象编程中称之为多态。它的英文拼写非常复杂：Polymorphic。

## 多态

多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。运行期才能动态决定调用的子类方法。对某个类型调用某个方法，执行的实际方法可能是某个子类的覆写方法。

```
public class Main {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(12333)
        };
        System.out.println(totalTax(incomes));
    }

    public static double totalTax(Income... incomes) {
        double total = 0;

        for (Income income : incomes) {
            total = total + income.getTax();
        }

        return total;
    }
}

class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income < 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
```

观察totalTax()方法：利用多态，totalTax()方法只需要和Income打交道，它完全不需要知道Salary和StateCouncilSpecialAllowance的存在，就可以正确计算出总的税。如果我们要新增一种稿费收入，只需要从Income派生，然后正确覆写getTax()方法就可以。把新的类型传入totalTax()，不需要修改任何代码。

> 多态具有一个非常强大的功能，就是允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码。

## 覆写Object方法

因为所有的class最终都继承自Object，而Object定义了几个重要的方法,在必要的情况下，我们可以覆写Object的这几个方法。

- toString()：把instance输出为String；
- equals()：判断两个instance是否逻辑相等；
- hashCode()：计算一个instance的哈希值。

```
class Person {
    ...
    // 显示更有意义的字符串:
    @Override
    public String toString() {
        return "Person:name=" + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person类型:
        if (o instanceof Person) {
            Person p = (Person) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
```

## 调用super

在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用。

```
public class Main {
    public static void main(String[] args) {
        Person s = new Student();
        s.run();
        System.out.println(s.hello());
    }
}


class Person {
    public void run() {
        System.out.println("person");
    }

    public String hello(){
        return "hello,person";
    }
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("student");
    }

    @java.lang.Override
    public String hello() {
        System.out.println("hello,student");
        return super.hello() + "!";
    }
}
```

## final

继承可以允许子类覆写父类的方法。如果一个父类不允许子类对它的某个方法进行覆写，可以把该方法标记为final。用final修饰的方法不能被Override

```
class Person {
    protected String name;
    public final String hello() {
        return "Hello, " + name;
    }
}

Student extends Person {
    // compile error: 不允许覆写
    @Override
    public String hello() {
    }
}
```

如果一个类不希望任何其他类继承自它，那么可以把这个类本身标记为final。用final修饰的类不能被继承：

```
final class Person {
    protected String name;
}

// compile error: 不允许继承自Person
Student extends Person {
}
```

对于一个类的实例字段，同样可以用final修饰。用final修饰的字段在初始化后不能被修改。对final字段重新赋值会报错

```
Person p = new Person();
p.name = "New Name"; // compile error!

class Person {
    public final String name = "Unamed";
}
```

可以在构造方法中初始化final字段,这种方法更为常用，因为可以保证实例一旦创建，其final字段就不可修改。

```
class Person {
    public final String name;
    public Person(String name) {
        this.name = name;
    }
}
```