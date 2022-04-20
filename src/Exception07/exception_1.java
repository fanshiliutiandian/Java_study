package Exception07;
//异常
/*
异常：在Java语言中将程序执行中发生的不正常情况称为异常。
开发过程中的语法错误和逻辑错误不是异常。
Java程序在执行过程中所发生的异常事件可分为两类：
Error:Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError和OOM。
一般不编写针对性的代码进行处理。
Exception 其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理 。
例如：
    空指针访问
    试图读取不存在的文件
    网络连接中断
    数组角标越界
        编译时异常（checked）
            ...IOException
                ...FileNotFoundException
            ...ClassNotFoundException
        运行时异常（unchecked）
            ...NullPointException
            ...ArrayIndexOutOfBoundsException



 */

import java.util.Date;
import java.util.Scanner;

public class exception_1 {
    public static void main(String[] args) {
        //1 栈溢出：java.lang.StackOverflowError
//        main(args);

        //2 堆溢出：java.lang.OutOfMemoryError（OOM）
//        Integer[] arr=new Integer[1024*1024*1024];

        //NullPointException空指针异常
        {
//        int[] arr=null;
//        System.out.println(arr[3]);
            //引用数据类型
//        String str ="abc";
//        str=null;
//        System.out.println(str.charAt(0));
        }
        //ArrayIndexOutOfBoundsException数组角标越界
        {
//        int []arr=new int [10];
//        System.out.println(arr[10]);
            //StringIndexOutOfBoundsException
//        String str="abc";
//        System.out.println(str.charAt(3));
        }
        //ClassCastException类型转换异常
        {
//            Object obj = new Date();
//            String str = (String) obj;
        }
        //NumberFormatException数值转换异常
        {
//            String str = "abc";
//            int num = Integer.parseInt(str);
        }
        //InputMismatchException输入不匹配
        {
//            Scanner scanner = new Scanner(System.in);//例如输入abc
//            int score = scanner.nextInt();
//            System.out.println(score);
        }
        //ArithmeticException算术异常
        {
//            int a = 10;
//            int b = 0;
//            System.out.println(a / b);
        }
    }
}
