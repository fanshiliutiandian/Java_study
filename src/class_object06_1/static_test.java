package class_object06_1;

//static关键字的使用
/*
1 static 静态的
2 static可以修饰 属性，方法，   代码块，内部类
3 static修饰属性：静态变量
    属性，是否使用static修饰，分为静态属性（类变量）和非静态属性（实例变量）
    静态变量随着类的加载而加载（实例变量随着对象）
    静态变量的加载早于对象的创建
    可以通过  类.静态变量  的方式进行调用
    由于类只加载一次，所以静态变量在内存中也只存在一份（方法区的静态域）
    静态属性举例：System.out ,Math.PI
4 static修饰方法
    随着类的加载而加载，可以通过  类.静态方法  的方式进行调用
    静态方法中只能调用静态属性和方法，非静态方法都能调用
5 static注意点
    静态方法中，不能调用this，super（从生命周期理解）
6 如何确认是否要声明为static
    不因对象而不同的属性
    类中的常量也常声明为static
    操作静态属性的方法
    工具类中的方法，如Math,Arrays,Collections

 */

public class static_test {
    public static void main(String[] args) {
        System.out.println("类变量*******");
        {
            chinese.nation = "zhongguo";//调用类变量   类.静态变量

            chinese c1 = new chinese();
            c1.name = "小明";
            c1.age = 18;
            chinese c2 = new chinese();
            c1.name = "小李";
            c1.age = 19;

            c1.nation = "中国";
            System.out.println(c2.nation);//中国
        }//静态变量
        System.out.println("静态方法*******");
        {

            chinese.show();
//        chinese.info();
        }//静态方法
        System.out.println("单例设计模式*******");
        {

            bank bank1 = bank.getInstance();
            bank bank2 = bank.getInstance();
            System.out.println(bank1 == bank2);//true
            //只有一个实例
            order order1 = order.getInstance2();
            order order2 = order.getInstance2();
            System.out.println(order1 == order2);//true
            //java.lang.Runtime(实例)

        }//单例设计模式


    }

}
class chinese{

    String name;
    int age;
    static String nation;

    public void eat(){
        System.out.println("中国人吃中餐");

    }
    public static void show(){
        System.out.println("我是中国人！");
//        eat();//静态方法不能调用
//        name="tom";
    }
    public void info(){
        System.out.println("name:"+name+",age:"+age);

    }


}

//单例设计模式
/*
设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。设计模免去我们自己再思考和摸索。
1 类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。
2 如何实现
    饿汉式  懒汉式
3 区分饿汉式，懒汉式
    饿汉式：对象加载时间过长（static关键字也是如此）     天然线程安全（后续学习）
    懒汉式：延迟对象的创建                             （目前）线程不安全（后续修改）

4 优点：由于单例模式只生成一个实例，减少了系统性能开销 ，当一个对象的产生需要比较多的资源时，
如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方
式来解决。
5 应用场景：网站的计数器，应用程序的日志应用，数据库连接池，Application，Task Manager（任务管理器），Recycle Bin（回收站）

 */
//饿汉式
class bank{
    //1 私有化类的构造器
    private bank(){

    }
    //2 内部创建类的对象
    //4 要求此对象也必须声明为静态的
    private static bank instance=new bank();

    //4 提供公共的静态的方法，返回类的对象
    public static bank getInstance() {
        return instance;
    }
}
//懒汉式
class order{
    //1 私有化类的构造器
    private order(){

    }
    //2 声明当前类的对象,没有初始化
    //4 要求此对象也必须声明为静态的
    private static order instance2 =null;//什么时候用，什么时候造
    //3 声明public，static的返回当前类对象的方法
    public static order getInstance2() {
        if(instance2==null) {
            instance2 = new order();
        }
        return instance2;
    }
}
