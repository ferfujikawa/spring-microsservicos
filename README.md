# Spring Microsserviços

Projeto composto de vários subprojetos para prática de arquitetura de microsserviços contendo API Gateway e Service Registry.

## URLs

- http://localhost:8081 = Servidor Eureka.
- http://localhost:8082/pedidos-ms = Home da API de pedidos.
- http://localhost:8082/estoque-ms = Home da API de estoque.

## Requisitos

Os projetos `pedidos-api` e `estoque-ms` necessitam de um servidor RabbitMQ na porta padrão (5672) para funcionamento.

> Você pode criar um container Docker com o RabbitMQ utilizando o `docker-compose.yml` presente no diretório `docker`.
