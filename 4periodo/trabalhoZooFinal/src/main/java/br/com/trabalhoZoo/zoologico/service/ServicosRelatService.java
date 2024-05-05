package br.com.trabalhoZoo.zoologico.service;

import br.com.trabalhoZoo.zoologico.model.Servico;
import br.com.trabalhoZoo.zoologico.model.ServicoRelat;
import br.com.trabalhoZoo.zoologico.repository.AnimalRepository;
import br.com.trabalhoZoo.zoologico.repository.FuncionarioRepository;
import br.com.trabalhoZoo.zoologico.repository.ServicoRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class ServicosRelatService {

    @Autowired
    private ServicoRepository repository;

    public String exportaRelatorio(String formato) throws FileNotFoundException, JRException, ParseException {
        List<Servico> servicos = repository.listarTodos();
        List<ServicoRelat> servicosRelat = new ArrayList<ServicoRelat>();
        AnimalRepository animalRepository = new AnimalRepository();
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        for (Servico servico : servicos) {
            String nomeAnimal = "Não informado";
            String nomeFuncionario = "Não informado";
            String concluido = "Não Concluído";
            if (servico.getAnimal() > 0) {
                nomeAnimal = animalRepository.buscarAnimal(servico.getAnimal()).getNome();
            }

            if (servico.getProfissional() > 0) {
                nomeFuncionario = funcionarioRepository.buscarFuncionario(servico.getProfissional()).getNome();
            }
            if (servico.isConcluido()) {
                if (!"".equals(servico.getDataConcluido())) {
                    concluido =  servico.getDataConcluido().substring(8,10) + "/" +servico.getDataConcluido().substring(5,7) + "/" + servico.getDataConcluido().substring(0,4);
                } else {
                    concluido = "Concluído";
                }
            }
            String dataFormatada = servico.getData().substring(8,10) + "/" +servico.getData().substring(5,7) + "/" + servico.getData().substring(0,4);
            servico.setData(dataFormatada);
            servicosRelat.add(new ServicoRelat(servico.getNome(), nomeFuncionario, nomeAnimal, concluido, servico.getData()));
        }

        File arquivo = ResourceUtils.getFile("classpath:servicoRelat.jrxml");
        JasperReport report = JasperCompileManager.compileReport(arquivo.getAbsolutePath());

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Relatorio Criado por Vinicius Flyssak", "Serviços");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(servicosRelat);
        JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);

        File path = new File("C:\\relat");
        if (!path.exists()) {
            path.mkdir();
        }

        if (formato.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(print, path + "\\relatorio.pdf");
        }
        return path + "\\relatorio.pdf";
    }
}
