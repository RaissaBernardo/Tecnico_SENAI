import Pedidos from './Pedidos.js';

class atv5 {
    #pedido;

    constructor() {
        this.#pedido = new Pedidos(); 
        this.configurar();
    }

    configurar() {
        document.getElementById('adicionar').addEventListener('click', () => {
            const produto = document.getElementById('produto').value;
            const quantidade = parseInt(document.getElementById('quantidade').value);
            const preco = parseFloat(document.getElementById('preco').value);

            if (produto && quantidade && preco) {
                this.#pedido.addItem(produto, quantidade, preco);
                console.log("produto adicionado:", produto, quantidade, preco);
            } else {
                alert("Preencha todos os campos corretamente.");
            }
        });

        //finaliza
        document.getElementById('finalizar').addEventListener('click', () => {
            this.calcularTotal();
        });
    }


    calcularTotal() {
        let total = this.#pedido.calcularTotal();

        document.getElementById('resultado').innerText = `Total do Pedido R$ ${total}`;
    }
}

document.addEventListener('DOMContentLoaded', () => {
    new atv5();
});
