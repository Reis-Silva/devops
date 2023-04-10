# Projeto devops

- Projeto da disciplina: Integração Contínua e DevOps

# Profiles:
- branch: master -> Requirimento revisor -> prod - Aponta para a base de produção -> releases são criados a partir da nova atualização da branch (Semantic Versioning).
- branch: main -> Requirimento revisor -> prod - Aponta para a base de homologação.
- branch: dev -> Sem revisor -> prod - Aponta para a base dos desenvolvedores.

- OBS: A partir da branch dev deve ser criada uma nova branch (Em casos particulares a branch main) para desevolver os novos projetos. 

# Instruções para executar o projeto:

## Comandos para iniciar o docker:
- 1 - docker build -t devops .  -> para construir os containers | primeiro deve ser gerado o artifact -> raiz do artefato -> /target/artifacts/devops.jar 
- 2 - docker-compose up  -> para iniciar os servidores com o grafana, prometheus, zipkin

# Endpoints da aplicação e ferramentas configuradas via docker-compose:

- Documentação: http://localhost:8080/swagger-ui/index.html#/
- Prometheus: http://localhost:9090
- Grafana: http://localhost:3000
- Zipkin: http://localhost:9411

# Comandos para usar o terraform no terminal do projeto baixado
## Formatação do script terraform (opcional)
- terraform fmt
## Inicialização do backend
- terraform init
## Criar o plano
- terraform plan
## Aplicar script
- terraform apply
