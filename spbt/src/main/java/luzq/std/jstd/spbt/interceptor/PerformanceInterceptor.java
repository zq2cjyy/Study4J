package luzq.std.jstd.spbt.interceptor;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PerformanceInterceptor implements HandlerInterceptor {
//    private static Logger logger = (Logger) LoggerFactory.getLogger(PerformanceInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入请求之前
        request.setAttribute("curtime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //处理请求之后
        long curtime = (long) request.getAttribute("curtime");
        String log = "耗时" + (System.currentTimeMillis() - curtime);
        Logger logger = (Logger) LoggerFactory.getLogger(PerformanceInterceptor.class);
        logger.info(log);
        System.out.println(log);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完成
        System.out.println("afterCompletion");
    }
}
