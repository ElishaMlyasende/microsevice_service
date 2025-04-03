package user_service.user_service.RABBITMQ_PUBLISHER;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String RoutingKey;

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    // create constructor
    public MessageProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }
    public void sendMessage( String message){
        rabbitTemplate.convertAndSend(exchange,RoutingKey,message);
    }
}
