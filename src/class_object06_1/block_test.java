package class_object06_1;


//类的成员之四：代码块（或初始化块）
/*
1 作用：初始化类，对象
2 如果有修饰，只能是static
3 分类：静态代码块，非静态代码块
4 静态代码块
    内部可以有输出语句
    随着类的加载而执行，且执行一次
    作用：可以初始化的信息
    如果定义了多个静态代码块，按声明先后顺序执行（没有必要写多个）
    静态代码块执行优先于非静态（生命周期）
5 非静态代码块
    内部可以有输出语句
    随着对象的加载而执行
    作用：可以在创建对象时，对对象进行初始化
    如果定义了多个非静态代码块，按声明先后顺序执行
    优先于构造器
 */
/*
属性赋值的位置
声明成员变量的默认初始化
显式初始化、多个初始化块依次被执行（同级别，按先后顺序执行）
构造器再对成员进行初始化操作
通过对象.属性或对象.方法的方式可多次给属性赋值
 */

public class block_test {
    public static void main(String[] args) {
        String desc=person.desc;//只执行一次
        System.out.println(person.desc);
        person p1=new person();
        person p2=new person();//每次创建对象都执行
        System.out.println(p1.age);



    }

}

class person{
    //属性
    String name;
    int age;
    static String desc;
    //构造器
    public person() {

    }
    public person(int age,String name){
        this.name=name;
        this.age=age;
    }

    //代码块
    static {
        System.out.println("block static-1");
        desc="我爱学习！";
    }
    static {
        System.out.println("block static-2");
    }
    {
        System.out.println("block-1");
        age=1;
    }
    {
        System.out.println("block-2");
    }


    //方法
    public void eat(){
        System.out.println("吃饭");
    }
    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }
    public static void info(){
        System.out.println("我是快乐的人");
    }

}
