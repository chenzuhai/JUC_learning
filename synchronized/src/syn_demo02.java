import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/10/28
 */
public class syn_demo02 implements Runnable{

    static AtomicInteger  atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new syn_demo02()).start();
        }
        Thread.sleep(2000);
        System.out.println(atomicInteger);
    }

    @Override
    public void run() {
        atomicInteger.getAndAdd(10);
    }
}
