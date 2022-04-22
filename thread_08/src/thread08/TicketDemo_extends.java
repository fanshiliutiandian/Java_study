package thread08;

//同步代码块
//继承多线程

public class TicketDemo_extends {
    public static void main(String[] args) {
        Ticket2 t1 = new Ticket2();
        Ticket2 t2 = new Ticket2();
        Ticket2 t3 = new Ticket2();

        t1.setName("t1窗口");
        t2.setName("t2窗口");
        t3.setName("t3窗口");
        t1.start();
        t2.start();
        t3.start();

    }


}
class Ticket2 extends Thread {
    private static int tick = 100;
    static Object obj=new Object();
    public void run() {
        while (true) {
            synchronized (obj) {//不能用this//可以用TicketDemo_extends.class
                if (tick > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick);//甚至可能出现-1
                    tick--;
                } else {
                    break;
                }
            }

        }
    }
}

