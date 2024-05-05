package br.com.java_mongodb.mongodbSpring.controller;

import br.com.java_mongodb.mongodbSpring.model.Aluno;
import br.com.java_mongodb.mongodbSpring.repository.AlunoRepository;
import br.com.java_mongodb.mongodbSpring.service.AlunoReport;
import java.io.FileNotFoundException;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {
    
    @Autowired
    AlunoRepository repository;
    
    @Autowired
    AlunoReport relatorio;
   
    @GetMapping("/aluno/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("aluno", new Aluno());
        return"aluno/cadastrar";
    }
    
    @PostMapping("/aluno/salvar")
    public String salvar(@ModelAttribute Aluno aluno){
        repository.salvar(aluno);
        return"redirect:/";
    }
    
    @GetMapping("/aluno/listar")
    public String listar(Model model){
        List<Aluno> alunos = repository.listarTodos();
        model.addAttribute("alunos", alunos);
        return"aluno/listar";
    }
    
   @GetMapping("/aluno/visualizar/{id}")
    public String visualizar(@PathVariable String id, Model model){
       Aluno aluno = repository.obterId(id);
       model.addAttribute("aluno", aluno);
       return "aluno/visualizar";
   }
    
    @GetMapping("/aluno/excluir/{id}")
    public String excluir(@PathVariable String id){
       repository.excluir(id);       
       return "redirect:/aluno/listar";
   }
    
    @GetMapping("/aluno/atualizar/{id}")
    public String atualizar(@PathVariable String id, Model model){
       Aluno aluno = repository.obterId(id);
       model.addAttribute("aluno", aluno);      
       return "aluno/atualizar";
   }
    
    @PostMapping("/aluno/editar/{id}")
    public String editar(@ModelAttribute Aluno aluno){
        System.out.println("------------------------: "+aluno.getId());
        repository.salvar(aluno);
        return"redirect:/aluno/listar";
    }
    
    @GetMapping("/aluno/relatorio/{format}")
    public String gerarRelatorio(@PathVariable String format) throws FileNotFoundException, JRException{
       relatorio.exportaRelatorio(format);
       return "redirect:/";
   }
}
