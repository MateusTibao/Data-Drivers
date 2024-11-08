package modelos;

public class Oficina {
    private static int contadorId = 0;
    private final int id;
    private final String nome;
    private final String endereco;
    private String email;
    private String telefone;
    private Pessoa representante;

    public Oficina(String nome, String endereco, String email, String telefone, Pessoa representante) {
        this.id = contadorId++;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.representante = representante;
    }

    public String getNome() {
        return nome;
    }
}
