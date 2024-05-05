package br.com.java_mongodb.mongodbSpring.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;

public class Aluno {

    private ObjectId id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date idade;
    private String curso;
    private List<Disciplina> disciplinas;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getIdade() {
        return idade;
    }

    public void setIdade(Date idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    //Preciso tratar NPE quando for cadastrar a primeira disciplina
    public List<Disciplina> getDisciplinas() {
        if(disciplinas == null)
            disciplinas = new ArrayList<Disciplina>();
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Aluno criaId() {
        setId(new ObjectId());
        return this;
    }

    public Aluno addDisciplina(Aluno aluno, Disciplina disciplina) {
        List<Disciplina> disciplinas = aluno.getDisciplinas();
        disciplinas.add(disciplina);
        aluno.setDisciplinas(disciplinas);
        return aluno;
    }

    public Aluno addNota(Aluno aluno, Nota nota) {
        System.out.println("Entrou no ADD NOTA!!!!!!!!!!!!!!!!");
        List<Double> notas = new ArrayList<Double>();
        List<Disciplina> disciplinas = aluno.getDisciplinas();
        System.out.println("-------1"+aluno.getDisciplinas());
        
        for(Disciplina disciplina : disciplinas){
            if(nota.getNome().equalsIgnoreCase(disciplina.getNome())){
                notas = disciplina.getNotas();
                notas.add(nota.getValor());
                disciplina.setNotas(notas);
            }
        }
        return aluno;
    }
}