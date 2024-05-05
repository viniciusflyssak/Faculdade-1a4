/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Atividade2;

/**
 *
 * @author vinic
 */
public class ServicoFacade {

    public static final int INVENTARIO = 0;
    public static final int PAGAMENTO = 1;
    public static final int ENTREGA = 3;
    public static final int MONITORAMENTO = 4;

    public Servico getServico(int tipo) {
        switch (tipo) {
            case INVENTARIO:
                IApi apiInventario = new ApiInventario();
                return apiInventario.getServico();

            case PAGAMENTO:
                IApi apiPagamento = new ApiPagamento();
                return apiPagamento.getServico();
            case ENTREGA:
                IApi apiEntrega = new ApiEntrega();
                return apiEntrega.getServico();

            case MONITORAMENTO:
                IApi apiMonitoramento = new ApiMonitoramento();
                return apiMonitoramento.getServico();
            default:
                return null;

        }
    }
}
