import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        TaskCallable c = new TaskCallable();
        //线程池中获取线程对象，调用run方法
        service.submit(c);
        //再获取一个
        service.submit(c);
        //关闭线程池
        service.shutdown();
    }
}


class TaskCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程任务在执行" + i);
        }
        return null;
    }
}