package br.com.jbank.motor_risco.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @NotNull(message = "O ID da conta de origem é obrigatório.")
    private String contaOrigem;
    @NotNull(message = "O ID da conta de destino é obrigatório.")
    private String contaDestino;

    @Positive(message = "O valor da transferência deve ser maior que zero.")
    private BigDecimal valor;

    @CreationTimestamp
    private LocalDateTime dataHora;

    private boolean statusAnalise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(String contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public String getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(String contaDestino) {
        this.contaDestino = contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isStatusAnalise() {
        return statusAnalise;
    }

    public void setStatusAnalise(boolean statusAnalise) {
        this.statusAnalise = statusAnalise;
    }
}
