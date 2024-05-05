package com.utfpr.trabalho_zoo.controllers;

import com.utfpr.trabalho_zoo.model.Servico;
import com.utfpr.trabalho_zoo.repositorys.ServicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicoController {
    
    @Autowired
    ServicoRepository repository;
   
    @GetMapping("/servico/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("servico", new Servico());
        return"servico/cadastrar";
    }
    
    @PostMapping("/servico/salvar")
    public String salvar(@ModelAttribute Servico servico){
        repository.salvar(servico);
        return"redirect:/";
    }
    
    @GetMapping("/servico/listar")
    public String listar(Model model){
        List<Servico> servicos = repository.listarTodos();
        model.addAttribute("servicos", servicos);
        return"servico/listar";
    }
    
   @GetMapping("/servico/visualizar/{id}")
    public String visualizar(@PathVariable int id, Model model){
       Servico servico = repository.buscarServico(id);
       model.addAttribute("servico", servico);
       return "servico/visualizar";
   }
    
    @GetMapping("/servico/excluir/{id}")
    public String excluir(@PathVariable int id){
       repository.excluirServico(id);       
       return "redirect:/servico/listar";
   }
}
