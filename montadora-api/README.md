# Montadora API 🚗

Este projeto é uma API REST para simular o gerenciamento de motores e carros de montadoras, desenvolvida com **Spring Boot**.

## ✨ Funcionalidades
- 🚗 **Ligar o Carro**: `POST /cars/{engineType}`  
  - Liga um carro com o tipo de motor especificado (`NATURALLY_ASPIRATED`, `TURBO`, `ELECTRIC`).
- 🔍 **Buscar Motor por Tipo**: Configuração automática para identificar motores pelo tipo informado.
- ⚙️ **Validações Internas**: 
  - Garante que o motor informado seja válido.
  - Verifica se a chave usada corresponde ao fabricante do carro.

## Tecnologias Utilizadas
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **H2 Database** (para testes locais)
- **Postman** (para testes de API)
