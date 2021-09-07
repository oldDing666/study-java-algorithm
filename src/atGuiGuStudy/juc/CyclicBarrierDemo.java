package atGuiGuStudy.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: afuya
 * @program: BiShiLianXi
 * @date: 2021/8/19 10:16 上午
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("**********召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            final int itemp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t收集到第：" + itemp + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
