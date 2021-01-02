import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/8/18
 */
public class CAS {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;


    private void safeCount(){
        for(;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i,++i);
            if(suc){
                break;
            }
        }
    }
    private void count(){
        i++;
    }

    public static void main(String[] args) {
        final CAS cas = new CAS();
        List<Thread> ts = new ArrayList<>(600);
        Long start = System.currentTimeMillis();
        for(int j = 0;j<100;j++){
            Thread t =new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        for(Thread t:ts){
            t.start();
        }
        for(Thread t:ts){
            try{
                t.join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis()-start);
    }
}
