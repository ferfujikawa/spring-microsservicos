package com.fujikawa.springmicrosservicos.pedidoapi.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fujikawa.springmicrosservicos.pedidoapi.dtos.PedidoItemDTO;
import com.fujikawa.springmicrosservicos.pedidoapi.dtos.PedidoRealizadoDTO;
import com.fujikawa.springmicrosservicos.pedidoapi.dtos.RegistrarPedidoDTO;

@Service
public class PedidoService {

    public PedidoRealizadoDTO realizarPedido(RegistrarPedidoDTO dto) {

        var pedidoRealizado = new PedidoRealizadoDTO(
            UUID.randomUUID(),
            dto.cliente(),
            dto.itens()
                .stream()
                .map(i -> new PedidoItemDTO(i.idProduto(), "Produto " + i.idProduto(), i.quantidade()))
                .toList()
        );

        return pedidoRealizado;
    }
}
