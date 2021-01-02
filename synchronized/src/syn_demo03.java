import java.util.concurrent.CountDownLatch;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/18
 */
public class syn_demo03 implements Runnable {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 5000; j++) {
            new Thread(new syn_demo03()).start();
        }

        System.out.println(i);
        // Thread.sleep(1000);
    }

    @Override
    public  void run() {
        add();

    }
    public  void add(){
        synchronized (syn_demo03.class){
            i++;
            System.out.println(i);
        }

    }

}
