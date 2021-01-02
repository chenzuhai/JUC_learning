/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/10/28
 */
public class syn_demo01 implements Runnable{
    private static int a=0;

    public  void add(){
        synchronized (syn_demo01.class){
            a++;
        }
        System.out.println(a);
    }

    public static void main(String[] args) throws InterruptedException {
        syn_demo01 syn_demo01 = new syn_demo01();
        for (int i = 0; i < 10000; i++) {
            Thread thread1 = new Thread(syn_demo01);
            thread1.start();
        }
    }

    @Override
    public void run() {
        add();
    }
}
