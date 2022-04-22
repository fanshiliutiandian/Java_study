package thread08;

//新增方式一：实现Callable接口----jdk5.0新增
/*
与使用 Runnable 相比，Callable功能更强大些
    相比 run()方法，可以有返回值
    方法可以抛出异常
    支持泛型的返回值
    需要借助 FutureTask类，比如获取返回结果


实现步骤
1 创建实现Callable的是实现类
2 实现call方法，将此线程需要执行的操作放在call方法中
3 创建Callable接口实现类的对象
4 将实现作为参数传递到FutureTask构造器中，创建FutureTask类的对象
5 将FutureTask类的对象传入Thread类的构造器中，创建Thread类的对象，并调用start（）
6 获取Callable中call的返回值（不感兴趣可没有）



如何理解Callable功能更强大
call方法可以有返回值
call可以抛出异常，被外面的操作捕获
callable支持泛型（后续学习）

 */


import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class callable {
    public static void main(String[] args) {
        //3 创建Callable接口实现类的对象
        NumThread n=new NumThread();
        //4 将实现作为参数传递到FutureTask构造器中，创建FutureTask类的对象
        FutureTask ft= new FutureTask(n);

        //5 将FutureTask类的对象传入Thread类的构造器中，创建Thread类的对象，并调用start（）
        new Thread(ft).start();



        try {
            //get方法的返回值即为FutureTask构造器参数Callable实现类重写的call（）的返回值

            //6 获取Callable中call的返回值（不感兴趣可没有）
            Object sum=ft.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}

class NumThread implements Callable {//1

    //2实现call方法，将此线程需要执行的操作放在call方法中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}
