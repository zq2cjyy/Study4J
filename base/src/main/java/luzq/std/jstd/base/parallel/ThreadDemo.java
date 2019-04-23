package luzq.std.jstd.base.parallel;

public class ThreadDemo {

    int num = 1;

    public void run() throws InterruptedException {

        MyRunable runable = new MyRunable();

        Thread thread1 = new Thread(runable);
        Thread thread2 = new Thread(runable);
        Thread thread3 = new Thread(runable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(num);

    }


    class MyRunable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                num += 1;
            }
        }
    }
}
