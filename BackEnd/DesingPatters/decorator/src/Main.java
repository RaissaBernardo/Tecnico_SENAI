public class Main {
    public static void main(String[] args) {
        Cafe meuCafe = new CafeSimples(); // café puro
        System.out.println(meuCafe.descricao() + " custa R$" + meuCafe.custo());

        meuCafe = new Leite(meuCafe); // add leite
        System.out.println(meuCafe.descricao() + " custa R$" + meuCafe.custo());

        meuCafe = new Chantilly(meuCafe); // add chantilly
        System.out.println(meuCafe.descricao() + " custa R$" + meuCafe.custo());
    }
}
