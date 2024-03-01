package com.fujikawa.springmicrosservicos.estoqueapi.dtos;

import java.util.UUID;

public record PedidoItemDTO(UUID idProduto, String nomeProduto, Integer quantidade) {

}
