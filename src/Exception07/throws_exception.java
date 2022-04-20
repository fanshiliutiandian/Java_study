package Exception07;
//异常处理方法2 throws+异常类型
/*
throws语句写在声明方法处，声明抛出异常的列表，throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类。
异常代码后的代码，不会被执行

throws方法抛出异常，该方法将不对这些异常进行处理，而由该方法的调用者负责处理++。
try-catch-finally真正处理了异常。

子类重写方法不能抛出比父类被重写方法范围更大的异常类型。在多态的情况下对methodA方法的调用-异常的捕获按父类声明的异常处理 。

开发中如何选择
    如果父类中被重写的方式没有throws方式处理异常，则子类不能用throws，子类中的异常必须使用try-catch-finally方式
    执行的方法先后调用了几个方法，这几个有递进关系，一般使用throws集中处理异常
 */

import java.io.IOException;

public class throws_exception {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }


    public static void method2()throws ArithmeticException{
        method1();
    }


    public static void method1()throws NullPointerException ,NumberFormatException,ArithmeticException{
        int a=10;
        int b=0;
        System.out.println(a/b);

    }
}
