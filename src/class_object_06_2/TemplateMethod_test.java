package class_object_06_2;

//模板方法设计模式（TemplateMethod）
/*
当功能内部一部分实现是确定的一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现 。
换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是
某些部分易变，易变部分可以抽象出来，供不同子类实现。这就是一种模板模式。
 */


public class TemplateMethod_test {

    public static void main(String[] args) {

        SubTemplate t=new SubTemplate();
        t.getTime();


    }
}
abstract class Template {
    public final void getTime() {
        long start =System.currentTimeMillis();
        code();
        long end =System.currentTimeMillis();
        System.out.println("执行时间为："+(end-start));
    }//确认的方法
    public abstract void code();//不确定的部分
}
class SubTemplate extends Template {
    public void code() {
        for(int i = 0; i < 10000; i ++)
            System.out.println(i);
    }
}
