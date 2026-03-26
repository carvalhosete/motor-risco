package br.com.jbank.motor_risco.repository;

import br.com.jbank.motor_risco.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query("SELECT t FROM Transacao t JOIN FETCH t.cliente")
    List<Transacao> buscarTodosClientes();
}
