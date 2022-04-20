package Exception07;

/*
异常的处理：抓抛模型
    抛：Java程序的执行过程中如出现异常,会生成一个异常类对象,并将对象抛出。
    抓：1 try-catch-finally
        2 throws
try-catch-finally的使用
    try{
    //可能出现异常的代码
    }catch(异常类型1 变量名1){
    //处理异常的方式1
    }catch(异常类型2 变量名2){
    //处理异常的方式2
    }
    ...
    finally{
    //一定会执行的代码
    }




说明:
1 finally是可选的
2 try中出现异常，会生成对应异常类的对象，在catch中匹配
3 异常对象匹配到catch后，进入catch处理异常，然后跳出try-catch结构（后面的catch不执行）（没有finally的情况），继续执行后续代码
4 如果异常类型没有子父类关系，则顺序无所谓；如果满足，子类在上
5 处理异常的方法：
    getMessage()方法:获取异常信息，返回字符串
    printStackTrace()方法：获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。
6 try中声明的变量，除了try结构，不能再使用（可以在外面定义，里面使用）


使用try-catch-finally处理编译时异常，不在报错后，运行时仍可能异常

finally
1 不论在try代码块中是否发生了异常事件，catch语句是否执行，catch语句是否有异常，catch语句中是否有return，
  finally块中的语句都会被执行。
2 像数据库连接，输入输出流，网络编程中的Socket资源，JVM不会自动回收，手动释放资源，资源释放声明在finally{}中

3 如果抛出的异常是 IOException 等类型的非运行时异常，则必须捕获，否则编译错误。
  也就是说，我们必须处理编译时异常，将异常进行捕捉，转化为运行时异常。
  运行时异常比较常见，一般不针对运行时异常进行try-catch-finally处理。


快捷键：ctrl+alt+T
*/

public class try_catch_finally {
    public static void main(String[] args) {


        String str = "abc";
        try {

            int num = Integer.parseInt(str);//不能在{}外使用
            System.out.println("---1");//异常
        }catch (NumberFormatException e){

            System.out.println("出现数值转换异常");
            System.out.println(e.getMessage());//getMessage()方法:获取异常信息，返回字符串
            e.printStackTrace();//printStackTrace()方法：获取异常类名和异常信息，以及异常出现在程序中的位置。返回值 void。
        }catch (NullPointerException e){
            System.out.println("出现空指针异常");
        }
        System.out.println("---2");

        try {
            int a=10;
            int b=0;
            System.out.println(a/b);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }finally {
            System.out.println("一定执行的语句");
        }

    }

}
