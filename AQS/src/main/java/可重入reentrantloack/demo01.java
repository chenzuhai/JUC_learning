package 可重入reentrantloack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/4/4 11:12
 */
public class demo01 {
    private Lock lock = new ReentrantLock(true);
    public void A(){
        lock.lock();
        try {
            B();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void B(){
        lock.lock();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        demo01 demo01 = new demo01();
        Thread thread = new Thread(() -> {
            demo01.A();
            System.out.println("finish");
        });
        thread.start();
    }

}
