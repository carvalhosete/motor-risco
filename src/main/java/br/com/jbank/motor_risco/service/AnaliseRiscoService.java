package br.com.jbank.motor_risco.service;

import br.com.jbank.motor_risco.domain.Transacao;
import br.com.jbank.motor_risco.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AnaliseRiscoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public AnaliseRiscoService(TransacaoRepository transacaoRepository){
        this.transacaoRepository = transacaoRepository;
    }

    public List<Transacao> buscarRelatorio(){
        return transacaoRepository.buscarTodosClientes();
    }

    private Set<String> cpfsConfiaveis = new HashSet<>();

    public void adicionarCPF(String cpf) {
        cpfsConfiaveis.add(cpf);
    }

    @Transactional
    public Transacao analisar(String cpf, Transacao transacao){
        transacao.setStatusAnalise(cpfsConfiaveis.contains(cpf));
        return transacaoRepository.save(transacao);
    }
}
