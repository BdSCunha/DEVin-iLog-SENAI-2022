package devinhouse.pratica.empresa;

public abstract class Funcionario {

    public abstract String obterCategoria();

    public String baterPonto() {
        return "Ponto registrado.";
    }

    private Integer matricula;
    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    private String senha;
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    private Long cpf;
    public Long getCpf() {
        return cpf;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
