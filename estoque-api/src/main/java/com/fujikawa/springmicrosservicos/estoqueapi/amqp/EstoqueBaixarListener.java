package com.fujikawa.springmicrosservicos.estoqueapi.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fujikawa.springmicrosservicos.estoqueapi.dtos.BaixarEstoqueDTO;
import com.fujikawa.springmicrosservicos.estoqueapi.dtos.PedidoRealizadoDTO;
import com.fujikawa.springmicrosservicos.estoqueapi.services.EstoqueService;

@Component
public class EstoqueBaixarListener {

    private EstoqueService estoqueService;

    public EstoqueBaixarListener(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @RabbitListener(queues = "estoque.baixar")
    public void receberMensagem(PedidoRealizadoDTO pedido) {

        pedido.itens().forEach(i -> {
            var estoqueBaixado = estoqueService.baixarEstoque(new BaixarEstoqueDTO(i.idProduto(), i.quantidade()));
            
            System.out.printf(
                "Estoque do produto '%s' baixado de %d para %d\n",
                i.nomeProduto(),
                estoqueBaixado.estoqueAnterior(),
                estoqueBaixado.estoqueAtual());
        });
    }
}
