package luzq.std.jstd.sp.bean.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("do event");
        System.out.println(demoEvent.getMsg());
    }
}
