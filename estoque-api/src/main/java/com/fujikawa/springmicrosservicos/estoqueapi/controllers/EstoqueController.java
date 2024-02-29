package com.fujikawa.springmicrosservicos.estoqueapi.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.fujikawa.springmicrosservicos.estoqueapi.dtos.BaixarEstoqueDTO;
import com.fujikawa.springmicrosservicos.estoqueapi.dtos.EstoqueBaixadoDTO;
import com.fujikawa.springmicrosservicos.estoqueapi.services.EstoqueService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    private EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PutMapping("baixar")
    public ResponseEntity<EstoqueBaixadoDTO> baixarEstoque(@RequestBody BaixarEstoqueDTO dto) {
               
        var retorno = estoqueService.baixarEstoque(dto);
        return ResponseEntity.ok().body(retorno);
    }
}
