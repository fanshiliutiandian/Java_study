public class class_object04_3 {


    public static void main(String args[]) {


        Animal a=new Animal();
        a.name="大黄";
        a.age=1;
//        a.legs=4;
        a.show();

        a.setLegs(6);
        a.show();
        a.setLegs(-6);
        a.show();
    }



}


//封装性的引入

//封装性的体现
//将属性私有化,增加公共的方法getxxx（）和setxxx（）
//拓展  私有化的方法；单例模式......
class Animal{
    String name;
    int age;
    private int legs;//腿的个数
    //设置为私有

    public void eat(){
        System.out.println("动物进食");
    }
    public void show(){
        System.out.println("name="+name+",age="+age+",legs="+legs);
    }
    public void setLegs(int l){
        if(l>=0&&l%2==0)
        {
            legs=l;
        }
        else
        {
            legs=0;
        }
    }
    public int getLegs(){
        return legs;
    }

}


//权限修饰符
/*
java四种权限  private 缺省（default） protected public
修饰符       类内部    同一个包   不同包的子类    同一个工程
private      yes
default      yes      yes
protected    yes      yes        yes
public       yes      yes        yes           yes
四种都可修饰类的内部结构：属性，方法，构造器，内部类
修饰类的，只能用default和public

 */


//构造器(构造方法 constructor)
/*
构造器的作用：创建对象；给对象进行初始化
//Person p=new Person();//Person()：构造器
如果类没有提供构造器，系统默认隐式提供一个无参构造器
构造器语法结构：修饰符 类名 （参数列表）{}
一个类可以创建多个重载的构造器
一旦显式定义了构造器，则系统不再提供默认构造器//Person p=new Person();会报错

 */



//javabean（拓展知识）
/*
JavaBean 是一种Java语言写成的可重用组件
 javaBean ，是指符合如下标准的 Java 类：
1 类是公共的
2 有一个无参的公共的构造器
3 有属性，且有对应的 get 、 set方法

用户可以使用 JavaBean 将功能、处理、值、数据库访问和其他任何可以用Java代码创造的对象进行打包，
并且其他的开发者可以通过内部的 JSP页面、Servlet、其他 JavaBean、applet程序或者应用来使用
这些对象。用户可以认为 JavaBean 提供了一种随时随地的复制和粘贴的功能，而不用关心任何改变。
 */
class JavaBean {
    private
    String name ; // 属性一般定义为 private
    private
    int age;
    public
    JavaBean() {
    }
    public
    int getAge() {
        return age;
    }
    public
    void setAge( int a ){
        age = a;
    }
    public
    String getName() {
        return name;
    }
    public
    void setName(String n ) {
        name=n;
    }
}


//UML类图（拓展知识）
/*
属性：
：“：”前是属性名，“：”后是属性的类型
方法
若方法有下划线表示为构造器
1.+ 表示 public 类型，-表示 private 类型， #表示 protected 类型
2.方法的写法 :方法的类型（+，-）方法名 （参数名： 参数类型 )：返回值类型
 */


//关键字this
/*
this的使用
1.this可以用来修饰属性，方法
2.this可以用来修饰调用构造器
 */
class person{
    private String name;
    private int age;

    person(){
        System.out.println("无参构造器");
    }
    person(int a){
        this();//调用当前对象的无参构造器   语法：this(形参列表)   //必须放在内部的首行  //最多有一个
        System.out.println("int a");
    }
    person(int a,String b){
        this(a);//调用上一个构造器
        System.out.println("int a,String b");
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;//this.name  ： 当前对象的属性name（形参和属性同名了）
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭");
        this.study();//this.study()   :  当前对象的方法
    }
    public void study(){
        System.out.println("学习");

    }
}


//关键字package
/*
1 对项目中类进行管理,提出包的概念
2 package 语句作为 Java源文件的第一条语句，指明该文件中定义的类所在的包。
  若缺省该语句，则指定为无名包 。它的格式为： package 顶层包名.子包名;
3 包通常用小写单词标识。通常使用所在公司域名的倒置：com.atguigu.xxx(包属于标识符)

补充：同一个包下不能定义同名的接口，类
 */

//MVC设计模式(补充)
/*
MVC
是常用的设计模式之一，将整个程序分为三个层次：视图模型层，控制器层，与数据模型层。
模型层    model        主要处理数据
控制层    controller   处理业务逻辑
视图层    view         显示数据

 */

//关键字import
/*
1 显式地导入指定包的类，接口
2 声明在包的声明和类的声明之间
3 导入多个，并列即可
4 "xxx.*"导入包下的所有类或接口
5 如果使用不同包下的同名的类，那么就需要使用类的全类名（包名.类名）的方式指明调用的是哪个类
6 如果已经导入 java.a包下的类,那么如果需要使用a包的子包下的类的话，仍然需要导入

7 import static组合的使用：调用指定类或接口下的静态的属性或方法(用的少  后续学习使用)

 */