package thread08;

//同步方法
//实现
public class TicketDemo2_implements {
    public static void main(String[] args) {
        Ticket3 t = new Ticket3();

        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        Thread t3=new Thread(t);
        t1.setName("t1窗口");
        t2.setName("t2窗口");
        t3.setName("t3窗口");
        t1.start();
        t2.start();
        t3.start();

    }


}
class Ticket3 implements Runnable {
    private int tick = 100;


    public void run() {//这里不适合使用同步方法
        while (true) {//没有break，出不来循环
                show();


        }


    }
    public synchronized void show(){//同步方法

        if (tick > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick);
            tick--;
        }
    }

}
