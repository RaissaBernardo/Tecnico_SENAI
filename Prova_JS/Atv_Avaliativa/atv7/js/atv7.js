import filme from './filme.js';
//não terminei
class atv7{
    #filme;
     constructor() {
            this.#filme = new filme(); 
            this.configurar();
        }
    
        configurar() {
            document.getElementById('adicionar').addEventListener('click', () => {
                const titulo = document.getElementById('titulo').value;
                const genero = parseInt(document.getElementById('genero').value);
                const ano = parseFloat(document.getElementById('ano').value);
    
                if (titulo && genero && ano) {
                    this.#filme.addItem(titulo, genero, ano);
                    console.log("titulo adicionado:", titulo, genero, ano);
                } else {
                    alert("Preencha todos os campos corretamente.");
                }
            });
    
            //finaliza
            document.getElementById('finalizar').addEventListener('click', () => {
                document.getElementById('resultado').innerText = ${filme};
            });
        }
    
}