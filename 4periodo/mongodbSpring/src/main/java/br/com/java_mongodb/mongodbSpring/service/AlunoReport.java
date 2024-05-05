package br.com.java_mongodb.mongodbSpring.service;

import br.com.java_mongodb.mongodbSpring.model.Aluno;
import br.com.java_mongodb.mongodbSpring.repository.AlunoRepository;
import java.io.File;
import java.io.FileNotFoundException;
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
public class AlunoReport {
    
    @Autowired
    private AlunoRepository repository; 
    
    public String exportaRelatorio (String formato) throws FileNotFoundException, JRException{
        List<Aluno> alunos = repository.listarTodos();
        
        //criar e compilar um arquivo
        File arquivo = ResourceUtils.getFile("classpath:relatorio.jrxml");
        JasperReport report = JasperCompileManager.compileReport(arquivo.getAbsolutePath());
        
        //Parametros de impressao
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Relatorio Criado por Huilson", "Exemplo de Parametros");
        
        //Buscar os dados, mapea-los e inserir no arquivo
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(alunos);
        JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);
        
        //Caminho do Arquivo
        String path = "D:\\relat";
        
        //Tipo de saída
        if(formato.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(print, path+"\\relatorio.html");
        }
        if(formato.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(print, path+"\\relatorio.pdf");
        }
        return "relatorio gerado em: "+path;
    }
}
