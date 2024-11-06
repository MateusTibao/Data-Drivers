package modelos;

public class Produto {
    private static int contadorId = 0;
    private final int id;
    private final String nome;
    private final String descricao;
    private double preco;
    private int estoque;

    public Produto(String nome, String descricao, double preco, int estoque) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }
}
