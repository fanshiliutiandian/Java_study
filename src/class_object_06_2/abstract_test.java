package class_object_06_2;
//关键字abstract
/*
1 abstract 抽象的
2 abstract可以用来修饰的结构：属性，方法
3 abstract修饰类：抽象类
    此类不能实例化
    抽象类中一定有构造器，子类实例化时调用（子类实例化的全过程）
    开发中，都会提供抽象类的子类，让子类实例化，完成相关操作
4 abstract修饰方法：抽象方法
    只有方法的声明，没有方法体
    包含抽象方法的类，一定是抽象类。反之抽象类中可以没有抽象方法
    若子类重写了父类所有的抽象方法，方可实例化
    若子类没有重写全部的抽象方法，则子类也为抽象类

5 注意点
    不能用来修饰：属性，构造器等结构
    不能用来修饰私有方法，静态方法，final的方法，final的类


抽象类的匿名子类

 */


public class abstract_test {
    public static void main(String[] args) {
//        person p1=new person();//person类抽象后，不可实例化
//        p1.eat();
    }


}
abstract class creature{


}

abstract class person{
    String name;
    int age;
    public person(){

    }
    public person(String name,int age){
        this.name=name;
        this.age=age;

    }

    public void eat(){
        System.out.println("eat！");
    }
    public abstract void walk();//抽象方法//抽象方法必须在抽象类中
    public void talk(){

    }//不是抽象方法



}

class student extends person{//方法2 子类也为抽象类
    @Override
    public void walk() {

    }//方法1 重写父类的抽象方法

    public student(String name, int age){
        super(name, age);
    }


}
