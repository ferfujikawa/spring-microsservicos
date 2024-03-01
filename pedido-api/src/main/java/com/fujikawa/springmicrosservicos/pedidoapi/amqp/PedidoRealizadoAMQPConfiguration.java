package com.fujikawa.springmicrosservicos.pedidoapi.amqp;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoRealizadoAMQPConfiguration {

    private String exchange;

    public PedidoRealizadoAMQPConfiguration(
        @Value("${app.rabbitmq.pedidoRealizado.exchange}") String exchange) {

        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(exchange);
    }
}
