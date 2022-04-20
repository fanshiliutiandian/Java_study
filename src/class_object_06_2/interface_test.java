package class_object_06_2;
//关键字接口（interface）
/*
一方面，有时必须从几个类中派生出一个子类，继承它们所有的属性和方法。
但是 Java不支持多重继承。有了接口，就可以得到多重继承的效果 。
继承是一个是不是的关系，而接口实现则是能不能的关系。
接口的使用
    1 接口用interface来定义
    2 在Java中，接口和类是并列的结构
    3 如何定义接口，定义接口的成员
        3.1 jdk7及以前
            只能定义全局常量和抽象方法
            全局常量：public static final的（书写时可以省略，仍然是）
            抽象方法：public abstract的
        3.2 jdk8
            还可定义静态方法，默认方法（先略过）
    4 接口中不能定义构造器!意味着接口不可以实例化
    5 java开发中，接口通过让类实现（implements）的方式来使用
        如果实现类覆盖了接口所有的抽象方法，则此实现类就可以实例化
        如果实现类没有覆盖了接口所有的抽象方法，则此实现类仍未抽象类

    6 java类可以实现多个接口（弥补了单继承性的局限性）
        格式：class aa extends bb implements cc，dd，ee(如String)
    7 接口与接口之间可以多继承



******************
    8 接口的具体使用，体现多态性
    9 接口实际可以看作一种规范

    接口的应用
        代理模式：代理模式是Java开发中使用较多的一种设计模式。代理设计就是为其他对象提供一种代理以控制对这个对象的访问。
            应用场景：安全代理，远程代理，延迟加载等
No.     区别点     抽象类                 接口
1       定义      包含抽象方法的类        主要是抽象方法和全局常量的集合
2       组成      构造方法、抽象方法、     常量、抽象方法、（默认方法、静态方法）
                普通方法、常量、变量
3       使用      子类继承抽象类            子类实现接口
4       关系      抽象类可以实现多个接口     接口不能继承抽象类，但允许继承多个接口
5     常见设计模式    模板方法            简单工厂、工厂方法、代理模式
6       对象          都通过对象的多态性产生实例化对象
7       局限      抽象类有单继承的局限          接口没有此局限
8       实际      作为一个模板              是作为一个标准或是表示一种能力
9       选择          如果抽象类和接口都可以使用的话，优先使用接口，因为避免单继承的局限

 */



public class interface_test {
    public static void main(String[] args) {
        System.out.println(flyable.MAX_SPEED);
//        flyable.MIN_SPEED=2;//仍是常量，无法修改





    }



}

interface flyable{
    //全局常量
    public static final int MAX_SPEED=7900;
    int MIN_SPEED=1;//不写仍然是

    //抽象方法
    public abstract void fly();

    void stop();//也可省略
//    public flyable(){
//
//    }//不能定义构造器



}

interface attackable{



}

class plane implements flyable{

    @Override
    public void fly() {
        System.out.println("引擎起飞");

    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速");

    }
}

class bullet extends Object implements flyable,attackable,cc{//继承父类，实现接口

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }
}//实现多个接口
abstract class kite implements flyable{

    @Override
    public void fly() {
        System.out.println("风筝起飞");

    }
}//没有完全覆盖，仍为抽象类
interface aa{
    void method1();

}
interface bb{
    void method2();

}
interface cc extends aa, bb{



}//接口的多继承