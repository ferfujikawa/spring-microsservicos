package com.fujikawa.springmicrosservicos.estoquems.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fujikawa.springmicrosservicos.estoquems.dtos.BaixarEstoqueDTO;
import com.fujikawa.springmicrosservicos.estoquems.dtos.PedidoRealizadoDTO;
import com.fujikawa.springmicrosservicos.estoquems.services.EstoqueService;

@Component
public class EstoqueBaixarListener {

    private EstoqueService estoqueService;

    public EstoqueBaixarListener(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @RabbitListener(queues = "#{fila.name}")
    public void receberMensagem(PedidoRealizadoDTO pedido) {

        pedido.itens().forEach(i -> estoqueService.baixarEstoque(new BaixarEstoqueDTO(i.idProduto(), i.quantidade())));
    }
}
