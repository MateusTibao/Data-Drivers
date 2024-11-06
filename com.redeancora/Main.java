package principais;

import modelos.Cliente;
import modelos.Compra;
import modelos.Produto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Jorge Booz", "123.456.789-00", "jorge.booz@email.com", "987654321");
        System.out.println("Cliente criado: " + cliente.getNome());

        Produto pneu = new Produto("Pneu", "Pneu radiais para carros de passeio, 17 polegadas.", 350.00, 50);
        Produto bateria = new Produto("Bateria", "Bateria 12V, 60Ah, ideal para carros de médio porte.", 250.00, 30);
        Produto farol = new Produto("Farol", "Farol dianteiro com tecnologia LED, para melhor visibilidade à noite.", 120.00, 20);
        Produto óleo = new Produto("Óleo de Motor", "Óleo sintético de alta performance, 5W-30.", 35.00, 100);

        System.out.println("Produtos criados: ");
        System.out.println("- " + pneu.getDescricao());
        System.out.println("- " + bateria.getDescricao());
        System.out.println("- " + farol.getDescricao());
        System.out.println("- " + óleo.getDescricao());

        Compra compra = new Compra(cliente);
        System.out.println("\nCompra iniciada para o cliente: " + cliente.getNome());

        compra.adicionarProduto(pneu, 5);
        compra.adicionarProduto(bateria, 3);
        compra.adicionarProduto(farol, 2);
        compra.adicionarProduto(óleo, 10);

        System.out.println("\nPedido após adicionar produtos:");
        compra.exibirPedido();
        System.out.println("Valor Total: R$ " + compra.calcularValorTotal());

        System.out.println("\nRemovendo 1 unidade da Bateria...");
        compra.removerProduto(bateria, 1);

        System.out.println("\nPedido após remoção de produto:");
        compra.exibirPedido();
        System.out.println("Valor Total após remoção: R$ " + compra.calcularValorTotal());

        System.out.println("\nFinalizando a compra...");
        compra.finalizarCompra();

        System.out.println("\nTentando adicionar mais produtos após finalização...");
        compra.adicionarProduto(pneu, 2);  // Não vai adicionar porque a compra está finalizada

        System.out.println("\nPedido após tentativa de adicionar produtos após finalização:");
        compra.exibirPedido();
    }
}
