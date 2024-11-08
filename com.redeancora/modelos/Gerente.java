package modelos;

import java.util.ArrayList;

public class Gerente extends Pessoa {
    private String funcional;
    private ArrayList<Funcionario> funcionarios;

    public Gerente(String nome, String telefone, String cpf, String funcional, ArrayList<Funcionario> funcionarios) {
        super(nome, telefone, cpf);
        this.funcional = funcional;
        this.funcionarios = funcionarios;
    }

    public String getFuncional() {
        return funcional;
    }

    public void setFuncional(String funcional) {
        this.funcional = funcional;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
