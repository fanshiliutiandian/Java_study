package thread08;

//Lock(锁)
/*
解决线程安全的问题的方式三：Lock（锁）-----jdk5.0新增


synchronized与lock的异同
    相同点
        都可以解决线程安全问题
    Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是隐式锁，出了作用域自动释放
    Lock只有代码块锁，synchronized 有代码块锁和方法锁
    使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）




 */

import java.util.concurrent.locks.ReentrantLock;

public class locktest {
    public static void main(String[] args) {
        window w=new window();



        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();





    }



}
class window implements Runnable{
    private int ticket=100;

    //1实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();


    @Override
    public void run() {
        while(true){
            try {

                //2调用锁定方法：lock（）方法
                lock.lock();

                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票，票号为:"+ticket);
                    ticket--;

                }
                else {
                    break;
                }

            }finally {
                //调用解锁方法：unlock（）
                lock.unlock();

            }





        }

    }
}
