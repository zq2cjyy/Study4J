package luzq.std.jstd.base.parallel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ToolsDemo {
    public void run() throws InterruptedException, BrokenBarrierException {
//        runCountDownLatch();
        runCyclicBarrier();
    }

    public void runCountDownLatch() throws InterruptedException {
        System.out.println("开始执行 CountDownLatch");
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new CountThread(i, latch);
            thread.start();
        }
        latch.await();
        System.out.println("CountDownLatch 任务完成");
    }

    public void runCyclicBarrier() throws BrokenBarrierException, InterruptedException {
        System.out.println("开始执行 CyclicBarrier -1");

        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Runnable() {
            public void run() {
                System.out.println("额外执行");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread thread = new CycThread(i, cyclicBarrier);
            thread.start();
        }
        cyclicBarrier.await();
        System.out.println("CyclicBarrier-1 任务完成");

        System.out.println("开始执行 CyclicBarrier -2 ");
        cyclicBarrier.reset();
        for (int i = 0; i < 5; i++) {
            Thread thread = new CycThread(i, cyclicBarrier);
            thread.start();
        }
        cyclicBarrier.await();
        System.out.println("CyclicBarrier -2 任务完成");
    }

    class CountThread extends Thread {

        private int num;
        private CountDownLatch latch;

        CountThread(int i, CountDownLatch countDownLatch) {
            super();
            this.num = i;
            this.latch = countDownLatch;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                System.out.println("线程" + num + "\t" + "行:" + j);
            }
            latch.countDown();
        }
    }

    class CycThread extends Thread {
        private int num;
        private CyclicBarrier cyclicBarrier;

        CycThread(int i, CyclicBarrier cyclicBarrier) {
            super();
            this.num = i;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                System.out.println("线程" + num + "\t" + "行:" + j);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
