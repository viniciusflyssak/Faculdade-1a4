package gerenciador_estoque.observer;

import gerenciador_estoque.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ConcreteSubjectEstoque implements Subject {

    private final List observers = new ArrayList();
    private Produto produto;

    public ConcreteSubjectEstoque(Produto produto) {
        this.produto = produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;        
        this.notifyObservers();
    }

    @Override
    public void registraObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Observer obs;
        for (int i = 0; i < observers.size(); i++) {
            System.out.println("Notificando observers!");
            obs = (Observer) observers.get(i);
            obs.update(produto);
        }
    }
}
