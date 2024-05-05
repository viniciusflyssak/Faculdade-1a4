package br.com.java_mongodb.mongodbSpring.model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String professor;
    private int semestre;
    private List<Double> notas;

    public Disciplina(String nome, String professor, int semestre, List<Double> notas) {
        this.nome = nome;
        this.professor = professor;
        this.semestre = semestre;
        this.notas = notas;
    }

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public List<Double> getNotas() {
        if(notas == null)
            notas = new ArrayList<Double>();
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }   
}