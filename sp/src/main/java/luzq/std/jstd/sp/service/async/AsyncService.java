package luzq.std.jstd.sp.service.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void execInteger(int i) {
        System.out.println("执行:" + i);
    }

    @Async
    public void execIntegerPlus(int i) {
        System.out.println("执行+:" + (i + 1));
    }
}
