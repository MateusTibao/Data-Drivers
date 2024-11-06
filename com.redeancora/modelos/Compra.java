package modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    private static int contadorId = 1;
    private int id;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private LocalDate data;
    private double valorTotal;
    private boolean finalizada;

    public Compra(Cliente cliente) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.data = LocalDate.now();
        this.valorTotal = 0.0;
        this.finalizada = false;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (finalizada) {
            System.out.println("Erro: Não é possível adicionar produtos a uma compra finalizada.");
            return;
        }

        if (produto.getEstoque() >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                this.produtos.add(produto);
            }
            this.valorTotal += produto.getPreco() * quantidade;
            produto.setEstoque(produto.getEstoque() - quantidade);
            System.out.println("Adicionado " + quantidade + " unidade(s) do produto " + produto.getNome() + " à compra.");
        } else {
            System.out.println("Erro: Estoque insuficiente para o produto " + produto.getDescricao());
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getPreco();
        }
        return total;
    }

    public void removerProduto(Produto produto, int quantidade) {
        if (finalizada) {
            System.out.println("Erro: Não é possível remover produtos de uma compra finalizada.");
            return;
        }

        int count = 0;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).equals(produto)) {
                count++;
            }
        }

        if (count >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                produtos.remove(produto);
            }
            valorTotal -= produto.getPreco() * quantidade;
            produto.setEstoque(produto.getEstoque() + quantidade);
            System.out.println("Removido " + quantidade + " unidade(s) do produto " + produto.getDescricao() + " da compra.");
        } else {
            System.out.println("Erro: Quantidade insuficiente do produto " + produto.getDescricao() + " para remover.");
        }
    }

    public void exibirPedido() {
        if (produtos.isEmpty()) {
            System.out.println("Pedido vazio.");
            return;
        }

        System.out.println("Compra ID: " + id);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Data: " + data);
        System.out.println("Itens do Pedido:");

        for (Produto produto : produtos) {
            System.out.println("- " + produto.getDescricao() + " - R$" + produto.getPreco());
        }

        System.out.println("Valor Total: R$" + valorTotal);
    }

    public void exibirEstoque() {
        System.out.println("Estoque dos produtos:");

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println("Produto: " + produto.getDescricao() + " | Estoque: " + produto.getEstoque());
        }
    }

    public void finalizarCompra() {
        if (finalizada) {
            System.out.println("A compra já está finalizada.");
        } else {
            finalizada = true;
            System.out.println("Compra finalizada com sucesso.");
        }
    }
}
