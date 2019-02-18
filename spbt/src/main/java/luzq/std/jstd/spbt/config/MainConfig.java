package luzq.std.jstd.spbt.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;

@Configuration
public class MainConfig {

    @Bean
    public HttpMessageConverters fastJsonConvert() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        config.setCharset(Charset.forName("UTF-8"));

        converter.setFastJsonConfig(config);

        HttpMessageConverter<?> httpMessageConverter = converter;
        return new HttpMessageConverters(httpMessageConverter);
    }

    @Bean
    public Queue rabbitSender() {
        return new Queue("luzq-queue");
    }
}
