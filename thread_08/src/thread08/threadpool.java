package thread08;

//线程池
/*
背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大 。
思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用。类似生活中的公共交通工具。
好处：
    提高响应速度(减少了创建新线程的时间)
    降低资源消耗(重复利用线程池中线程，不需要每次都创建)
    便于线程管理
        corePoolSize：核心池的大小
        maximumPoolSize：最大线程数
        keepAliveTime：线程没有任务时最多保持多长时间后会终止




 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class threadpool {

    public static void main(String[] args) {

        //1 提供指定数量的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service1=(ThreadPoolExecutor)service;

        //设置线程池属性
        System.out.println(service.getClass());

        service1.setCorePoolSize(15);

        //2 执行指定线程的操作，需要Runnable（callable）接口实现类的对象
        service.execute(new Numberpool());//适合使用Runnable
//        service.execute(new Numberpool1());//另一个线程

        // 3 关闭线程池
        service.shutdown();

//        service.submit();//适合使用Callable

    }
}
class Numberpool implements Runnable {

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}