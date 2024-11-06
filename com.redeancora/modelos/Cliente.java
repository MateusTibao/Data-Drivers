package modelos;

public class Cliente {
    private static int contadorId = 0;
    private final int id;
    private final String nome;
    private final String cpf;
    private String email;
    private String telefone;


    public Cliente(String nome, String cpf, String email, String telefone) {
        this.id = contadorId++;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
}
