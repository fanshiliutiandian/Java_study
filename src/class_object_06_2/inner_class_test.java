package class_object_06_2;

//内部类
/*
1 在Java中，允许一个类的定义位于另一个类的内部，前者称为内部类，后者称为外部类。
2 分类：成员内部类，局部内部类（方法，构造器，代码块内）
3 成员内部类
    一方面，作为外部类的成员
        调用外部类的结构
        可以被static修饰
        可以被四种不同的权限修饰

    另一方面，作为一个类
        类内可以定义属性，方法，构造器等
        可以被final修饰，表明不能被继承（不加则表明可以）
        可以被abstract修饰，表明不能被实例化
4 关注的问题
    实例化成员内部类的对象
    如何在内部类中区分调用外部类的结构
    开发中，局部内部类的使用
 */

public class inner_class_test {
    public static void main(String[] args) {
        //创建dog实例（静态的成员内部类）
        person1.dog d1=new person1.dog();
        d1.show();
        //创建bird实例（非静态的成员内部类）
        person1 p1=new person1();
        person1.bird b1= p1.new bird();
        b1.sing();

    }
}
class person1{
    String name;
    //成员内部类
    static class dog{
        int age;
        String name;
        public void show(){
            System.out.println("dog show!");
        }

    }
    class bird{
        String name;
        public bird(){

        }
        public void sing(){
            System.out.println("sing!");
        }//类内可以定义属性，方法，构造器
        public void display(String name){
            System.out.println(name);//方法形参的name
            System.out.println(this.name);//bird类的name（内部类）
            System.out.println(person1.this.name);//person1类的name（外部类）
            //未重名直接调用
        }

    }


    //局部内部类
    public void method(){
        class AA{

        }
    }
    {
        class BB{

        }
    }
    public person1(){

    }
}
