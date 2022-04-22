package thread08;

//同步方法
//继承
public class TicketDemo2_extends {
    public static void main(String[] args) {
        Ticket4 t1 = new Ticket4();
        Ticket4 t2 = new Ticket4();
        Ticket4 t3 = new Ticket4();

        t1.setName("t1窗口");
        t2.setName("t2窗口");
        t3.setName("t3窗口");
        t1.start();
        t2.start();
        t3.start();

    }


}
class Ticket4 extends Thread {
    private static int tick = 100;
    static Object obj=new Object();
    public void run() {
        while (true) {
            show();


        }
    }

    private static synchronized void show(){//同步监视器t1,t2,t3//当前监视器是class
//        private static synchronized void show(){//同步监视器t1,t2,t3
            if (tick > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + tick);//甚至可能出现-1
                tick--;
            }
        }

    }

