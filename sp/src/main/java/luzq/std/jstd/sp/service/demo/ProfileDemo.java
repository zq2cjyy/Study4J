package luzq.std.jstd.sp.service.demo;

import luzq.std.jstd.sp.bean.ProfileBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("profile")
public class ProfileDemo implements DemoService {

    @Autowired
    ProfileBean profileBean;

    @Override
    public void run() {
        System.out.println(profileBean.getId());
        System.out.println(profileBean.getName());
    }
}
