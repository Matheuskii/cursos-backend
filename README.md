# API de Gerenciamento de Cursos

Este projeto é uma API RESTful desenvolvida com Spring Boot 3 para o gerenciamento de cursos. A API permite realizar operações de CRUD (Create, Read, Update, Delete) com suporte a exclusão lógica e documentação interativa via Swagger.

## 🚀 Como Executar o Projeto

1.  **Pré-requisitos:**
    *   Java 21 ou superior.
    *   MariaDB/MySQL rodando localmente.
    *   Banco de dados chamado `cursos_db` criado.

2.  **Configuração do Banco:**
    *   O arquivo `src/main/resources/application.properties` contém as configurações de conexão. Certifique-se de que o usuário e a senha coincidam com o seu ambiente local.


## 📖 Documentação Swagger (OpenAPI)

Após iniciar a aplicação, você pode acessar a documentação interativa e testar os endpoints através do link:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

## 🛠 Endpoints da API

### Grupo: Cursos

Todos os endpoints abaixo estão sob o prefixo `/cursos`.

#### 1. Listar Cursos
*   **Método:** `GET`
*   **Rota:** `/cursos`
*   **Descrição:** Retorna uma lista de todos os cursos que estão ativos no sistema.
*   **Respostas:**
    *   `200 OK`: Retorna a lista de cursos.

#### 2. Buscar por ID
*   **Método:** `GET`
*   **Rota:** `/cursos/{id}`
*   **Descrição:** Retorna os detalhes de um curso específico.
*   **Parâmetros:** `id` (Long) - Identificador único do curso.
*   **Respostas:**
    *   `200 OK`: Curso encontrado.
    *   `404 NOT FOUND`: Curso não encontrado ou inativo.

#### 3. Cadastrar Curso
*   **Método:** `POST`
*   **Rota:** `/cursos`
*   **Descrição:** Cria um novo curso. O nome deve ser único entre os ativos.
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "nome": "Nome do Curso",
      "periodo": "MATUTINO" 
    }
    ```
    *(Opções de período: MATUTINO, VESPERTINO, NOTURNO)*
*   **Respostas:**
    *   `201 CREATED`: Cadastro realizado com sucesso.
    *   `400 BAD REQUEST`: Erro de validação nos dados.
    *   `409 CONFLICT`: Já existe um curso com este nome.

#### 4. Atualizar Curso
*   **Método:** `PUT`
*   **Rota:** `/cursos`
*   **Descrição:** Atualiza os dados de um curso existente.
*   **Corpo da Requisição (JSON):**
    ```json
    {
      "id": 1,
      "nome": "Novo Nome",
      "periodo": "VESPERTINO"
    }
    ```
*   **Respostas:**
    *   `202 ACCEPTED`: Atualização processada com sucesso.
    *   `400 BAD REQUEST`: Dados inválidos.
    *   `404 NOT FOUND`: ID do curso não existe.
    *   `409 CONFLICT`: Tentativa de usar um nome de curso já existente.

#### 5. Deletar Curso (Exclusão Lógica)
*   **Método:** `DELETE`
*   **Rota:** `/cursos/{id}`
*   **Descrição:** Desativa um curso no sistema (não remove do banco de dados).
*   **Respostas:**
    *   `204 NO CONTENT`: Deleção realizada com sucesso.
    *   `404 NOT FOUND`: Curso não encontrado.

---

## 🏗 Tecnologias Utilizadas
*   **Spring Boot 3**
*   **Java 21**
*   **Spring Data JPA**
*   **Flyway** (Migrações de banco de dados)
*   **Springdoc-OpenAPI** (Swagger UI)
*   **MariaDB**
*   **Bean Validation**
