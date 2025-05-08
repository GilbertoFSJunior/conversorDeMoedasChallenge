# 💱 Conversor de Moedas em Java

> Projeto desenvolvido como desafio prático de programação em Java, com foco no consumo de APIs, manipulação de JSON e construção de interface textual interativa via console.

---

## 📌 Descrição

Neste emocionante desafio de programação, construímos um **Conversor de Moedas** com **interação via terminal**, utilizando **taxas de câmbio em tempo real** obtidas através de uma API pública.

Durante o desenvolvimento, o projeto proporcionou a prática dos seguintes conceitos fundamentais em Java:

- Criação de projetos orientados a objetos;
- Leitura e interpretação de **JSON** usando a biblioteca **Gson**;
- Consumo de **API REST** com `HttpClient`;
- Criação de menus interativos no console com `Scanner`;
- Tratamento de erros e exceções (`try/catch`);
- Boas práticas de estruturação e organização de código.

---

## 🎯 Objetivo

> Desenvolver um conversor de moedas com no mínimo **6 opções de conversão diferentes**, com valores atualizados **dinamicamente** através de uma API.

O sistema deve apresentar:

- Menu textual com as opções de conversão;
- Entrada do valor a ser convertido;
- Exibição do resultado da conversão com precisão de duas casas decimais;
- Tratamento de entradas inválidas;
- Uso da **[ExchangeRate API](https://www.exchangerate-api.com/)** para obter os dados em tempo real.

---

## 🧱 Estrutura do Projeto

```bash
conversor/
│
├── Main.java                 # Classe principal (menu e interação com o usuário)
├── CurrencyConverter.java    # Lógica de conversão e validações
├── ApiClient.java            # Conexão com a API e parsing do JSON
└── lib/
    └── gson-<versão>.jar     # Biblioteca Gson para manipulação JSON

```

## 🚀 Tecnologias e Recursos Utilizados

| Tecnologia       | Descrição                                              |
| ---------------- | ------------------------------------------------------ |
| Java 17+         | Linguagem principal do projeto                         |
| Gson             | Biblioteca para trabalhar com JSON (`com.google.gson`) |
| HttpClient       | Para fazer requisições HTTP à API                      |
| ExchangeRate API | API gratuita para taxas de câmbio atualizadas          |
| Scanner (Java)   | Para entrada de dados no terminal                      |
| Try/Catch        | Tratamento de exceções e validações                    |


## 📦 Funcionalidades Implementadas
- ✅ Menu com mais de 6 pares de moedas disponíveis;

- ✅ Conversões: USD ⇄ BRL, EUR ⇄ BRL, BRL ⇄ ARS, BRL ⇄ BOB, BRL ⇄ CLP, BRL ⇄ COP;

- ✅ Requisição HTTP à API de câmbio;

- ✅ Parsing da resposta JSON;

- ✅ Cálculo e exibição do valor convertido;

- ✅ Interface via terminal amigável;

- ✅ Tratamento de erros (moeda inválida, valor incorreto, falha na API, etc).

## 🧪 Exemplos de Uso

### $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
#### Conversor de Moedas
### $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

1 - USD para BRL
2 - BRL para USD
3 - USD para EUR
4 - EUR para USD
5 - BRL para EUR
6 - EUR para BRL
...

Escolha uma opção: 1
Digite o valor a ser convertido: 100

+------------------------------------------+
| 100.00 USD = 507.53 BRL                  |
+------------------------------------------+


### 🗃️ Organização das Tarefas com Trello

O desenvolvimento foi gerenciado utilizando uma board no Trello, com as seguintes colunas:

- Pronto pra iniciar: tarefas ainda não iniciadas;

- Desenvolvendo: tarefas em andamento;

- Pausado: tarefas interrompidas temporariamente;

- Concluído: tarefas finalizadas com sucesso.

## ⚙️ Dependências
 - Gson (para parsear JSON)

A dependência pode ser adicionada via Maven, Gradle, ou utilizando o .jar manualmente.

## 🧠 Aprendizados
Este projeto proporcionou uma experiência prática rica, reforçando:

- A importância de trabalhar com dados dinâmicos via API;

- A manipulação eficiente de estruturas JSON;

- A modularização do código em classes especializadas;

- O desenvolvimento de programas robustos com tratamento de falhas;

- A aplicação de lógica de programação em contextos reais.


