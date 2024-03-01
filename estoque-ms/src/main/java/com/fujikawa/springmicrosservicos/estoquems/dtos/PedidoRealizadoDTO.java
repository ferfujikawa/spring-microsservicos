package com.fujikawa.springmicrosservicos.estoquems.dtos;

import java.util.List;
import java.util.UUID;

public record PedidoRealizadoDTO(UUID id, String cliente, List<PedidoItemDTO> itens) {

}

