package class_object05_1.java;

import java.util.Objects;

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
        this.name=name;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && id == person.id && Objects.equals(name, person.name);
    }//系统默认生成的equals（）


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
