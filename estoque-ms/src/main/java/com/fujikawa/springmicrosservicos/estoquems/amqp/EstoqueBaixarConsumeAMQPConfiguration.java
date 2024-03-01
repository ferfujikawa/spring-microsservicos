package com.fujikawa.springmicrosservicos.estoquems.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstoqueBaixarConsumeAMQPConfiguration {

    private String exchange;
    private String queue;

    public EstoqueBaixarConsumeAMQPConfiguration(
        @Value("${app.rabbitmq.estoqueBaixar.exchange}") String exchange,
        @Value("${app.rabbitmq.estoqueBaixar.queue}") String queue) {

        this.exchange = exchange;
        this.queue = queue;
    }

    public String getExchange() {
        return exchange;
    }

    public String getQueue() {
        return queue;
    }

    @Bean
    public Queue fila() {

        return QueueBuilder
            .nonDurable(queue)
            .build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {

        return ExchangeBuilder
            .fanoutExchange(exchange)
            .build();
    }

    @Bean
    public Binding binding() {

        return BindingBuilder
            .bind(fila())
            .to(fanoutExchange());
    }
}
