package com.fujikawa.springmicrosservicos.estoquems.dtos;

import java.util.UUID;

public record BaixarEstoqueDTO(UUID idProduto, Integer quantidade) {

}
