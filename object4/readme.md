## 方法重载

在一个类中，我们可以定义多个方法。如果有一系列方法，它们的功能都是类似的，只有参数有所不同，那么，可以把这一组方法名做成同名方法。

这种方法名相同，但各自的参数不同，称为方法重载（Overload）。

方法重载的目的是，功能类似的方法使用同一名字，更容易记住，因此，调用起来更简单。

> 方法重载的返回值类型通常都是相同的。

```java
public class Main {
    public static void main(String[] args) {
        Person say = new Person();
        say.hello();
        say.hello("liuliu");
        say.hello("xiaohua", 12);
        say.hello("dahua", 44);
    }
}

class Person {
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}
```
