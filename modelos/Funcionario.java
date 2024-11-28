package modelos;

public class Funcionario extends Pessoa {
    private String funcional;

    public Funcionario(String nome, String telefone, String cpf, String funcional) {
        super(nome, telefone, cpf);
        this.funcional = funcional;
    }

    public String getFuncional() {
        return funcional;
    }
}
