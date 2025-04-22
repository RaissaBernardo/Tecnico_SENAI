public class CafeSimples implements Cafe { //implementa a interface cafe
    @Override
    public double custo() {
        return 5.0; // Custa 5 reais
    }

    @Override //superclasse ou interface
    public String descricao() {
        return "Café Simples";
    }
}
