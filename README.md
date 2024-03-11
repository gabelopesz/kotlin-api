# Começando

As instruções a seguir irão guiá-lo na configuração do ambiente necessário para executar o projeto localmente.

## Pré-requisitos

Antes de iniciar, certifique-se de ter os seguintes requisitos instalados:

- Java JDK 17 ou superior: [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Docker: [Instalação Docker](https://docs.docker.com/get-docker/)
- IntelliJ IDEA ou outro IDE de sua preferência para desenvolvimento Kotlin: [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Instalação

Siga estes passos para configurar o projeto em seu ambiente local:

```powershell
# Configuração do Git para evitar problemas de CRLF/LF
git config --global core.autocrlf input

# Clone o repositório
git clone https://github.com/gabelopesz/kotlin-api.git kotlin-api

# Navegue até o diretório do projeto
cd kotlin-api/api

# Construa a imagem Docker para a API
docker build -t nome-api .

# Execute a imagem, mapeando a porta 8080 do container para a mesma porta no host
docker run -p 8080:8080 nome-api
```

## Uso

Para utilizar a API, siga as instruções abaixo:

1. Navegue até o diretório `kotlin-api/api`.
2. Execute o comando `docker build -t nome-api .` para construir a imagem Docker.
3. Utilize o comando `docker run -p 8080:8080 nome-api` para iniciar a API.
4. Acesse o serviço pelo navegador em `http://localhost:8080/users`.

### A aplicação Ktor possui os seguintes endpoints:

- `GET /users`: Retorna todos os usuários armazenados.
- `GET /users/{id}`: Retorna o usuário com o ID fornecido.
- `POST /users`: Adiciona um novo usuário.
- `PUT /users/{id}`: Atualiza um usuário existente com o ID fornecido.
- `DELETE /users/{id}`: Remove o usuário com o ID fornecido.

## Testando a API

Para testar as rotas da API, você pode usar o cURL no terminal ou prompt de comando. Aqui estão alguns exemplos de comandos cURL:

- **Obter todos os usuários:**

```bash
curl http://localhost:8080/users
```

- **Obter usuário por ID:**

```bash
curl http://localhost:8080/users/{id}
```

- **Adicionar um novo usuário:**

```bash
curl -X POST -H "Content-Type: application/json" -d '{"id": "novo_id", "firstName": "Name", "lastName": "LastName", "email": "test@example.com"}' http://localhost:8080/users
```

- **Atualizar um usuário existente:**

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"id": "id_existente", "firstName": "Name", "lastName": "LastName", "email": "test@example.com"}' http://localhost:8080/users/{id_existente}
```

- **Excluir um usuário:**

```bash
curl -X DELETE http://localhost:8080/users/{id}
```
