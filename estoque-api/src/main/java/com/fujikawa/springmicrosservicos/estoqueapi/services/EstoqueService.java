package com.fujikawa.springmicrosservicos.estoqueapi.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.fujikawa.springmicrosservicos.estoqueapi.dtos.BaixarEstoqueDTO;
import com.fujikawa.springmicrosservicos.estoqueapi.dtos.EstoqueBaixadoDTO;

@Service
public class EstoqueService {

    public EstoqueBaixadoDTO baixarEstoque(BaixarEstoqueDTO dto) {

        var estoqueAnterior = new Random().nextInt(50,100);

        return new EstoqueBaixadoDTO(estoqueAnterior, estoqueAnterior - dto.quantidade());
    }
}
