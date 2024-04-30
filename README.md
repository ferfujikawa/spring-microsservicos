# Spring Microsserviços

Projeto composto de vários subprojetos para prática de conceitos de arquitetura de microsserviços contendo API Gateway e Service Registry.

## Como executar a aplicação

Apenas execute o seguinte comando para subir os containers:

```bash
docker compose up
```

## URLs

- http://localhost:8081 = Servidor Eureka (onde as APIs e o Gateway são registrados).
- http://localhost:15672 = Interface de gerenciamento do RabbitMQ (usuário admin e senha admin).
- http://localhost:8082 = API Gateway.

> Comandos curl para acesso ao endpoint de cadastro de pedidos apresentado abaixo.

Exemplo de cadastro de pedido:
```bash
curl -i -X POST http://localhost:8082/pedidos-ms/pedidos
  -H 'Content-Type: application/json'
  -d $'{
        "cliente": "Cliente 1",
        "data": "2024-04-30T13:50:23",
        "itens": [
            {
                "idProduto": "cc4adcd2-2dec-4d2f-abab-1548de047565",
                "nomeProduto": "Produto 1",
                "quantidade": 10
            }
        ]
    }'
```

## Comportamento da aplicação

- Acessando o servidor Eureka em http://localhost:8081, você poderá visualizar os serviços se registrando nele.
- Conforme as requisições de pedido são realizadas, `pedido-api` envia os dados do pedido para uma fila do RabbitMQ.
- O serviço `estoque-ms` consome a fila do RabbitMQ, simula um processamento de baixa de estoque e imprime uma mensagem com dados da baixa e situação do estoque do produto.
- Acesse o log do container `estoque-ms` para visualizar as mensagens produzidas de acordo com o consumo de filas do RabbitMQ.
> Para acessar o log do container, utilize o comando ```bash docker logs estoque-ms -f```.
> Exemplo de mensagem exibida no log do container estoque-ms: `Estoque do produto de id 'cc4adcd2-2dec-4d2f-abab-1548de047565' baixado de 76 para 66`
