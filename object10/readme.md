## 包

在Java中，我们使用package来解决名字冲突。

Java定义了一种名字空间，称之为包：package。一个类总是属于某个包，类名（比如Person）只是一个简写，真正的完整类名是包名.类名。

例如：

小明的Person类存放在包ming下面，因此，完整类名是ming.Person；

小红的Person类存放在包hong下面，因此，完整类名是hong.Person；

小军的Arrays类存放在包mr.jun下面，因此，完整类名是mr.jun.Arrays；

JDK的Arrays类存放在包java.util下面，因此，完整类名是java.util.Arrays。

小明的Person.java文件：

```
package ming; // 申明包名ming

public class Person {
}
```

小军的Arrays.java文件：

```
package mr.jun; // 申明包名mr.jun

public class Arrays {
}
```

在Java虚拟机执行的时候，JVM只看完整类名，因此，只要包名不同，类就不同。包可以是多层结构，用.隔开。例如：java.util。要特别注意：包没有父子关系。java.util和java.util.zip是不同的包，两者没有任何继承关系。没有定义包名的class，它使用的是默认包，非常容易引起名字冲突，因此，不推荐不写包名的做法。

组织:

![](https://raw.githubusercontent.com/easterCat/img-package/master/img/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-10%20%E4%B8%8B%E5%8D%887.49.23.png)

即所有Java文件对应的目录层次要和包的层次一致。

编译后的.class文件也需要按照包结构存放。如果使用IDE，把编译后的.class文件放到bin目录下，那么，编译的文件结构就是：

```
javac -d ../bin ming/Person.java hong/Person.java mr/jun/Arrays.java
```

![](https://raw.githubusercontent.com/easterCat/img-package/master/img/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-10%20%E4%B8%8B%E5%8D%887.51.52.png)

## 包作用域

位于同一个包的类，可以访问包作用域的字段和方法。不用public、protected、private修饰的字段和方法就是包作用域。

```
package hello;

public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        p.hello(); // 可以调用，因为Main和Person在同一个包
    }
}

public class Person {
    // 包作用域:
    void hello() {
        System.out.println("Hello!");
    }
}
```

## import

在一个class中，我们总会引用其他的class。例如，小明的ming.Person类，如果要引用小军的mr.jun.Arrays类，他有三种写法：

#### 第一种

```
// Person.java
package ming;

public class Person {
    public void run() {
        mr.jun.Arrays arrays = new mr.jun.Arrays();
    }
}
```

#### 第二种

```
// Person.java
package ming;

// 导入完整类名:
import mr.jun.Arrays;

// 导入mr.jun包的所有class:
// 表示把这个包下面的所有class都导入进来（但不包括子包的class）
// 不推荐这种写法，因为在导入了多个包后，很难看出Arrays类属于哪个包。
// import mr.jun.*;

public class Person {
    public void run() {
        Arrays arrays = new Arrays();
    }
}
```

#### 第三种

import static的语法，它可以导入可以导入一个类的静态字段和静态方法。import static很少使用。

```
package main;

// 导入System类的所有静态字段和静态方法:
import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        // 相当于调用System.out.println(…)
        out.println("Hello, world!");
    }
}
```

Java编译器最终编译出的.class文件只使用完整类名，因此，在代码中，当编译器遇到一个class名称时：

- 如果是完整类名，就直接根据完整类名查找这个class；
- 如果是简单类名，按下面的顺序依次查找：
    - 查找当前package是否存在这个class；
    - 查找import的包是否包含这个class；
    - 查找java.lang包是否包含这个class。
    
    
 ```
// Main.java
package test;

import java.text.Format;

public class Main {
    public static void main(String[] args) {
        java.util.List list; // ok，使用完整类名 -> java.util.List
        Format format = null; // ok，使用import的类 -> java.text.Format
        String s = "hi"; // ok，使用java.lang包的String -> java.lang.String
        System.out.println(s); // ok，使用java.lang包的System -> java.lang.System
        MessageFormat mf = null; // 编译错误：无法找到MessageFormat: MessageFormat cannot be resolved to a type
    }
}
```

因此，编写class的时候，编译器会自动帮我们做两个import动作：

- 默认自动import当前package的其他class；
- 默认自动import java.lang.*。

 注意：自动导入的是java.lang包，但类似java.lang.reflect这些包仍需要手动导入。
 
 如果有两个class名称相同，例如，mr.jun.Arrays和java.util.Arrays，那么只能import其中一个，另一个必须写完整类名。