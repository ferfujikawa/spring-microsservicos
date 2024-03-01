# Spring Microsserviços

Projeto composto de vários subprojetos para prática de conceitos de arquitetura de microsserviços contendo API Gateway e Service Registry.

## URLs

- http://localhost:8081 = Servidor Eureka (onde as APIs e o Gateway são registrados).
- http://localhost:8082/pedidos-ms = Home da API de pedidos via Gateway (contém endpoint POST para realização de pedidos, enviando uma mensagem de pedido realizado para uma *exchange* do RabbitMQ).
- http://localhost:8082/estoque-ms = Home da API de estoque via Gateway (contém um *listener* para recebimento de mensagens da *exchange* onde a API de pedidos faz envio).

## Requisitos

Os projetos `pedidos-api` e `estoque-ms` necessitam de um servidor RabbitMQ na porta padrão (5672) para funcionamento.

> Você pode criar um container Docker com o RabbitMQ utilizando o `docker-compose.yml` presente no diretório `docker`.
