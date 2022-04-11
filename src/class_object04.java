public class class_object04 {

/*面向对象（4-6章）
1.java类与类的成员；   属性，方法，构造器   ；代码块，内部类
2.面向对象三大特征     封装，继承，多态
3.其他关键字   this,super,static,final,abstract,interface,package,import等

 */


    public static void main(String args[]) {
/*类与对象
类是一类事物的抽象；
对象是该类事物的每个个体；（设计类就是设计类的成员）
 */

/*
类的成员
属性：类中的成员变量          =filed(域，字段)
行为：类中的成员方法（函数）   =method
 */

/*

 */

        //创建Person类的对象
        Person p1=new Person();
        //Scanner scanner =new Scanner (System.in);

        //调用对象：属性，方法
        //调用属性："对象.属性"
        p1.name="tom";
        p1.ismale=true;
        System.out.println(p1.name);
        //调用方法："对象.方法"
        p1.eat();
        p1.sleep();
        p1.talk("你好！");

        Person p2=new Person();
        System.out.println(p2.name);//null
        System.out.println(p2.ismale);//false

        //将p1保存的地址赋值给p3，p1和p3指向堆空间中的同一个对象实体
        Person p3=p1;
        System.out.println(p3.name);//tom
        p3.age=10;
        System.out.println(p1.age);//10



        //内存解析
        //堆（heap），存放对象实例
        //栈(stack)（虚拟机栈），存储局部变量
        //方法区(method area)，存储存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。



        Phone p=new Phone();
        System.out.println(p);
        p.sendEmail();
        p.playGame();
        //匿名对象
        /*
        1 没有显示地赋变量名
        2 只能用一次
        3 匿名对象的使用（类中调用类）

         */
        new Phone().sendEmail();
        new Phone().playGame();
        new Phone().price=1999;
        new Phone().showprice();//0.0  而不是1999
    }

}

class Person{
    //属性(成员变量)
     String name;
     int age=1;
     boolean ismale;
     /*属性和局部变量的不同
     位置
     属性：直接定义在类的{}中
     局部变量：声明在方法内，方法形参  ，代码块内，构造器形参，构造器内部的变量
    权限修饰符
    属性：可以指明其权限：private，public，protected，缺省（封装性）
    局部变量：不可以使用权限修饰符
    默认初始化值
    属性：根据类型，都有默认初始化值（0，false，'\u0000'，null）
    局部变量：没有默认初始化值，调用前必须显式赋值
    在内存中加载的位置
    属性：堆（非static）
    局部变量：栈
      */

     //方法
    /*
    方法的声明：权限修饰符 返回值类型 方法名（形参列表）{方法体}

     */
    public void eat(){
        System.out.println("人可以吃饭");
    }
    public void sleep(){
        System.out.println("人可以睡觉");
    }
    public void talk(String word){   //word是形参，方法内部声明的也是形参
        System.out.println("人可以说话："+word);
    }

}


/*
匿名对象的使用

 */
class Phone{
    double price;

    public void sendEmail(){
        System.out.println("发送邮件");
    }
    public void playGame() {
        System.out.println("玩游戏");
    }
    public void showprice(){
        System.out.println("价格为:"+price);

    }




}

/*
方法的重载
定义：同一个类中，允许一个以上的同名方法，只要参数个数或参数类型不同即可
        同一个类 同名方法
        参数列表不同
是否为重载和权限修饰符，返回值类型，形参变量名，方法体都没有关系
在通过对象调用方法时，应确定一个指定的方法

 */
class Overload{
    public void getsum(int a,int b){

    }
    public void getsum(double a,int b){

    }
    public void getsum(int b,double a){

    }//顺序不同
//    private  void getsum(int a,int b){
//
//    }
}

/*
可变个数的形参
jdk5.0新增的内容
格式：数据类型 ... 变量名
无法和数组构成重载
必须声明在末尾
最多有一个可变形参
 */
class methodargs{
    public void show(int a)
    {

    }
    public void show(double a)
    {

    }
    public void show(int ... a)
    {

    }//可变个数  可构成重载 不可和数组重载（int [] a）
//    public void show(int [] a)
//    {
//
//    }//jdk 5.0以前的用法  本质上无区别
    //调用时用数组的形式 a[0],a[1]
    public void show(int b,int ... a)
    {

    }
//    public void show(int ... a,int b)
//    {
//
//    }//必须放在末尾


}