package gerenciador_estoque.observer;

import gerenciador_estoque.model.Produto;

public interface Observer {
    public void update(Produto produto);
}
