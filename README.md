# API Documentação

## Introdução

Esta API foi desenvolvida para o gerenciamento completo de uma hamburgueria, facilitando o controle de pedidos, produtos, pagamentos e usuários. Ela permite que a equipe administre o catálogo de produtos, registre pedidos de clientes, processe pagamentos e gerencie o cadastro de usuários, incluindo a criação de moderadores com permissões especiais.

Com uma arquitetura robusta baseada em Spring Boot e segurança implementada com JWT, a API garante um fluxo seguro e eficiente para operações diárias, desde a criação de novos itens do menu até a finalização de pedidos e pagamentos.


## Endpoints

---

### `/endereco`

- **Method**: `POST`
- **Summary**: "Criar endereço para usuário."
- **Responses**: 
  - `200`: OK

---

### `/endereco/{id}`

- **Method**: `PUT`
- **Summary**: "Atualizar endereço do usuário."
- **Parameters**:
  - `id`: "ID do usuário para atualizar o endereço."
- **Responses**: 
  - `200`: OK

---

### `/itemPedido`

- **Method**: `GET`
- **Summary**: "Ver os itens pedidos."
- **Responses**: 
  - `200`: OK

- **Method**: `POST`
- **Summary**: "Criar os itens pedidos."
- **Responses**: 
  - `200`: OK

---

### `/login`

- **Method**: `POST`
- **Summary**: "Realizar login, disponível apenas para usuários moderadores."
- **Responses**: 
  - `200`: OK

---

### `/pagamento`

- **Method**: `POST`
- **Summary**: "Criar pagamento."
- **Responses**: 
  - `200`: OK

---

### `/pagamento/{id}`

- **Method**: `PUT`
- **Summary**: "Atualizar status do pagamento de falso para verdadeiro."
- **Parameters**:
  - `id`: "ID do pagamento a ser atualizado."
- **Responses**: 
  - `200`: OK

---

### `/pedido`

- **Method**: `POST`
- **Summary**: "Criar pedido."
- **Responses**: 
  - `200`: OK

---

### `/pedido/{id}`

- **Method**: `PUT`
- **Summary**: "Atualizar pedido."
- **Parameters**:
  - `id`: "ID do pedido a ser atualizado."
- **Responses**: 
  - `200`: OK

- **Method**: `DELETE`
- **Summary**: "Deletar pedido pelo ID."
- **Parameters**:
  - `id`: "ID do pedido a ser deletado."
- **Responses**: 
  - `200`: OK

---

### `/produto`

- **Method**: `GET`
- **Summary**: "Ver todos os produtos."
- **Responses**: 
  - `200`: OK

- **Method**: `POST`
- **Summary**: "Criar produtos."
- **Responses**: 
  - `200`: OK

---

### `/produto/{id}`

- **Method**: `GET`
- **Summary**: "Ver produto pelo ID."
- **Parameters**:
  - `id`: "ID do produto."
- **Responses**: 
  - `200`: OK

- **Method**: `PUT`
- **Summary**: "Atualizar produto."
- **Parameters**:
  - `id`: "ID do produto a ser atualizado."
- **Responses**: 
  - `200`: OK

- **Method**: `DELETE`
- **Summary**: "Deletar produto pelo ID."
- **Parameters**:
  - `id`: "ID do produto a ser deletado."
- **Responses**: 
  - `200`: OK

---

### `/usuario`

- **Method**: `GET`
- **Summary**: "Ver todos os usuários."
- **Responses**: 
  - `200`: OK

- **Method**: `POST`
- **Summary**: "Criar usuários não moderadores."
- **Responses**: 
  - `200`: OK

---

### `/usuario/moderator`

- **Method**: `POST`
- **Summary**: "Criar usuários moderadores."
- **Responses**: 
  - `200`: OK

---

### `/usuario/{id}`

- **Method**: `DELETE`
- **Summary**: "Deletar usuário pelo ID, também deleta o endereço."
- **Parameters**:
  - `id`: "ID do usuário a ser deletado."
- **Responses**: 
  - `200`: OK

---

# Dependências do Projeto

Este projeto utiliza as seguintes dependências:

- **spring-boot-starter-validation**: Fornece suporte para validação de dados no Spring Boot.
- **spring-boot-starter-web**: Facilita o desenvolvimento de APIs RESTful e aplicações web.
- **flyway-core**: Gerenciamento de versões de banco de dados com migrações.
- **spring-boot-starter-data-jpa**: Integração do Spring Boot com JPA para manipulação de dados.
- **mockito-core**: Biblioteca de testes para mockar objetos e comportamentos.
- **flyway-mysql**: Suporte para migrações Flyway específicas para MySQL.
- **springdoc-openapi-starter-webmvc-ui**: Integração do Spring Boot com Swagger/OpenAPI para documentação automática de APIs.
- **mysql-connector-j**: Conector JDBC para MySQL.
- **lombok**: Gera código Java como getters, setters e construtores automaticamente.
- **spring-boot-starter-test**: Conjunto de ferramentas para testes no Spring Boot.
- **spring-security-test**: Utilizado para testes de segurança no Spring Security.
- **java-jwt**: Biblioteca para criação e verificação de JSON Web Tokens (JWT).
- **junit**: Framework de testes unitários para Java.

## Requisitos do Sistema

### Requisitos de Software

1. **Java Development Kit (JDK)**
   - **Versão Requerida:** 17
   - **Descrição:** Necessário para compilar e executar o projeto. A versão especificada é Java 17.

2. **Spring Boot**
   - **Versão:** 3.3.2
   - **Descrição:** Framework principal para desenvolvimento da aplicação.

3. **Flyway**
   - **Versão:** Compatível com a versão usada do Spring Boot.
   - **Descrição:** Ferramenta de migração de banco de dados. Inclui `flyway-core` e `flyway-mysql`.

4. **MySQL Connector**
   - **Versão:** Compatível com a versão do MySQL Server em uso.
   - **Descrição:** Driver JDBC para conectar a aplicação ao banco de dados MySQL.

5. **Lombok**
   - **Versão:** Não especificada (opcional)
   - **Descrição:** Biblioteca para reduzir o código boilerplate, como getters e setters. Incluída como opcional no projeto.

6. **Spring Security**
   - **Versão:** Integrado com o Spring Boot 3.3.2.
   - **Descrição:** Framework de segurança para a aplicação, incluindo `spring-boot-starter-security` e `spring-security-test` para testes.

7. **JUnit**
   - **Versão:** Não especificada
   - **Descrição:** Framework para testes unitários. Usado para realizar testes no projeto.

8. **Mockito**
   - **Versão:** 5.13.0
   - **Descrição:** Biblioteca para criar mocks em testes unitários.

9. **Springdoc OpenAPI**
   - **Versão:** 2.6.0
   - **Descrição:** Ferramenta para gerar a documentação da API usando OpenAPI (Swagger).

### Configurações de Ambiente

1. **Variáveis de Ambiente**
   - **Database URL:** URL de conexão para o banco de dados MySQL.
   - **Database Username:** Nome de usuário para acessar o banco de dados.
   - **Database Password:** Senha para acessar o banco de dados.

2. **Arquivos de Configuração**
   - **application.properties** ou **application.yml**: Configurações de ambiente, incluindo propriedades do banco de dados e outras configurações específicas da aplicação.

### Plataforma

- **Sistemas Operacionais Suportados:** Windows, macOS, Linux (qualquer sistema que suporte Java 17).

## Autenticação e Autorização

### Autenticação
- **Método:** JWT (JSON Web Tokens)
- **Descrição:** A API usa tokens JWT para autenticar e autorizar usuários. O token deve ser incluído no cabeçalho `Authorization` das requisições.
- **Exemplo de Cabeçalho de Autorização:**

- 
### Papéis e Permissões
- **Moderadores:** Têm acesso completo à API, incluindo gerenciamento de produtos, pedidos e usuários.
- **Usuários Regulares:** Têm acesso restrito, principalmente para criação de pedidos e visualização de produtos.


