package gerenciador_estoque.observer;

public interface Subject {

    public void registraObserver(Observer observer);

    public void removerObserver(Observer observer);

    public void notifyObservers();
}
