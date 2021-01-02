package 指令重排序;

import java.util.concurrent.CountDownLatch;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/10/31
 */
public class demo01 {
    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(2);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                    latch.countDown();
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                    latch.countDown();
                }
            });
            one.start();
            other.start();
            latch.await();
            String res = "第" + i + "次" + "(" + x + "," + y + ")";
            System.out.println(res);
            if (x == 0 && y == 0) {
                System.out.println(res);
                break;
            }
        }
    }
}
