package br.com.trabalhoZoo.zoologico.model;

import br.com.trabalhoZoo.zoologico.repository.FuncionarioRepository;

public class Funcionario {

    private int id;
    private String nome;
    private String profissao;
    private String sexo;
    private String cpf;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Funcionario criaId() {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        setId(funcionarioRepository.buscaUltimoID() + 1);
        return this;
    }
}
