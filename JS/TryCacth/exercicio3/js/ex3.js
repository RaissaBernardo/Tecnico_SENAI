class Contato {
    constructor(nome, telefone, email) {
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
    }
  }
  
  class Agenda {
    constructor() {
      this.contatos = [];
    }
  
    adicionar(contato) {
      this.contatos.push(contato);
      this.exibir();
    }
  
    editar(index, novoContato) {
      this.contatos[index] = novoContato;
      this.exibir();
    }
  
    excluir(index) {
      this.contatos.splice(index, 1);
      this.exibir();
    }
  
    pesquisar(nome) {
      return this.contatos.filter(contato =>
        contato.nome.toLowerCase().includes(nome.toLowerCase())
      );
    }
  
    ordenar() {
      this.contatos.sort((a, b) => a.nome.localeCompare(b.nome));
      this.exibir();
    }
  
    exibir(lista = this.contatos) {
      const ul = document.getElementById("lista-contatos");
      ul.innerHTML = "";
  
      lista.forEach((contato, index) => {
        const li = document.createElement("li");
        li.innerHTML = `
          <span>${contato.nome} - ${contato.telefone} - ${contato.email}</span>
          <div>
            <button onclick="editarContato(${index})">✏️</button>
            <button onclick="agenda.excluir(${index})">🗑️</button>
          </div>
        `;
        ul.appendChild(li);
      });
    }
  }
  
  const agenda = new Agenda();
  
  document.getElementById("form-contato").addEventListener("submit", function (e) {
    e.preventDefault();
    const nome = document.getElementById("nome").value.trim();
    const telefone = document.getElementById("telefone").value.trim();
    const email = document.getElementById("email").value.trim();
  
    try {
      const novoContato = new Contato(nome, telefone, email);
      agenda.adicionar(novoContato);
      e.target.reset();
    } catch (err) {
      alert(err.message);
    }
  });
  
  document.getElementById("pesquisa").addEventListener("input", function () {
    const termo = this.value.trim();
    const resultado = agenda.pesquisar(termo);
    agenda.exibir(resultado);
  });
  
  function ordenarContatos() {
    agenda.ordenar();
  }
  
  function editarContato(index) {
    const contato = agenda.contatos[index];
    const nome = prompt("Editar nome:", contato.nome);
    const telefone = prompt("Editar telefone:", contato.telefone);
    const email = prompt("Editar e-mail:", contato.email);
  
    try {
      const novoContato = new Contato(nome, telefone, email);
      agenda.editar(index, novoContato);
    } catch (err) {
      alert(err.message);
    }
  }
  