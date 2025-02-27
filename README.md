# 🧾 Tax Calculator API

Este é um projeto simples criado com Spring Boot para demonstrar como funciona o padrão de design **Strategy**. A ideia principal é calcular diferentes tipos de impostos de forma flexível, permitindo a extensão fácil de novos tipos de impostos sem modificar a lógica existente.

## Objetivos

- **Praticar o padrão de design Strategy**: Demonstrar como usar este padrão para implementar cálculos de impostos de maneira extensível.
- **Cálculo de impostos**: A API oferece o cálculo de diferentes tipos de impostos com base em uma solicitação simples.
- **Mock de dados**: Utiliza dados simulados para realizar os cálculos, sem necessidade de um banco de dados.

## Arquitetura do Projeto

O projeto está organizado em camadas para manter uma estrutura limpa e modular:

### Estrutura de Pastas
```plaintext
tax-calculator
 └── src/main/java/com/sirkaue/taxcalculatorapistrategy
     ├── controller/                # Controlador da API
     │   └── TaxController.java
     ├── dto/                       # Objetos de transferência de dados (DTOs)
     │   ├── TaxRequestDto.java
     │   └── TaxResponseDto.java
     ├── service/                   # Regras de negócio
     │   └── TaxServiceImpl.java
     ├── strategy/                  # Implementação do Strategy Pattern
     │   ├── context/               # Contexto da estratégia
     │   │   ├── TaxContext.java
     │   │   └── TaxContextImpl.java
     │   ├── tax/                   # Estratégias de cálculo de impostos
     │   │   ├── TaxStrategy.java
     │   │   ├── ICMSStrategy.java
     │   │   ├── ISSStrategy.java
     │   │   └── IRStrategy.java
     └── TaxCalculatorApplication.java  # Classe principal
 └── resources/
     └── application.properties  # Configurações do Spring Boot
```

## Componentes Principais

### Controller:
- **TaxController**: Exponibiliza os endpoints da API para o cálculo de impostos.

### DTOs (Data Transfer Objects):
- **TaxRequestDto**: Contém os dados de entrada, como o tipo de imposto e o valor.
- **TaxResponseDto**: Contém os dados de saída, incluindo o valor do imposto calculado.

### Service:
- **TaxService**: Interface que define as operações relacionadas ao cálculo de impostos.
- **TaxServiceImpl**: Implementação da interface de cálculo de impostos, que utiliza o padrão **Strategy** para delegar o cálculo conforme o tipo de imposto.

### Strategy:
- **Context**:
    - **TaxContext**: Interface para gerenciar as estratégias de imposto.
    - **TaxContextImpl**: Implementação do contexto que seleciona a estratégia apropriada.
- **Tax**:
    - **TaxStrategy**: Interface que define o contrato para calcular o imposto.
    - **ICMSStrategy**, **ISSStrategy**, **IRStrategy**: Implementações específicas de impostos com suas respectivas taxas.

### Aplicativo Principal:
- **TaxCalculatorApplication**: Classe principal que inicializa o aplicativo Spring Boot.

---

## Endpoints Disponíveis

### 📌 Calcular imposto
**`POST /tax/calculate`**  
Calcula um imposto com base no tipo e no valor fornecido.

📥 **Requisição (JSON)**
```json
{
  "taxType": "ICMS",
  "amount": 1000
}
```
📥 **Resposta (JSON)**
```json
{
  "taxType": "ICMS",
  "amount": 1000,
  "taxValue": 170
}
```

### Tipos de imposto suportados:
- **ICMS**: → 17%
- **ISS**: → 5%
- **IR**: → 27.5%

---

## Como Executar o Projeto

### Pré-requisitos:
- Java 17+
- Maven

### Clonar o repositório:
```bash
git clone https://github.com/sirkaue/tax-calculator-api-strategy.git
```

## Conclusão

Este projeto é um exemplo prático de como aplicar o padrão **Strategy** em uma aplicação com **Spring Boot**. Ele demonstra como calcular diferentes impostos de forma modular e flexível, permitindo fácil extensão para novos tipos de impostos.

Sinta-se à vontade para expandir este projeto, adicionando novos tipos de impostos, melhorias no design ou integração com outras fontes de dados!
