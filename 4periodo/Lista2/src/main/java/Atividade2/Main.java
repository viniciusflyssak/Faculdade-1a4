/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade2;

/**
 *
 * @author vinic
 */
public class Main {

    public static void main(String[] args) {
        ServicoFacade servicoFacade = new ServicoFacade();
        Servico sInventario = servicoFacade.getServico(ServicoFacade.INVENTARIO);
        System.out.println("Serviço de inventário: " + sInventario.getDescricao());
        Servico sPagamento = servicoFacade.getServico(ServicoFacade.PAGAMENTO);
        System.out.println("Serviço de Pagamento: " + sPagamento.getDescricao());
        Servico sEntrega = servicoFacade.getServico(ServicoFacade.ENTREGA);
        System.out.println("Serviço de Entrega: " + sEntrega.getDescricao());
        Servico sMonitoramento = servicoFacade.getServico(ServicoFacade.MONITORAMENTO);
        System.out.println("Serviço de Monitoramento: " + sMonitoramento.getDescricao());
    }

}
