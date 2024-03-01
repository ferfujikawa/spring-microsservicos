package com.fujikawa.springmicrosservicos.estoquems.dtos;

import java.util.UUID;

public record PedidoItemDTO(UUID idProduto, String nomeProduto, Integer quantidade) {

}
