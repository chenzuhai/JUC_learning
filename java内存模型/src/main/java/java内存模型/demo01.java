package java内存模型;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author Zuhai Chen
 * @version 1.0
 * @date 2020/10/31
 */
public class demo01 {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
