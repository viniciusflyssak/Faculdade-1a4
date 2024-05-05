package br.com.trabalhoZoo.zoologico.model;

import br.com.trabalhoZoo.zoologico.repository.AnimalRepository;

public class Animal {

    private int id;
    private String nome;
    private String especie;
    private int profissional;
    private String nomeCientifico;
    private String familia;
    private String comportamentos;

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getComportamentos() {
        return comportamentos;
    }

    public void setComportamentos(String comportamentos) {
        this.comportamentos = comportamentos;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getProfissional() {
        return profissional;
    }

    public void setProfissional(int profissional) {
        this.profissional = profissional;
    }

    public Animal criaId() {
        AnimalRepository animalRepository = new AnimalRepository();
        setId(animalRepository.buscaUltimoID() + 1);
        return this;
    }
}
