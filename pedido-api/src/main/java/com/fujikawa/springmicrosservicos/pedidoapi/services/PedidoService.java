package com.fujikawa.springmicrosservicos.pedidoapi.services;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fujikawa.springmicrosservicos.pedidoapi.dtos.PedidoItemDTO;
import com.fujikawa.springmicrosservicos.pedidoapi.dtos.PedidoRealizadoDTO;
import com.fujikawa.springmicrosservicos.pedidoapi.dtos.RegistrarPedidoDTO;

@Service
public class PedidoService {

    private RabbitTemplate rabbitTemplate;
    private String pedidoRealizadoExchange;

    public PedidoService(
        RabbitTemplate rabbitTemplate,
        @Value("${exchanges.pedidoRealizado}") String pedidoRealizadoExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.pedidoRealizadoExchange = pedidoRealizadoExchange;
    }

    public PedidoRealizadoDTO realizarPedido(RegistrarPedidoDTO dto) {

        var pedidoRealizado = new PedidoRealizadoDTO(
            UUID.randomUUID(),
            dto.cliente(),
            dto.itens()
                .stream()
                .map(i -> new PedidoItemDTO(i.idProduto(), "Produto " + i.idProduto(), i.quantidade()))
                .toList()
        );

        enviarParaRabbit(pedidoRealizado);

        return pedidoRealizado;
    }

    private void enviarParaRabbit(PedidoRealizadoDTO pedidoRealizado) {
        
        rabbitTemplate.convertAndSend(pedidoRealizadoExchange, "", pedidoRealizado);
    }
}
