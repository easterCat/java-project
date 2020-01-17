## 面向对象基础

面向对象编程，是一种通过对象的方式，把现实世界映射到计算机模型的一种编程方法。

现实世界中，我们定义了“人”这种抽象概念，而具体的人则是“小明”、“小红”、“小军”等一个个具体的人。所以，“人”可以定义为一个类（class），而具体的人则是实例（instance）：

基本概念：

- 多态
- 继承
- 封装
- 抽象
- 类
- 对象
- 实例
- 方法
- 重载

## class 和 instance

class 是一种对象模版，它定义了如何创建实例，因此，class 本身就是一种数据类型：

而 instance 是对象实例，instance 是根据 class 创建的实例，可以创建多个 instance，每个 instance 类型相同，但各自属性可能不相同：

## 定义 class/创建实例

在 Java 中，创建一个类，class 类名 {}

一个 class 可以包含多个字段（field），字段用来描述一个类的特征。通过 class，把一组数据汇集到一个对象上，实现了数据封装。

定义了 class，只是定义了对象模版，而要根据对象模版创建出真正的对象实例，必须用 new 操作符。

new 操作符可以创建一个实例，然后，我们需要定义一个引用类型的变量来指向这个实例：

```java
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
```

注意区分 City bj 是定义 City 类型的变量 bj，而 new City()是创建 City 实例。

## 源文件声明规则

当在一个源文件中定义多个类，并且还有 import 语句和 package 语句时，要特别注意这些规则。

- 一个源文件中只能有一个 public 类
- 一个源文件可以有多个非 public 类
- 源文件的名称应该和 public 类的类名保持一致。例如：源文件中 public 类的类名是 Employee，那么源文件应该命名为 Employee.java。
- 如果一个类定义在某个包中，那么 package 语句应该在源文件的首行。
- 如果源文件包含 import 语句，那么应该放在 package 语句和类定义之间。如果没有 package 语句，那么 import 语句应该在源文件中最前面。
- import 语句和 package 语句对源文件中定义的所有类都有效。在同一源文件中，不能给不同的类不同的包声明。
- 类有若干种访问级别，并且类也分不同的类型：抽象类和 final 类等。这些将在访问控制章节介绍。
