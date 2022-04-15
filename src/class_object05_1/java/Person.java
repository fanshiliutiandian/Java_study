package class_object05_1.java;

public class Person{
    String name;
    int age;
    int id;//身份证号

    public Person(){
        System.out.println("我无处不在");
    }

    public Person(String name){
        this.name=name;
    }
    public Person(String name,int age){
        this();
        this.age=age;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void walk(int distance){
        System.out.println("走的距离:"+distance);
    }
    public void show(){
        System.out.println("name="+name+",age="+age);
    }



}
