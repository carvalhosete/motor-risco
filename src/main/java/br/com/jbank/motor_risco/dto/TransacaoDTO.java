package br.com.jbank.motor_risco.dto;

import br.com.jbank.motor_risco.domain.Transacao;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransacaoDTO(

        @NotBlank(message = "O CPF é de preenchimento obrigatório.")
        String cpf,

        @NotNull(message = "Os dados da transação são obrigatórios.")
        @Valid
        Transacao transacao
) {}
