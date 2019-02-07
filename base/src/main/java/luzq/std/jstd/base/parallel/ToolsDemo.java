package luzq.std.jstd.base.parallel;

import java.util.concurrent.*;

public class ToolsDemo {
    public void run() throws InterruptedException, BrokenBarrierException {
//        runCountDownLatch();
//        runCyclicBarrier();
        runSemaphore();
    }

    /**
     * 虽然线程池大小为5 但是从运行结果来看 明显是5个同时执行
     * 这都是因为信号量对象 Semaphore 再起作用
     *
     * @throws InterruptedException
     */
    private void runSemaphore() throws InterruptedException {
        System.out.println("开始执行 Semaphore");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程中" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                }
            });
        }
        executor.shutdown();
        while (!executor.awaitTermination(1L, TimeUnit.SECONDS)) {
            System.out.println("正在等待任务完成");
        }
        System.out.println("Semaphore 执行完成");
    }

    /**
     * 类似于 GoLang中的 WaitGroup
     *
     * @throws InterruptedException
     */
    private void runCountDownLatch() throws InterruptedException {
        System.out.println("开始执行 CountDownLatch");
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new CountThread(i, latch);
            thread.start();
        }
        latch.await();
        System.out.println("CountDownLatch 任务完成");
    }

    /**
     * 加强版的 CountDownLatch
     * 可以reset 继续使用
     * 可以设置第二个参数 再所有线程都await以后 即 达到屏障  开始执行这个Runnable对象
     *
     * @throws BrokenBarrierException
     * @throws InterruptedException
     */
    private void runCyclicBarrier() throws BrokenBarrierException, InterruptedException {
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
