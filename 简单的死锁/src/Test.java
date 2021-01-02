/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/12 12:10
 */
public class Test {
    private static String A = "A";
    private static String B = "B";

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try{
                        Thread.currentThread().sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized(B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new Test().deadLock();
        System.out.println("666");
    }
}
