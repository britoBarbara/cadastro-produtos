# 📦 Sistema de Cadastro de Produtos

[![Java](https://img.shields.io/badge/Java-22-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Apache%20Maven-3.9+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)]()

Aplicação desktop desenvolvida em **Java** com interface gráfica construída com **Java Swing (`JOptionPane`)** para gerenciamento e cadastro de produtos e suas respectivas categorias. 

O projeto foi elaborado com fins educacionais para aplicação prática de conceitos de **Programação Orientada a Objetos (POO)**, arquitetura em camadas e manipulação de coleções de dados em memória.

---

## 🚀 Funcionalidades

- [x] **Cadastro de Categorias**: Criação de categorias com validação contra duplicidade.
- [x] **Cadastro de Produtos**: Registro de novos produtos vinculados a categorias existentes, com validação de campos obrigatórios e preço positivo.
- [x] **Alteração de Produtos**: Seleção e atualização de produtos cadastrados.
- [x] **Consulta de Produtos por Categoria**: Filtragem e exibição detalhada de produtos pertencentes a uma categoria específica.
- [ ] **Consulta de Produtos por ID**: *(Opção de menu mapeada, com implementação planejada)*.
- [x] **Carga Inicial de Dados (Mock)**: Categorias e produto base inicializados em memória para agilizar os testes da aplicação.

---

## 🛠️ Tecnologias e Recursos

- **Java 22**: Utilização de recursos modernos da linguagem (pattern matching para `switch`, métodos encadeados/fluent setters, `java.time.LocalDateTime`, `BigDecimal`).
- **Apache Maven**: Gerenciamento de ciclo de vida e compilação do projeto.
- **Java Swing (`javax.swing.JOptionPane`)**: Janelas modais e caixas de diálogo para interação com o usuário.
- **Java Collections API (`Vector`, `List`, `Streams`)**: Armazenamento e filtragem de objetos em memória.

---

## 📂 Estrutura do Projeto

O código-fonte está estruturado sob o pacote base `br.com.cadastro`, separando responsabilidades:

```text
src/
└── main/
    └── java/
        └── br/com/cadastro/
            ├── Main.java               # Classe principal e controle de fluxo do menu
            │
            ├── model/                  # Entidades de domínio (POJOs)
            │   ├── Categoria.java      # Representação de uma categoria (id, nome)
            │   └── Produto.java        # Representação de um produto
            │
            ├── repository/             # Camada de persistência em memória
            │   ├── CategoriaCollectionRepository.java
            │   └── ProdutoCollectionRepository.java
            │
            └── view/                   # Camada de apresentação e interface gráfica
                ├── Opcao.java          # Enum com as ações do menu
                ├── OpcaoView.java      # Caixa de seleção do menu principal
                ├── CategoriaView.java  # Formulários e avisos para categoria
                └── ProdutoView.java    # Formulários, validações e exibição de produto
```

---

## 📋 Pré-requisitos

Antes de iniciar, verifique se você possui instalado:
- **[JDK 22](https://www.oracle.com/java/technologies/downloads/)** ou superior
- **[Apache Maven](https://maven.apache.org/)** (opcional caso utilize uma IDE com Maven integrado)
- Uma IDE de sua escolha (ex: IntelliJ IDEA, VS Code com Java Extension Pack, Eclipse)

---

## 🔧 Como Executar

### 1. Clonar o repositório
```bash
git clone https://github.com/SEU_USUARIO/cadastro-produto.git
cd cadastro-produto
```

### 2. Executar via IDE (Recomendado)
1. Abra o projeto na sua IDE favorita.
2. Aguarde a sincronização das dependências do Maven.
3. Navegue até o arquivo `src/main/java/br/com/cadastro/Main.java`.
4. Execute o método `main()`.

### 3. Executar via Terminal (Maven)
Compile o projeto e inicie a classe principal:
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="br.com.cadastro.Main"
```

---

## 🗺️ Roadmap de Melhorias

- [ ] Migrar a persistência em memória para banco de dados relacional (H2, PostgreSQL ou MySQL) via JDBC ou JPA/Hibernate.
- [ ] Adicionar testes unitários com JUnit 5.

---

## 📄 Licença

Este projeto é de uso livre para fins acadêmicos e de aprendizado.
