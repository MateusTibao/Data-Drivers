import modelos.*;

public class Main {
    public static void main(String[] args) {

        Pessoa representante = new Pessoa("Caio Freitas", "11 99999-9999", "999.999.999-99");
        Oficina oficina = new Oficina("Mecanica Booz", "123.456.789-00", "jorge.booz@email.com", "987654321", representante);
        System.out.println("Cliente criado: " + oficina.getNome());

        Produto pneu = new Produto("Pneu", "Pneu radiais para carros de passeio, 17 polegadas.", 350.00, 50);
        Produto bateria = new Produto("Bateria", "Bateria 12V, 60Ah, ideal para carros de médio porte.", 250.00, 30);
        Produto farol = new Produto("Farol", "Farol dianteiro com tecnologia LED, para melhor visibilidade à noite.", 120.00, 20);
        Produto oleo = new Produto("Óleo de Motor", "Óleo sintético de alta performance, 5W-30.", 35.00, 100);

        System.out.println("\nProdutos criados:");
        System.out.println("- " + pneu.getNome());
        System.out.println("- " + bateria.getNome());
        System.out.println("- " + farol.getNome());
        System.out.println("- " + oleo.getNome());

        Compra compra = new Compra(oficina);
        System.out.println("\nCompra iniciada para o cliente: " + oficina.getNome());

        compra.adicionarProduto(pneu, 5);
        compra.adicionarProduto(bateria, 3);
        compra.adicionarProduto(farol, 2);
        compra.adicionarProduto(oleo, 10);

        System.out.println("\nPedido após adicionar produtos:");
        compra.exibirPedido();
        System.out.println("Valor Total: R$ " + compra.calcularValorTotal());

        System.out.println("\nRemovendo 1 unidade da Bateria...");
        compra.removerProduto(bateria, 1);
        compra.exibirPedido();
        System.out.println("Valor Total após remoção: R$ " + compra.calcularValorTotal());

        System.out.println("\nTentando remover 5 unidades do Pneu...");
        compra.removerProduto(pneu, 5);
        compra.removerProduto(pneu, 1);

        System.out.println("\nFinalizando a compra...");
        compra.finalizarCompra();

        System.out.println("\nTentando adicionar mais produtos após finalização...");
        compra.adicionarProduto(oleo, 5);

        System.out.println("\nTentando remover 2 unidades do Farol após finalização...");
        compra.removerProduto(farol, 2);

        System.out.println("\nPedido final após tentativa de adicionar e remover produtos após finalização:");
        compra.exibirPedido();

        System.out.println("\nExibindo estoque dos produtos após a compra:");
        compra.exibirEstoque();
    }
}
