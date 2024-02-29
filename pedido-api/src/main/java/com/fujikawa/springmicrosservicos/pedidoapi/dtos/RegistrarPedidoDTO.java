package com.fujikawa.springmicrosservicos.pedidoapi.dtos;

import java.time.LocalDate;
import java.util.List;

public record RegistrarPedidoDTO(String cliente, LocalDate data, List<RegistrarPedidoItemDTO> itens) {

}
