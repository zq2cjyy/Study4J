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
}
