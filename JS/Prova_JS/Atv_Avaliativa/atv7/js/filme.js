// filme.js
export default class filme {
    #filme = [];

    constructor() {
    }

    addItem(titulo, genero, ano) {
        this.#filme.push({ titulo, genero, ano });
    }

    calcularTotal() {
        return this.#filme;
    }

    getFilme() {
        return this.#filme;
    }

}
