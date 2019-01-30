package luzq.std.jstd.sp.service.demo;

import org.springframework.stereotype.Service;

@Service("scheduled")
public class ScheduledDemo implements DemoService {
    @Override
    public void run() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
