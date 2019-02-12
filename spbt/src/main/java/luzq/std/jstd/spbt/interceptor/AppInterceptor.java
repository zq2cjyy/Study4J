package luzq.std.jstd.spbt.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

/**
 * 拦截_appid参数
 */
@Component
public class AppInterceptor implements HandlerInterceptor {
    private static Set<String> appids;

    static {
        appids = new HashSet<>();
        appids.add("app.id");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String appid = request.getParameter("_appid");
        if (null == appid || "".equals(appid)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().print("没有_appid");
            return false;
        }
        if (!appids.contains(appid)) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().print("无效_appid");
            return false;
        }
        return true;
    }
}
