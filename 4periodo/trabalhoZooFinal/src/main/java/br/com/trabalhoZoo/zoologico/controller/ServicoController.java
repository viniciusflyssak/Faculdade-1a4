package br.com.trabalhoZoo.zoologico.controller;

import br.com.trabalhoZoo.zoologico.model.Animal;
import br.com.trabalhoZoo.zoologico.model.Funcionario;
import br.com.trabalhoZoo.zoologico.model.Servico;
import br.com.trabalhoZoo.zoologico.repository.AnimalRepository;
import br.com.trabalhoZoo.zoologico.repository.FuncionarioRepository;
import br.com.trabalhoZoo.zoologico.repository.ServicoRepository;
import br.com.trabalhoZoo.zoologico.service.ServicosRelatService;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ServicoController {

    @Autowired
    ServicoRepository repository;

    @Autowired
    ServicosRelatService relatorio;

    @GetMapping("/servico/cadastrar")
    public String cadastrar(Model model) {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        List<Funcionario> funcionarios = funcionarioRepository.listarTodos();
        AnimalRepository animalRepository = new AnimalRepository();
        List<Animal> animais = animalRepository.listarTodos();
        model.addAttribute("animais", animais);
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("servico", new Servico());
        return "servico/cadastrar";
    }

    @PostMapping("/servico/salvar")
    public String salvar(@ModelAttribute Servico servico) {
        repository.salvar(servico);
        return "redirect:/";
    }

    @GetMapping("/servico/listar")
    public String listar(Model model) {
        List<Servico> servicos = repository.listarTodos();
        model.addAttribute("servicos", servicos);
        return "servico/listar";
    }

    @GetMapping("/servico/listar_dia")
    public String listarDia(Model model) {
        List<Servico> servicos = repository.listarTodos().stream()
                .filter(servico -> servico.getData().equals(LocalDate.now().toString()))
                .collect(Collectors.toList());
        model.addAttribute("servicos", servicos);
        return "servico/listar";
    }

    @GetMapping("/servico/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Servico servico = repository.buscarServico(id);
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        List<Funcionario> funcionarios = funcionarioRepository.listarTodos();
        AnimalRepository animalRepository = new AnimalRepository();
        List<Animal> animais = animalRepository.listarTodos();
        model.addAttribute("animais", animais);
        model.addAttribute("funcionarios", funcionarios);
        model.addAttribute("servico", servico);
        return "servico/editar";
    }

    @GetMapping("/servico/excluir/{id}")
    public String excluir(@PathVariable int id) {
        repository.excluirServico(id);
        return "redirect:/servico/listar";
    }

    @PostMapping("/servico/atualizar")
    public String atualizar(@ModelAttribute Servico servico) {
        repository.salvarEdicao(servico);
        return "redirect:/";
    }

    @GetMapping("/servico/relatorio/{format}")
    public String gerarRelatorio(@PathVariable String format, RedirectAttributes redirectAttributes) throws FileNotFoundException, JRException {
        String path = relatorio.exportaRelatorio(format);
        redirectAttributes.addFlashAttribute("mensagem", "Relatório gerado com sucesso em "+path+"!");
        return "redirect:/";
    }
}
