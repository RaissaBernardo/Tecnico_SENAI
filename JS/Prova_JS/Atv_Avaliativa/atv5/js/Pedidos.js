// Pedidos.js
export default class Pedidos {
    #itens = [];

    constructor() {
       //itens vazio
    }

    addItem(item, quantidade, preco) {
        this.#itens.push({ item, quantidade, preco });
    }

    getItens() {
        return this.#itens;
    }

    calcularTotal() {
        return this.#itens.reduce((acc, pedido) => acc + (pedido.preco * pedido.quantidade), 0);
    }
}
