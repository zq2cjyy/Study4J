package luzq.std.jstd.sp.service.demo;

import luzq.std.jstd.sp.bean.condition.SystemBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("condition")
public class ConditionDemo implements DemoService {
    @Autowired
    SystemBean systemBean;

    @Override
    public void run() {
        systemBean.printName();
    }
}
