package 并发工具;

import java.util.concurrent.CountDownLatch;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/1/7 12:04
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"go out");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("close Door");
    }
}
