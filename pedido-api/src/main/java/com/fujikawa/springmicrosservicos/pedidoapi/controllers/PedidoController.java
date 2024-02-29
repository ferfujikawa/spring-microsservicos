package com.fujikawa.springmicrosservicos.pedidoapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fujikawa.springmicrosservicos.pedidoapi.dtos.PedidoRealizadoDTO;
import com.fujikawa.springmicrosservicos.pedidoapi.dtos.RegistrarPedidoDTO;
import com.fujikawa.springmicrosservicos.pedidoapi.services.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoRealizadoDTO> registrarPedido(
        @RequestBody RegistrarPedidoDTO pedido) {
        
        var pedidoRealizado = pedidoService.realizarPedido(pedido);
        
        return ResponseEntity.ok().body(pedidoRealizado);
    }
    
}
