## 覆写方法

由于多态的存在，每个子类都可以覆写父类的方法,从Person类派生的Student和Teacher都可以覆写run()方法。

父类Person的run()方法没有实际意义，不能去掉方法的执行语句，去掉会导致编译错误，因为定义方法的时候，必须实现方法的语句。也不能去掉父类的run()方法,去掉父类的run()方法，就失去了多态的特性。

```
class Person {
    public void run() {

    }
}

class Student extends Person {
    @Override
    public void run() {
    }
}

class Teacher extends Person {
    @java.lang.Override
    public void run() {
    }
}
```

如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法：

```
abstract class Person {
    public abstract void run();
}
```

把一个方法声明为abstract，表示它是一个抽象方法，本身没有实现任何方法语句。因为这个抽象方法本身是无法执行的，所以，Person类也无法被实例化。必须把Person类本身也声明为abstract，才能正确编译它

## 抽象类

- 如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰
- 因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）
- 使用abstract修饰的类就是抽象类
- 我们无法实例化一个抽象类

抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”

```
abstract class Person {
    public abstract void run() { }
}

class Student extends Person {
    @Override
    public void run() { }
}

class Teacher extends Person {
    @Override
    public void run() { }
}
```

## 面向抽象编程

当我们定义了抽象类Person，以及具体的Student、Teacher子类的时候，我们可以通过抽象类Person类型去引用具体的子类的实例.这种引用抽象类的好处在于，我们对其进行方法调用，并不关心Person类型变量的具体子类型
.同样的代码，如果引用的是一个新的子类，我们仍然不关心具体类型.

```
public class Main {
    public static void main(String[] args) {
        Person s = new Student();
        Person t = new Teacher();
        Person p = new Police();
        // 不关心Person变量的具体子类型:
        s.run();
        t.run();
        p.run();
    }
}

abstract class Person {
    public abstract void run();
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("S is runing");
    }
}

class Teacher extends Person {
    @Override
    public void run() {
        System.out.println("T is runing");
    }
}

class Police extends Person {
    @Override
    public void run() {
        System.out.println("P is runing");
    }
}
```

这种尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。

面向抽象编程的本质就是：

- 上层代码只定义规范（例如：abstract class Person）；

- 不需要子类就可以实现业务逻辑（正常编译）；

- 具体的业务逻辑由不同的子类实现，调用者并不关心。