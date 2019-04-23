package luzq.std.jstd.base;

import luzq.std.jstd.base.parallel.ThreadDemo;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
//        ToolsDemo demo = new ToolsDemo();
//        demo.run();
//        Volatile vol = new Volatile();
//        vol.run();
//        System.out.println("hello gogogo");
//        RedisDemo.run();
        ThreadDemo demo = new ThreadDemo();
        demo.run();
//        long l = 1552935840000L;
//        long ll = l - 8 * 60 * 60 * 1000;
//        Date date = new Date(ll);
//        System.out.println(date);
    }
}
