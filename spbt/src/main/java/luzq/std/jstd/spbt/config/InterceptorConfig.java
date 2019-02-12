package luzq.std.jstd.spbt.config;

import luzq.std.jstd.spbt.interceptor.AppInterceptor;
import luzq.std.jstd.spbt.interceptor.PerformanceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AppInterceptor appInterceptor;
    @Autowired
    PerformanceInterceptor performanceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(performanceInterceptor);
        registry.addInterceptor(appInterceptor).addPathPatterns("/testjson");
    }
}
