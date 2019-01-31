package luzq.std.jstd;

import luzq.std.jstd.sp.bean.condition.LinuxBean;
import luzq.std.jstd.sp.bean.condition.SystemBean;
import luzq.std.jstd.sp.config.MainConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class})
@ActiveProfiles("prod")
public class AppTest {
    @Autowired
    SystemBean systemBean;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testCondition() {
        systemBean.printName();
        assertTrue(systemBean instanceof LinuxBean);
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<>();
        list.add("lu zhi qiang");
        list.add("chen jing");
        list.add("2gui");
        list.add("3gui");
        String key = "lu";
        String keyplus = " zhi qiang";
        assertTrue(list.contains(key + keyplus));
    }
}
