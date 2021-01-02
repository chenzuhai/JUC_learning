import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/1 12:10
 */
public class TEST1_AtomicInteger {
    private static AtomicInteger m = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        CountDownLatch latch = new CountDownLatch(threads.length);

        Object o = new Object();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
               for(int j = 0 ;j<10000;j++){
                   m.incrementAndGet();
               }
               latch.countDown();
            });
        }
        Arrays.stream(threads).forEach((t)->t.start());

        latch.await();

        System.out.println(m);
    }
}
