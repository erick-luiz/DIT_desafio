# DIT Desafio

Desafio Java DIT 


# Configurações necessárias

Para rodar o projeto em ambiente local é necessário ter o gradle Instalado para poder buildar o projeto e também o banco de dados Postgres. Nos arquivos de configurações temos as configurações do banco de dados com um padrão pré-definido para um ambiente de dev e varias de ambiente para o ambiente geral da aplicação. 

```json
# DB
spring:
  datasource:
    url: ${DATABASE_URL}
    username: ${DATABASE_USER}
    password: ${DATABASE_PASSWORD}
```

Altere para poder rodar a APP. 

# Coleção de teste 

Para fazer as chamadas para a APP, a pasta _doc_ possui a coleção com os requests e também o ambiente para serem importados no Postman e tornar possível as chamadas para a API. 


# Sobre os recursos da API 

* __Inserção__: a API permite que sejam criados invoices (faturas), e na sua criação ela validará as taxas que devem ser cobradas no momento da criação da mesma. Com isso nas buscas teremos essa taxa sendo aplicada num preço computado. 

* __Busca__: um get all paginado que deve retornar todas as contas cadastradas 

* __Busca por id__: um get por id para que seja possível consultar uma determinada conta

# O que a aplicação não faz? 

* reprocessamento: como evolução a aplicação deve poder reprocessar uma conta, já que o momento do cadastro pode não ser o momento de pagamento
* armazenamento de status: vale a inserção de um status que defina que a conta esta finalizada e a partir deste ponto impeça a alteração da mesma
* outros métodos: delete e update não estão implementados
