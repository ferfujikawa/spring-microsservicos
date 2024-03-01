package com.fujikawa.springmicrosservicos.estoqueapi.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.fujikawa.springmicrosservicos.estoqueapi.dtos.BaixarEstoqueDTO;

@Service
public class EstoqueService {

    public void baixarEstoque(BaixarEstoqueDTO dto) {

        var estoqueAnterior = new Random().nextInt(50,100);
        var estoqueAtual = estoqueAnterior - dto.quantidade();

        System.out.printf(
            "Estoque do produto de id '%s' baixado de %d para %d\n",
            dto.idProduto(),
            estoqueAnterior,
            estoqueAtual);
    }
}
