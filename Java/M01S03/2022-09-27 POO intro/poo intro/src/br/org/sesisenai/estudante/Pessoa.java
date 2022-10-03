package br.org.sesisenai.estudante;

public class Pessoa {
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    private String sobrenome;
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    private Integer idade;
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    private String profissao;
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    private Boolean doadorDeOrgaos;
    public Boolean getDoadorDeOrgaos() {
        return doadorDeOrgaos;
    }
    public void setDoadorDeOrgaos(Boolean doadorDeOrgaos) {
        this.doadorDeOrgaos = doadorDeOrgaos;
    }

    private Float peso;
    public Float getPeso() {
        return peso;
    }
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    String nomeCompleto;
    public String getNomeCompleto() {
        nomeCompleto = this.getNome() + " " + this.getSobrenome();
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        String[] parts = nomeCompleto.split(" ", 2);
        this.setNome(parts[0]);
        this.setSobrenome(parts[1]);
    }
    public Pessoa(String nome, String sobrenome, Integer idade, String profissao, Boolean doadorDeOrgaos, Float peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.profissao = profissao;
        this.doadorDeOrgaos = doadorDeOrgaos;
        this.peso = peso;
    }

    public static void main(String[] args) {
        // Inicializa, obtém e imprime os atributos do objeto pessoa, instância da classe Pessoa
        Pessoa pessoa = new Pessoa("Bruno", "Cunha", 30, "Engenheiro", true, 76.5F);
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getSobrenome());
        System.out.println(pessoa.getIdade());
        System.out.println(pessoa.getProfissao());
        System.out.println(pessoa.getDoadorDeOrgaos());
        System.out.println(pessoa.getPeso());
        System.out.println();

        // Modifica e imprime os atributos do objeto da classe Pessoa
        pessoa.setNome("Joao");
        pessoa.setSobrenome("Silva");
        pessoa.setIdade(20);
        pessoa.setProfissao("Técnico Eletrônico");
        pessoa.setDoadorDeOrgaos(false);
        pessoa.setPeso(72.7F);

        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getSobrenome());
        System.out.println(pessoa.getIdade());
        System.out.println(pessoa.getProfissao());
        System.out.println(pessoa.getDoadorDeOrgaos());
        System.out.println(pessoa.getPeso());
        System.out.println(pessoa.getNomeCompleto());
        System.out.println();

        // Modifica e imprime os atributos do objeto da classe Pessoa
        pessoa.setNomeCompleto("Bruno da Silva Cunha");
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getSobrenome());
        System.out.println(pessoa.getNomeCompleto());
    }
}
