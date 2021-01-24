package s03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/1/2 18:07
 */
public class Example03 {
    public static int m = 0;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(()->{
                lock.lock();
                try {
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                }finally {
                    lock.unlock();
                }
            });
        }
        for(Thread t:threads) {
            t.start();
        }
        //等待所有线程运行结束
        for(Thread t:threads) {
            t.join();
        }
        System.out.println(m);
    }
}
