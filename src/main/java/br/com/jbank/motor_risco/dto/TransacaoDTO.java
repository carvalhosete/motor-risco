package br.com.jbank.motor_risco.dto;

import br.com.jbank.motor_risco.domain.Transacao;

public record TransacaoDTO(String cpf, Transacao transacao) {}
