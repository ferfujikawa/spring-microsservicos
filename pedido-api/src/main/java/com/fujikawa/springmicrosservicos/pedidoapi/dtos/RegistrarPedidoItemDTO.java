package com.fujikawa.springmicrosservicos.pedidoapi.dtos;

import java.util.UUID;

public record RegistrarPedidoItemDTO(UUID idProduto, Integer quantidade) {

}

