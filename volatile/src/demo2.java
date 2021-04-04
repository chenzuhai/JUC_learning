/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/4/3 17:34
 */
public class demo2 {
    public static  int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100000];
        for (int i = 0; i < 100000; i++) {
            threads[i] = new Thread(() -> {
                synchronized (demo2.class){
                    a++;
                }
            });
        }
        for (int i = 0; i < 100000; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 100000; i++) {
            threads[i].join();
        }
        System.out.println(a);
    }
}
