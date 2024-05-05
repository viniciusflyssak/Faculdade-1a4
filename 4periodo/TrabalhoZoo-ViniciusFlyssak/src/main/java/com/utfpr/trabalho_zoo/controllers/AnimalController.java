package com.utfpr.trabalho_zoo.controllers;

import com.utfpr.trabalho_zoo.model.Animal;
import com.utfpr.trabalho_zoo.repositorys.AnimalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {
    
    @Autowired
    AnimalRepository repository;
   
    @GetMapping("/animal/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("animal", new Animal());
        return"animal/cadastrar";
    }
    
    @PostMapping("/animal/salvar")
    public String salvar(@ModelAttribute Animal animal){
        repository.salvar(animal);
        return"redirect:/";
    }
    
    @GetMapping("/animal/listar")
    public String listar(Model model){
        List<Animal> animais = repository.listarTodos();
        model.addAttribute("animais", animais);
        return"animal/listar";
    }
    
   @GetMapping("/animal/visualizar/{id}")
    public String visualizar(@PathVariable int id, Model model){
       Animal animal = repository.buscarAnimal(id);
       model.addAttribute("animal", animal);
       return "animal/visualizar";
   }
    
    @GetMapping("/animal/excluir/{id}")
    public String excluir(@PathVariable int id){
       repository.excluirAnimal(id);       
       return "redirect:/animal/listar";
   }
}
