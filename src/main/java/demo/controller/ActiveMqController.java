package demo.controller;

import demo.service.MsgProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;

@RestController
@Slf4j
public class ActiveMqController {

    @Resource
    private MsgProducer producer;

    @Resource
    private Destination queue;

    @GetMapping("/send/queue")
    public String sendQueueMessage() {

        log.info("===开始发送点对点消息===");
        producer.sendMessage(queue, "Queue: hello activemq!");
        return "success";
    }
}
