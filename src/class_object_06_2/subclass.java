package class_object_06_2;

public class subclass {
    public static void main(String[] args) {
        subclasstest s=new subclasstest();
//        s.method1();
//        subclasstest.method1();
        //1 接口中定义的静态方法，只能通过接口调用
        jdk8_test.method1();
        //2 通过实现类的对象，可以调用接口中的默认方法
        //  如果实现类重写了，调用重写后的方法
        s.method2();
        //3 如果子类（实现类）的父类（接口），声明了同名同参的方法，如果没有重写，调用的是父类的方法

        //4 如果实现类实现了多个接口，接口中定义了同名同参的默认方法
        // 如果实现类没有重写此方法，报错->接口冲突
        // 需要在实现类中重写此方法
    }


}
class subclasstest implements jdk8_test{


}