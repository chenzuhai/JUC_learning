package s01;
//抽象队列同步器

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/1/2 16:57
 */
public class Example02 {
    public static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                synchronized (Example02.class){
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
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
