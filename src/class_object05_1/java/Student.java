package class_object05_1.java;

public class Student extends Person {//继承Person方法    extends Person
//    String name;//被继承，可不写
//    int age;
    String major;

    int id;//学号（同名属性）//得使用super调用父类，this调用子类


    public Student(){
        System.out.println("子类构造器");
    }
    public Student(String name,int age,String major){
        this.age=age;
        this.name=name;
        this.major=major;

    }

    public Student(String name,int age){
        super(name,age);//调用父类的构造器（如属性权限是private）
//        this.age=age;
//        this.name=name;

    }

//    public void eat(){
//        System.out.println("吃饭");
//    }


    public void eat() {
        System.out.println("学生吃饭");
    }//对父类中的eat方法进行了重写



    public void study(){
        System.out.println("学习");
        this.eat();
        super.eat();//调用父类的方法
    }


}
