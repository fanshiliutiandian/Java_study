package thread08;

/*
1.多线程出现了安全问题
2.问题的原因：
    当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有
    执行完，另一个线程参与进来执行。导致共享数据的错误。
3.解决办法：
    对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以
    参与执行




 */
//同步代码块
//实现多线程

public class TicketDemo_implements {
    public static void main(String[] args) {
        Ticket t = new Ticket();

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
class Ticket implements Runnable {
    private int tick = 100;
//    Object obj = new Object();

    public void run() {
        while (true) {
            synchronized (this) {//可以用this（锁唯一）
                if (tick > 0) {

//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick);//甚至可能出现-1
                    tick--;
                } else {
                    break;
                }
            }

        }
    }
}

