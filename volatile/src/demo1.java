/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/9/22
 */
public class demo1 {
    int i=0;
    public void set(int i){
        this.i = i;
    }
    public synchronized void  getAndIncement(){
        i = i+1;
        System.out.println(i);
    }
    public int get(){
        return i;
    }
    private class thread implements Runnable{

        @Override
        public void run() {
            getAndIncement();
        }
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            thread t = new thread();
            new Thread(t).start();
        }
    }
    public static void main(String[] args) {
        demo1 d = new demo1();
        d.run();
    }
}
