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
            System.out.println("Erro: Estoque insuficiente para o produto " + produto.getNome());
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
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
            System.out.println("Removido " + quantidade + " unidade(s) do produto " + produto.getNome() + " da compra.");
        } else {
            System.out.println("Erro: Quantidade insuficiente do produto " + produto.getNome() + " para remover.");
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
        ArrayList<Produto> produtosExibidos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            Produto produtoAtual = produtos.get(i);

            if (!produtosExibidos.contains(produtoAtual)) {
                int quantidade = 0;

                for (int j = i; j < produtos.size(); j++) {
                    if (produtos.get(j).equals(produtoAtual)) {
                        quantidade++;
                    }
                }

                produtosExibidos.add(produtoAtual);

                System.out.println("- " + produtoAtual.getNome() + " - R$" + produtoAtual.getPreco() + " x " + quantidade);
            }
        }

        System.out.println("Valor Total: R$" + valorTotal);
    }

    public void exibirEstoque() {
        System.out.println("Estoque dos produtos:");

        ArrayList<Produto> produtosExibidos = new ArrayList<>();

        for (int i = 0; i < produtos.size(); i++) {
            Produto produtoAtual = produtos.get(i);

            if (!produtosExibidos.contains(produtoAtual)) {
                int quantidade = 0;
                for (int j = i; j < produtos.size(); j++) {
                    if (produtos.get(j).equals(produtoAtual)) {
                        quantidade++;
                    }
                }

                produtosExibidos.add(produtoAtual);

                System.out.println("- " + produtoAtual.getNome() + " | Quantidade disponível: " + produtoAtual.getEstoque() + " | Preço unitário: R$ " + produtoAtual.getPreco());
            }
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