import modelos.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nCriando o Gerente...");
        Gerente gerente = new Gerente("Ana Souza", "11 91111-1111", "888.888.888-88", "G01");

        System.out.println("\nCriando Funcionários...");
        Funcionario func1 = new Funcionario("João Silva", "11 92222-2222", "777.777.777-77", "F01");
        Funcionario func2 = new Funcionario("Maria Oliveira", "11 93333-3333", "666.666.666-66", "F02");
        Funcionario func3 = new Funcionario("Pedro Santos", "11 94444-4444", "555.555.555-55", "F03");

        System.out.println("\nAdicionando Funcionários ao Gerente...");
        gerente.adicionarFuncionario(func1);
        gerente.adicionarFuncionario(func2);
        gerente.adicionarFuncionario(func3);

        System.out.println("\nRemovendo um Funcionário...");
        gerente.removerFuncionario(func2);

        System.out.println("\nVinculando um representante para a Oficina...");
        Oficina oficina = new Oficina("Mecanica Booz", "123.456.789-00", "jorge.booz@email.com", "987654321", func1);
        System.out.println("\nCliente criado: " + oficina.getNome());

        System.out.println("\nCriando Produtos...");
        Produto pneu = new Produto("Pneu", "Pneu radiais para carros de passeio, 17 polegadas.", 350.00, 50);
        Produto bateria = new Produto("Bateria", "Bateria 12V, 60Ah, ideal para carros de médio porte.", 250.00, 30);
        Produto farol = new Produto("Farol", "Farol dianteiro com tecnologia LED, para melhor visibilidade à noite.", 120.00, 20);
        Produto oleo = new Produto("Óleo de Motor", "Óleo sintético de alta performance, 5W-30.", 35.00, 100);

        System.out.println("\nProdutos criados:");
        System.out.println("- " + pneu.getNome());
        System.out.println("- " + bateria.getNome());
        System.out.println("- " + farol.getNome());
        System.out.println("- " + oleo.getNome());

        System.out.println("\nIniciando uma Compra para o Cliente...");
        Compra compra = new Compra(oficina);
        System.out.println("\nCompra iniciada para o cliente: " + oficina.getNome());

        compra.adicionarProduto(pneu, 5);
        compra.adicionarProduto(bateria, 3);
        compra.adicionarProduto(farol, 2);
        compra.adicionarProduto(oleo, 10);

        System.out.println("\nPedido após adicionar produtos:");
        compra.exibirPedido();
        System.out.println("\nValor Total: R$ " + compra.calcularValorTotal());

        System.out.println("\nRemovendo 1 unidade da Bateria...");
        compra.removerProduto(bateria, 1);
        compra.exibirPedido();
        System.out.println("\nValor Total após remoção: R$ " + compra.calcularValorTotal());

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
