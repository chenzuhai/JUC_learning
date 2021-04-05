import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2021/4/5 18:51
 */
public class Person {
    public int i = 0;

    private static Unsafe UNSAFE = null;

    private static long I_OFFSET;
    static {
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);

            //UNSAFE = Unsafe.getUnsafe();
            I_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("i"));
            System.out.println(I_OFFSET);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Person person = new Person();
        new Thread(()->{
            while(true){
                //person.i++;

                boolean b = UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i+1);
                System.out.println("线程一修改"+b);
                System.out.println(UNSAFE.getIntVolatile(person,I_OFFSET));
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
        new Thread(()->{
            while(true){
               // person.i++;

                boolean b = UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i + 1);
                System.out.println("线程二修改"+b);
                System.out.println(UNSAFE.getIntVolatile(person,I_OFFSET));
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

    }
}
