package luzq.std.jstd.sp.service.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduledTaskService {
    @Scheduled(fixedRate = 5000)
    public void doSth() {
        System.out.println(new Date());
    }
}
