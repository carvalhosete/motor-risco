package br.com.jbank.motor_risco.service;

import br.com.jbank.motor_risco.domain.Cliente;
import br.com.jbank.motor_risco.domain.Transacao;
import br.com.jbank.motor_risco.repository.ClienteRepository;
import br.com.jbank.motor_risco.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AnaliseRiscoService {

    private final TransacaoRepository transacaoRepository;
    private final ClienteRepository clienteRepository;

    public AnaliseRiscoService(TransacaoRepository transacaoRepository, ClienteRepository clienteRepository){
        this.transacaoRepository = transacaoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Transacao> buscarRelatorio(){
        return transacaoRepository.buscarTodosClientes();
    }

    public List<Transacao> buscarRelatorioPorCpf(String cpf){
        return transacaoRepository.buscarTransacaoPorCpf(cpf);
    }


    @Transactional
    public Transacao analisar(String cpf, Transacao transacao){
        Cliente clienteEncontrado = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado na base de dados."));

        if(!clienteEncontrado.isConfiavel()){
            throw new RuntimeException("ATENÇÃO! Transação não realizada, entre em contato com sua instituição financeira.");
        }

        transacao.setStatusAnalise(true);
        transacao.setCliente(clienteEncontrado);

        return transacaoRepository.save(transacao);
    }
}
