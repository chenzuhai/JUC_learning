import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/18
 */
public class AQS {

    private  static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                test();
            });
        }
    }

    public  static void test(){
        reentrantLock.lock();
        System.out.println("1");
        reentrantLock.unlock();
    }
}
