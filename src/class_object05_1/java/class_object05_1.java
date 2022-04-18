package class_object05_1.java;

public class class_object05_1 {
    public static void main(String[] args) {

        //继承性
        /*
        继承性的好处：
            继承的出现减少了代码冗余，提高了代码的复用性
            继承的出现，更有利于功能的扩展
            继承的出现让类与类之间产生了关系，提供了多态的前提
        语法规则：class Subclass extends SuperClass{}
            子类继承后获取到父类所有声明的属性和方法
            子类不能直接访问父类中私有的（private）的成员变量和方法（也继承了）（封装性）
        Java只支持单继承和多层继承，不允许多重继承
            一个子类只能有一个父类
            一个父类可以派生出多个子类


        Object类
            如果没有显式声明继承一个类，则此类继承于java.lang.Object类
            所有java类都直接或间接继承于java.lang.Object类（自己除外）





         */
        Person p1=new Person();
        p1.age=1;
        p1.eat();

        Student s1=new Student();
        s1.eat();

        //方法的重写
        /*
        定义
            在子类中可以根据需要对从父类中继承来的方法进行改造，也称为方法的重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。
        重写的要求：
            子类重写的方法必须和父类被重写的方法具有相同的方法名称、形参列表
            子类重写的方法使用的访问权限不能小于父类被重写的方法的访问权限（private->...->public）
                private权限的方法不能被重写（特殊情况）
            子类重写的方法的返回值类型不能大于父类被重写的方法的返回值类型
                父类             子类
                void             void
                A类              A类或者A的子类
                基本数据类型      相同数据类型

            子类方法抛出的异常不能大于父类被重写方法的异常（后续学习）
            子类与父类中同名同参数的方法必须同时声明为非static的(即为重写)，或者同时声明为static的（不是重写）。
            因为static方法是属于类的，子类无法覆盖父类的方法。（后续学习）

         */
        s1.walk(10);


        //四种权限修饰符
        /*
        修饰符       类内部    同一个包   不同包的子类    同一个工程
        private      yes
        default      yes      yes
        protected    yes      yes        yes
        public       yes      yes        yes           yes
        修饰类的，只能用default和public
        public类可以在任意地方被访问
        default类只可以被同一个包内部的类访问




         */

        System.out.println("***********");
        //关键字super
        /*
        在子类的方法或构造器中，使用super.属性/super.方法显式调用（习惯省略）
        子父类同名属性时，必须使用super.属性表明调用的是父类声明的属性
        子类重写了父类的方法后，必须使用super.方法表明是父类中被重写的方法

         */
        Person p2=new Person();
        p2.eat();

        Student s2=new Student();
        s2.study();//调用父类的方法

        /*
        在子类的构造器中使用super（形参列表）的方式，调用父类声明的指定的构造器
        super（形参列表）的使用，必须放在首行
        this（形参列表）也在首行，只能二选一
        都不加时，默认是super（）；
        如果子类构造器中既未显式调用父类或本类的构造器且父类中又没有无参的构造器，则编译出错（缺少super（）空参构造器）
        类的多个构造器，至少有一个为super（）
         */  //调用父类的构造器




        System.out.println("***********");
        //多态性
        /*
        对象的多态性：父类的引用指向子类的对象（子类的对象赋给父类的引用）
        编译期调用父类的方法，执行期调用子类重写父类的方法

        多态性的使用前提：
            类的继承关系
            方法的重写

        对象的多态性不适用于属性，只适用于方法（编译运行都看左边）

         */
        Person p3=new Student();//对象的多态性：父类的引用指向子类的对象（子类的对象赋给父类的引用）
        p3.eat();//多态的使用：当调用子父类同名函数时，实际执行的是子类重写父类的方法---虚拟方法调用
//        p3.study();//无法调用子类特有的方法
        //编译看左，运行看右

        //如何才能调用子类特有的属性和方法:向下转型（向上转型就是多态）
        /*
        使用强制类型转换符
         */
        Student s3=(Student) p3;
        //使用强转时，可能出现ClassCastException异常

        //操作符instanceof
        /*
        a instanceof A:判断对象a是否是类A的实例，是返回true，不是返回false（间接父类也返回true）
        使用情景：使用向下转型前进行判断，返回true就进行向下转型，反之则不
         */
        if(s3 instanceof Student){
            System.out.println("是对应类的实例");
        }



        //Object类的使用
        /*
        Object 类是所有 Java类的根父类
        如果在类的声明中未使用 extends关键字指明其父类.则默认父类为java lang Object类

        Object类的功能具有通用性


         */
        /*
        ==运算符：
            可以使用在基本数据类型和引用数据类型变量中
            基本数据类型中比较的是值是否相等（数据类型可以不同）（布尔型无法比较）
            引用数据类型比较的是是否指向同一个对象（指向同一块地址）
        equals（）：
            是方法而不是运算符
            所以只适用于引用数据类型
            Object中equal是（）中的定义：
                public boolean equals(Object obj){
                    return (this==obj);
                }
                Object类中的equals（）和==相同，都是比较两个地址值相同
            像String,Date,File,包装类都重写了equals（）方法，重写后不再比较引用的地址值，而是比较两个对象的实体内容（重写的规则）
            通常情况下，自定义类中的equals()方法也想比较实体内容是否相等，则需要对equals（）方法进行重写





         */ //equals()方法


        //toString()方法
        /*
        当输出一个对象的引用时，实际上是调用当前对象的toString（）
        定义：
            public String toString() {
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
            }
        String,Date,File,包装类都重写了toString()方法，使得调用时返回实体内容信息





         */
        System.out.println("toString()方法");
        Person s4=new Person("tom",18);
        System.out.println(s4.toString());//class_object05_1.java.Person@1b6d3586  重写后：Person{name='tom', age=18, id=0}
        System.out.println(s4);           //class_object05_1.java.Person@1b6d3586
        String str1=new String("aaa");
        System.out.println(str1);        //aaa



        /*单元测试
        1 选择当前工程，右键选择：build path -add libraries-JUnit 4-下一步
        2 创建java类，进行单元测试
            此时java类要求：公共类，有公共的无参构造器
        3 此类中声明单元测试方法
            方法的权限是public，没有返回值，没有形参
        4 此单元测试方法上需要声明注解：@Test  ，并在类中导入：import org.junit.Test
        5 声明好测试方法后，就可以测试相关代码
        6 左键双击单元测试方法名，右键：run as - JUnit Test
            红条：异常
            绿条：正常


        */   //单元测试


        System.out.println("包装类");
        //包装类
        /*
        java提供八种包装类型，是的基本数据类型具有类的特征

        基本类型、包装类与String 类间的转换
        基本数据类型<->包装类
            1.通过构造器：Integer t = new Integer(11);
            2.通过字符串参数：Float f = new Float("32.1F");
            3.自动装箱
            拆箱
            1.调用包装类的方法：xxxValue()
            2.自动拆箱
            JDK1.5 之后，支持自动装箱，自动拆箱。但类型必须匹配。
        基本数据类型，包装类<->String类型
            1 连接运算
            2 调用String重载的valueOf（XXX xxx）
            1 调用包装类的parseXxx(string s)





         */
        Integer i1=new Integer(123);//基本数据类型>包装类
        System.out.println(i1.toString());
        int in1=i1.intValue();//包装类->基本数据类型
        Integer i2=new Integer("123");
        System.out.println(i2.toString());
        //自动装箱：将基本数据类型当类 当形参传入类

        int i3=i2;//自动拆箱


        //boolean
        Boolean b1=new Boolean(true);
        System.out.println(b1.toString());
        Boolean b2=new Boolean("true");
        System.out.println(b2.toString());
        Boolean b3=new Boolean("true123");//ctrl+Alt+鼠标左键
        System.out.println(b3.toString());//false


        float f1=12.3f;
        String string2=f1+"";
        String string1=String.valueOf(f1);//基本（包装类可开箱）->string
        Float num1=Float.parseFloat(string2);//基本<-string
        System.out.println(num1);//12.3












    }
    public void test() {

    }


}



