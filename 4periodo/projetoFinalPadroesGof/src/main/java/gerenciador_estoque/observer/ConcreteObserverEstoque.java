package gerenciador_estoque.observer;

import gerenciador_estoque.model.Produto;

public class ConcreteObserverEstoque implements Observer {

    @Override //Realiza a simulação de envio de notificação para os clientes
    public void update(Produto produto) {
        if (produto.getQuantidade() != produto.getQuantidadeAntiga()) {
            System.out.println(" Enviando notificação para os clientes: 'Quantidade do produto " + produto.getNome() + " alterada de "
                    + produto.getQuantidadeAntiga() + " para " + produto.getQuantidade() + "'");
        }
    }
}
