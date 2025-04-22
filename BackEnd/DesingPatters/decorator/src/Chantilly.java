public class Chantilly extends DecoradorDeCafe {
    public Chantilly(Cafe cafe) {
        super(cafe);
    }

    @Override
    public double custo() {
        return super.custo() + 3.0;
    }

    @Override
    public String descricao() {
        return super.descricao() + " com Chantilly";
    }
}
