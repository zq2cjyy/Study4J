package luzq.std.jstd.base.parallel;

/**
 * 演示volatile关键字的主要功能之一
 * 保证变量的可见性 即 每次给变量赋值 都迅速更新到主内存中 每次读取 都从主内存中读取
 */
public class Volatile {
    public void run() throws InterruptedException {
        System.out.println("开始执行");
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(5000);
        thread.flag = false;
        System.out.println("任务执行完成");
        Thread.sleep(5000);

    }

    class MyThread extends Thread {
        public MyThread() {
            this.flag = true;
        }

        /**
         * 这个变量用于指示 是否应该继续执行线程
         * 如果没有 volatile关键字 则线程有概率出现一直再执行 (复现有概率)
         */
        public boolean flag;
//        public volatile boolean flag;


        @Override
        public void run() {
            while (flag) {
                System.out.println("执行任务");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
