import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        //创建线程池对象  参数5，代表有5个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        //创建Runnable线程任务对象
        TaskRunnable task = new TaskRunnable();
        //从线程池中获取线程对象
        service.submit(task);
        System.out.println("----------------------");
        //再获取一个线程对象
        service.submit(task);
        //关闭线程池
        service.shutdown();
    }
}


class TaskRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行" + i);
        }
    }
}