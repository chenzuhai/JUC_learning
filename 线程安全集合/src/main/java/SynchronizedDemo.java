import java.util.*;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/3/10 18:49
 */
public class SynchronizedDemo {
    public static int a=0;
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new LinkedList<>());
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threads[i] = new Thread(()->{
                list.add(finalI);
                set.add(finalI);
            });
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }
        System.out.println(set);
    }
}
