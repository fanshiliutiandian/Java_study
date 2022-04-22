package thread08;

//线程的通信
/*
wait()与 notify()和notifyAll()
    wait()：令当前线程挂起并放弃CPU 、同步资源并等待，使别的线程可访问并修改共享资源，而当前线程排队，
    等候其他线程调用notify()或notifyAll()方法唤醒，唤醒后等待重新获得对监视器的所有权后才能继续执行。
    notify()：唤醒正在排队等待同步资源的线程中优先级最高者结束等待
    notifyAll()：唤醒正在排队等待资源的所有线程结束等待
这三个方法只有在synchronized方法或 synchronized代码块中才能使用，否则会报java.lang.IllegalMonitorStateException异常。
这三个方法默认由this调用
因为这三个方法必须由锁对象（同步监视器）调用，而任意对象都可以作为synchronized的同步锁，因此这三个方法只能在 Object类中声明

sleep()和wait()的异同
    相同点
        都会使线程进入阻塞状态
    不同点
        声明位置不同：Thread类中声明sleep();Object类中声明wait()
        调用位置不同：sleep()任何需要的场景;wait()必须使用在同步代码块（方法）中
        是否释放同步监视器：如果都在同步代码块（方法中），sleep（）不会释放同步监视器，wait（）会


 */

public class communication {
    public static void main(String[] args) {
        Number c=new Number();
        Thread c1=new Thread(c);
        Thread c2=new Thread(c);

        c1.setName("线程一");
        c2.setName("线程二");
        c1.start();
        c2.start();

    }
}

class Number implements Runnable {
    private int i = 1;

    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (i <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                } else
                    break;
                try {
                    //使得调用wait（）方法的线程进入阻塞状态
                    //wait（）会释放锁（sleep不会）
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
