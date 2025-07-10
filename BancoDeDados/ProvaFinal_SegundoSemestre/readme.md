# API SteelTech
API RESTful desenvolvida para gerenciar produtos, pedidos, estoque e clientes da empresa fictícia **SteelTech**.

Você pode testar todos os endpoints acessando:  
[http://localhost:8080/swagger-ui/index.html]

## Exemplos de Entradas

###Cadastro de Cliente (`POST /api/clientes`)

**Entrada (JSON enviado no corpo da requisição):**
```json
{
  "nome": "João da Silva",
  "email": "joao@gmail.com",
  "telefone": "11988887777"
}
```

> **Observação:**  
> O campo `id` **não deve** ser enviado na requisição, pois ele é gerado pelo auto-increment do banco de dados.

**Processamento:**
- O sistema valida os campos obrigatórios.
- Salva o cliente no banco de dados com um `id` (gerado automaticamente).

**Saída (JSON de resposta):**

```json
{
  "id": 1,
  "nome": "João da Silva",
  "email": "joao@gmail.com",
  "telefone": "11988887777"
}
```

---

## Ambiente de Desenvolvimento vs. Publicação na Web
Essa aplicação é executada localmente com o servidor Spring Boot rodando em `http://localhost:8080`. Esse ambiente é voltado para testes e ajustes durante a fase de criação.
Para publicar a aplicação na web é necessário realizar o **deploy** em um servidor público e hospedar.


> Feito usando Spring Boot.
```
