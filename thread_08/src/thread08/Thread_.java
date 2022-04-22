package thread08;

/*
多线程的创建：
    方式一：
        创建继承Thread的子类
        重写Thread类的run（）->将此线程执行的操作声明在run（）中
        创建子类的实例对象
        通过此对象调用start（）   作用：1启动当前线程2调用当前线程的run（）
        （可以使用匿名子类的方式）



Thread类的有关方法：
    void start(): 启动线程，并执行对象的run()方法
    run(): 线程在被调度时执行的操作
    String getName(): 返回线程的名称
    void setName (String): 设置该线程名称
    static Thread currentThread (): 返回当前线程。在 Thread子类中就是this，通常用于主线程和Runnable实现类
    static void yield()线程让步
        暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程(可能仍然分配执行此线程)
        若队列中没有同优先级的线程，忽略此方法
    join()：当某个程序执行中调用其他线程的 join()方法时,调用线程将被阻塞，直到 join()方法加入的join线程执行完为止
        低优先级的线程也可以获得执行
    stop(): 强制线程生命期结束，不推荐使用。已过时
    static void sleep(long millis)：指定时间:毫秒
        令当前活动线程在指定时间段内放弃对CPU控制 使其他线程有机会被执行时间到后重排队。
        抛出 InterruptedException异常
    boolean isAlive：返回 boolean ，判断线程是否还活着

线程的优先级
    MAX_PRIORITY 10  最大
    MIN PRIORITY 1   最小
    NORM_PRIORITY 5  默认优先级

    getPriority ()返回线程优先值
    setPriority (int newPriority)改变线程的优先级
        线程创建时继承父线程的优先级
        低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用


方式二：实现Runnable接口
1)定义子类，实现 Runnable接口。
2)子类中重写 Runnable接口中的run方法。
3)通过Thread类含参构造器创建线程对象。
4)将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中 。
5)调用Thread类的start方法：开启线程调用 Runnable子类接口的run方法。


继承方式和实现方式的联系与区别
public class Thread extends Object implements Runnable
区别
    继承Thread：线程代码存放Thread子类run方法中。
    实现Runnable：线程代码存在接口的子类的run方法。
实现方式的好处
    避免了单继承的局限性
    多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源。

 */

public class Thread_ {
    public static void main(String[] args) {
//        {
//            mythread t1 = new mythread();//3.
//            t1.setName("线程一");
//            t1.setPriority(Thread.MAX_PRIORITY);//设置为最大优先级(不代表一定先会执行)
//            t1.start();//4.
////        t1.run();//不能直接调用run（）启动线程
//            //两个线程同时运行,会产生交互
//            System.out.println("hello");
//
//            Thread.currentThread().setName("主线程");
//            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
//            for (int i = 0; i < 100; i++) {
//                if (i % 2 == 0) {
//                    System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i + "*********");
//                }
////            if(i==20){
////                try {
////                    t1.join();//执行t1后，才继续执行主线程
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////
////            }
//            }
//
//
//            //不能让已经start（）的线程再执行（threadStatus不再是0，看源码）
//            //需要重新创建一个线程的对象
////        t1.start();//IllegalThreadStateException线程状态异常
//
//
////
////
////
////        new Thread(){
////            @Override
////            public void run() {//2.
////                for(int i=0;i<100;i++){
////                    if(i%2==0){
////                        System.out.println(Thread.currentThread().getName()+":"+i);
////                    }
////
////                }
////            }
////        }.start();//使用匿名子类的方式一次完成四步
//        }//方式一


        {
            mthread mthread1 = new mthread();//3
            Thread m1 = new Thread(mthread1);//4
            m1.start();//5  作用：1启动当前线程2调用当前线程的run（）->调用了Runnable类型的target的run()

            Thread m2 = new Thread(mthread1);
            m2.start();
        }//方式二





    }
}
class mythread extends Thread{//1.
    @Override
    public void run() {//2.
        for(int i=0;i<100;i++){
            if(i%2==0){
//                try {//父类没有抛异常，只能使用try-catch-finally
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
            }
//            if(i%20==0){
//                this.yield();
//            }

        }
    }

}


class mthread implements Runnable{//1


    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }

    }//2
}