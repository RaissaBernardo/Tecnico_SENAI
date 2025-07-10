# Sistema de gerenciamento da biblioteca

Esse sistema foi desenvolvido para gerenciar operações de uma biblioteca. Ele foi feito do zero, sem banco de dados, utilizando o padrão MVC. 
A aplicação permite registrar empréstimos, adicionar livros a empréstimos existentes, atualizar datas e consultar informações de empréstimos.

## Como funciona o sistema?

A aplicação é **back-end** e faz uso de **endpoints**. O sistema usa Spring Boot e foi desenvolvido com a ideia de ser simples e eficiente.

## Funcionalidades

1. Registrar empréstimos: O sistema permite registrar um novo empréstimo, associando um cliente e livros.
2. Consultar empréstimos: Consultar todos os empréstimos registrados.
3. Adicionar livros a empréstimos que já existem: Permite adicionar novos livros a um empréstimo existente.
4. Atualizar a data final do empréstimo: Alterar a data final do empréstimo, caso haja necessidade.
5. Excluir empréstimo: Excluir um empréstimo já registrado.
6. Consultas por data: Filtrar empréstimos pela data final.

A aplicação de biblioteca é um software back-end, responsável por processar dados e fornecer funcionalidades sem interação direta com o usuário. Ela lida com o gerenciamento de empréstimos, livros e clientes, expondo APIs que podem ser consumidas por uma aplicação web. A principal diferença entre uma aplicação back-end e uma aplicação web é que o back-end processa as informações e a lógica de negócios, enquanto o front-end (aplicação web) interage diretamente com o usuário, exibindo dados e recebendo comandos. O front-end chama os endpoints da API do back-end para realizar operações como consultas ou registros.

