package demo.service;

import demo.config.ActiveMqConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumer {
    /**
     * 接收点对点消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)
    public void receiveQueueMsg(String msg) {
        System.out.println("收到的消息为：" + msg);
    }
}
