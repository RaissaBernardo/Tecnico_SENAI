public abstract class DecoradorDeCafe implements Cafe { //base para os decoradores.
    protected Cafe cafe;

    public DecoradorDeCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public double custo() {
        return cafe.custo();
    }

    @Override
    public String descricao() {
        return cafe.descricao();
    }
}
