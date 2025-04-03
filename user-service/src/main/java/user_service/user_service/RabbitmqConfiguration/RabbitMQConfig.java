package user_service.user_service.RabbitmqConfiguration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    // Define Queue
    @Bean
    public Queue queue() {
        return new Queue(queueName, true); // true = durable queue
    }

    // Define Exchange
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }

    // Define Binding between Queue and Exchange using Routing Key
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
