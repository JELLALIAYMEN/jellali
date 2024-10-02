package com.example.websocketchatapp.Consumer;

import lombok.Value;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private String queueName;

       private String exchange;


    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);  // Assurez-vous que la file d'attente est durable
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(routingKey);
    }
}
