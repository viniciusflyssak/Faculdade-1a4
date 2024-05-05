package br.edu.utfpr.pedido.repository;

import br.edu.utfpr.pedido.model.Pedido;
import br.edu.utfpr.pedido.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Transactional
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void atualizaStatus(Status status, Pedido pedido);

    @Query(value = "SELECT p from Pedido p  LEFT JOIN FETCH p.itens WHERE p.id = :id")
    Pedido buscaIdComItem(Long id);

}
