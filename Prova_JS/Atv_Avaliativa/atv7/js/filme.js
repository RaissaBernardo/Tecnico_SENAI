// filme.js
export default class filme {
    #filme = [];

    constructor() {
    }

    addItem(titulo, genero, ano, classificacao) {
        this.#filme.push({ titulo, genero, ano, classificacao });
    }

    getFilme() {
        return this.#filme;
    }

}
