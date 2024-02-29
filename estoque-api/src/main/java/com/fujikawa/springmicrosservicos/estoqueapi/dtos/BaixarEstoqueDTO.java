package com.fujikawa.springmicrosservicos.estoqueapi.dtos;

import java.util.UUID;

public record BaixarEstoqueDTO(UUID idProduto, Integer quantidade) {

}
