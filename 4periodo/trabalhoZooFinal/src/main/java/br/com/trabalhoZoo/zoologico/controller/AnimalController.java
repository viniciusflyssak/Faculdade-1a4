package br.com.trabalhoZoo.zoologico.controller;

import br.com.trabalhoZoo.zoologico.model.Animal;
import br.com.trabalhoZoo.zoologico.model.Funcionario;
import br.com.trabalhoZoo.zoologico.repository.AnimalRepository;
import br.com.trabalhoZoo.zoologico.repository.FuncionarioRepository;
import static java.lang.System.console;
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
    public String cadastrar(Model model) {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        List<Funcionario> funcionarios = funcionarioRepository.listarTodos();
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("animal", new Animal());
        return "animal/cadastrar";
    }

    @PostMapping("/animal/salvar")
    public String salvar(@ModelAttribute Animal animal) {
        repository.salvar(animal);
        return "redirect:/";
    }

    @GetMapping("/animal/listar")
    public String listar(Model model) {
        List<Animal> animais = repository.listarTodos();
        model.addAttribute("animais", animais);
        return "animal/listar";
    }

    @GetMapping("/animal/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Animal animal = repository.buscarAnimal(id);
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        List<Funcionario> funcionarios = funcionarioRepository.listarTodos();
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("animal", animal);
        return "animal/editar";
    }

    @GetMapping("/animal/excluir/{id}")
    public String excluir(@PathVariable int id) {
        repository.excluirAnimal(id);
        return "redirect:/animal/listar";
    }

    @PostMapping("/animal/atualizar")
    public String atualizar(@ModelAttribute Animal animal) {
        repository.salvarEdicao(animal);
        return "redirect:/";
    }
}
