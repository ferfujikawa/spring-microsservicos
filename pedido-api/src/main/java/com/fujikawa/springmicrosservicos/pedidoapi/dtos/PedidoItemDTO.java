package com.fujikawa.springmicrosservicos.pedidoapi.dtos;

import java.util.UUID;

public record PedidoItemDTO(UUID idProduto, String nomeProduto, Integer quantidade) {

}
