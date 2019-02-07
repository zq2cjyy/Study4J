package luzq.std.jstd.base.parallel;

import java.util.concurrent.CountDownLatch;

public class ToolsDemo {
    public void run() throws InterruptedException {
        runCountDownLatch();
    }

    public void runCountDownLatch() throws InterruptedException {
        System.out.println("开始执行");
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new CountThread(i, latch);
            thread.start();
        }
        latch.await();
        System.out.println("任务完成");
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
}
