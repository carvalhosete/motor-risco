package br.com.jbank.motor_risco.controller;

import br.com.jbank.motor_risco.domain.Transacao;
import br.com.jbank.motor_risco.dto.TransacaoDTO;
import br.com.jbank.motor_risco.service.AnaliseRiscoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final AnaliseRiscoService service;

    public TransacaoController(AnaliseRiscoService service){
        this.service = service;
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<Transacao>> verRelatorio(){
        var relatorio = service.buscarRelatorio();

        return ResponseEntity.ok(relatorio);
    }

    @PostMapping("/analise")
    public ResponseEntity<TransacaoDTO> analisarCPF(@RequestBody TransacaoDTO dto){
        var transacaoSalva = service.analisar(dto.cpf(), dto.transacao());
        TransacaoDTO dtoResposta = new TransacaoDTO(dto.cpf(), transacaoSalva);

        return ResponseEntity.ok(dtoResposta);
    }
}
