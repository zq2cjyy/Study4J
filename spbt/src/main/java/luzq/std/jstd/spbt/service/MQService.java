package luzq.std.jstd.spbt.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 示例基于rabbitmq的docker镜像,执行如下命令启动环境
 * sudo docker pull rabbitmq
 * sudo docker pull rabbitmq:3-management
 * sudo docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:3-management
 */
@Service
public class MQService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendToRabbit(String msg) {
        rabbitTemplate.convertAndSend("luzq-queue", msg);
    }
}
