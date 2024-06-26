package br.com.java_mongodb.mongodbSpring.controller;

import br.com.java_mongodb.mongodbSpring.model.Aluno;
import br.com.java_mongodb.mongodbSpring.model.Nota;
import br.com.java_mongodb.mongodbSpring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotaController {
    @Autowired
    AlunoRepository repository;
   
    @GetMapping("/nota/cadastrar/{id}")
    public String cadastrar(@PathVariable String id, Model model){
        Aluno aluno = repository.obterId(id);
        model.addAttribute("aluno",aluno);
        model.addAttribute("nota", new Nota());
        return"nota/cadastrar";
    }
    
    @PostMapping("/nota/salvar/{id}")
    public String salvar(@PathVariable String id, @ModelAttribute Nota nota){
        Aluno aluno = repository.obterId(id);
        System.out.println("--------------------");
        repository.salvar(aluno.addNota(aluno, nota));
        return"redirect:/";
    }    
}
