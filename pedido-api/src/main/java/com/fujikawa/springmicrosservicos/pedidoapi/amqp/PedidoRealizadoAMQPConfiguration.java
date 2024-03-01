package com.fujikawa.springmicrosservicos.pedidoapi.amqp;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoRealizadoAMQPConfiguration {

    private String pedidoRealizadoExchange;

    public PedidoRealizadoAMQPConfiguration(@Value("${exchanges.pedidoRealizado}") String pedidoRealizadoExchange) {
        this.pedidoRealizadoExchange = pedidoRealizadoExchange;
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(pedidoRealizadoExchange);
    }
}
