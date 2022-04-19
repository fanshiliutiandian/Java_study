package class_object06_1;


//关键字final
/*
1 final可以用来修饰的结构：类，方法，变量
2 final用来修饰类
    此类不能其他类继承，如：String,System,StringBuffer等（不会也不需要再拓展功能）
3 final用来修饰方法
    此方法无法被重写，如：Object.getClass()
4 final用来修饰变量（非属性）
    此时变量就被称为一个常量
        修饰属性：可以考虑赋值的位置：显式初始化，代码块中，构造器中
        修饰局部变量：方法内部和形参
            尤其是形参时，表明是常量，一旦调用方法，给常量形参赋一个实参，之后只能在方法体内使用，且不能修改

static final用来修饰属性，称为全局常量；修饰方法，全局方法，不能重写（自定义修饰方法时用得少）
 */

public class final_test {
    public static void main(String[] args) {
        finala a=new finala();
    }


}
final class finala{
    final int width=10;
    final int LEFT;
    {
//        LEFT=20;
    }//代码块
    finala(){
        LEFT=20;
    }
    finala(int n){
        LEFT=n;
    }
    public void width(){
//        width=20;//无法修改
    }
}
//class b extends finala{
//
//}//无法继承被final修饰的类
class AA{
    public final void show(){

    }
}
//class bb extends AA{
//    public void show(){
//
//    }//无法重写final方法
//}