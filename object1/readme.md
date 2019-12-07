## 面向对象基础

面向对象编程，是一种通过对象的方式，把现实世界映射到计算机模型的一种编程方法。

现实世界中，我们定义了“人”这种抽象概念，而具体的人则是“小明”、“小红”、“小军”等一个个具体的人。所以，“人”可以定义为一个类（class），而具体的人则是实例（instance）：

## class和instance

class是一种对象模版，它定义了如何创建实例，因此，class本身就是一种数据类型：

而instance是对象实例，instance是根据class创建的实例，可以创建多个instance，每个instance类型相同，但各自属性可能不相同：

## 定义class/创建实例

在Java中，创建一个类，class 类名 {}

一个class可以包含多个字段（field），字段用来描述一个类的特征。通过class，把一组数据汇集到一个对象上，实现了数据封装。

定义了class，只是定义了对象模版，而要根据对象模版创建出真正的对象实例，必须用new操作符。

new操作符可以创建一个实例，然后，我们需要定义一个引用类型的变量来指向这个实例：

```$xslt
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

注意区分City bj是定义City类型的变量bj，而new City()是创建City实例。