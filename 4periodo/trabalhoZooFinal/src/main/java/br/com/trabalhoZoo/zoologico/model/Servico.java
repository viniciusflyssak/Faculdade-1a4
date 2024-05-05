package br.com.trabalhoZoo.zoologico.model;

import br.com.trabalhoZoo.zoologico.repository.ServicoRepository;

public class Servico {

    private int id;
    private String nome;
    private String descricao;
    private String data;
    private String hora;
    private int animal;
    private int profissional;
    private boolean concluido;
    private String dataConcluido;
    private String horaConcluido;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getAnimal() {
        return animal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public int getProfissional() {
        return profissional;
    }

    public void setProfissional(int profissional) {
        this.profissional = profissional;
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

    public String getDataConcluido() {
        return dataConcluido;
    }

    public void setDataConcluido(String dataConcluido) {
        this.dataConcluido = dataConcluido;
    }

    public String getHoraConcluido() {
        return horaConcluido;
    }

    public void setHoraConcluido(String horaConcluido) {
        this.horaConcluido = horaConcluido;
    }

    public Servico criaId() {
        ServicoRepository servicoRepository = new ServicoRepository();
        setId(servicoRepository.buscaUltimoID() + 1);
        return this;
    }
}
