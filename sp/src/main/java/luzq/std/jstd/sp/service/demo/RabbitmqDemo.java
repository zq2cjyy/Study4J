package luzq.std.jstd.sp.service.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Rabbitmq示例
 * 需要开启SpringBoot的自动配置
 * 采用默认配置 如果手动配置Rabbitmq参数 参考https://www.cnblogs.com/hlhdidi/p/6535677.html
 * 示例基于rabbitmq的docker镜像,执行如下命令启动环境
 * sudo docker pull rabbitmq
 * sudo docker pull rabbitmq:3-management
 * sudo docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:3-management
 */
@Service("rabbitmq")
public class RabbitmqDemo implements DemoService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void run() {
        System.out.println("程序正在执行...");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"exit".equals(input = scanner.nextLine())) {
            rabbitTemplate.convertAndSend("luzq-queue", input);
            System.out.println("Send:" + input);
        }
    }

    @RabbitListener(queues = "luzq-queue")
    public void receiveMsg(String msg) {
        System.out.println("Receive:" + msg);
    }
}
