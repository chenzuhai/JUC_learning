/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/6/18
 */

/**
 * Created by qiyei2015 on 2017/5/13.
 */
public class Instance {
    private String str = "";
    private int a = 0;

    private volatile static Instance ins = null;
    /**
     * 构造方法私有化
     */
    private Instance(){
        str = "hello";
        a = 20;
    }

    /**
     * DCL方式获取单例
     * @return
     */
    public static Instance getInstance(){
        if (ins == null){
            synchronized (Instance.class){
                if (ins == null){
                    ins = new Instance();
                }
            }
        }
        return ins;
    }

    public static void main(String[] args) {

    }

}

