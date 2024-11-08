package modelos;

public class Pessoa {
    private static int contadorId = 0;
    private final int id;
    private final String nome;
    private final String telefone;
    private final String cpf;

    public Pessoa(String nome, String telefone, String cpf) {
        this.id = ++contadorId;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }
}
