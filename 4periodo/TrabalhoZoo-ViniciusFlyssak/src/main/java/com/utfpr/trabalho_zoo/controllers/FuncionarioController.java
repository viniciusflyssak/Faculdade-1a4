package com.utfpr.trabalho_zoo.controllers;

import com.utfpr.trabalho_zoo.model.Funcionario;
import com.utfpr.trabalho_zoo.repositorys.FuncionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncionarioController {
    
    @Autowired
    FuncionarioRepository repository;
   
    @GetMapping("/funcionario/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return"funcionario/cadastrar";
    }
    
    @PostMapping("/funcionario/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario){
        repository.salvar(funcionario);
        return"redirect:/";
    }
    
    @GetMapping("/funcionario/listar")
    public String listar(Model model){
        List<Funcionario> funcionarios = repository.listarTodos();
        model.addAttribute("funcionarios", funcionarios);
        return"funcionario/listar";
    }
    
   @GetMapping("/funcionario/visualizar/{id}")
    public String visualizar(@PathVariable int id, Model model){
       Funcionario funcionario = repository.buscarFuncionario(id);
       model.addAttribute("funcionario", funcionario);
       return "funcionario/visualizar";
   }
    
    @GetMapping("/funcionario/excluir/{id}")
    public String excluir(@PathVariable int id){
       repository.excluirFuncionario(id);       
       return "redirect:/funcionario/listar";
   }
}
