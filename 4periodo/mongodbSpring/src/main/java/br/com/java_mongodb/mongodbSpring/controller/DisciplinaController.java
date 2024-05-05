package br.com.java_mongodb.mongodbSpring.controller;

import br.com.java_mongodb.mongodbSpring.model.Aluno;
import br.com.java_mongodb.mongodbSpring.model.Disciplina;
import br.com.java_mongodb.mongodbSpring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DisciplinaController {
    @Autowired
    AlunoRepository repository;
   
    @GetMapping("/disciplina/cadastrar/{id}")
    public String cadastrar(@PathVariable String id, Model model){
        Aluno aluno = repository.obterId(id);
        model.addAttribute("aluno",aluno);
        model.addAttribute("disciplina", new Disciplina());
        return"disciplina/cadastrar";
    }
    
    @PostMapping("/disciplina/salvar/{id}")
    public String salvar(@PathVariable String id, @ModelAttribute Disciplina disciplina){
        Aluno aluno = repository.obterId(id);
        repository.salvar(aluno.addDisciplina(aluno, disciplina));
        return"redirect:/aluno/listar";
    }
    
}