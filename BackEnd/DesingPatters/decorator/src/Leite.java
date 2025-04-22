public class Leite extends DecoradorDeCafe {
    public Leite(Cafe cafe) {
        super(cafe);
    }

    @Override
    public double custo() {
        return super.custo() + 2.0;
    }

    @Override
    public String descricao() {
        return super.descricao() + " com Leite";
    }
}
