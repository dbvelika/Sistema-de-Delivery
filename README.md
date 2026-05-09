# 🍔 Sistema de Delivery

Sistema de gerenciamento de delivery desenvolvido em **Java**, com foco em organização de pedidos, restaurantes e produtos.  
O projeto está sendo construído como parte de estudos em **Análise e Desenvolvimento de Sistemas**, aplicando conceitos de programação orientada a objetos, banco de dados e arquitetura em camadas.

---

## 📌 Status do Projeto

🚧 Em desenvolvimento  

Atualmente, o sistema está em evolução, com foco na modelagem das entidades, integração com banco de dados e implementação das regras de negócio.

---

## 🎯 Objetivo

Desenvolver um sistema capaz de gerenciar o fluxo básico de um delivery, incluindo:

- Cadastro de restaurantes  
- Cadastro de produtos vinculados a restaurantes  
- Gerenciamento de pedidos  
- Controle de estoque básico  
- Integração com banco de dados  

---

## 🛠️ Tecnologias Utilizadas

- **Java**
- **JDBC**
- **MySQL** (ou outro banco relacional)
- **Git & GitHub**
- **UML**

---

## 🧠 Conceitos Aplicados

- Programação Orientada a Objetos (POO)  
- Arquitetura em camadas (DAO, Model, Service)  
- CRUD (Create, Read, Update, Delete)  
- Relacionamento entre entidades (ex: Produto → Restaurante)  
- Validação de dados  
- Integração com banco de dados  

---

## 📂 Estrutura do Projeto (parcial)

```bash
src/
├── model/       # Classes de entidade (Produto, Restaurante, Pedido)
├── dao/         # Acesso ao banco de dados
├── service/     # Regras de negócio
└── database/    # Conexão com o banco
