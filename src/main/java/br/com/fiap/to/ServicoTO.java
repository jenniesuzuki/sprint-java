package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ServicoTO {
    private Long idServico;
    @NotBlank
    private String descricaoServico;
    @PastOrPresent
    private LocalDate dataServico;

    public ServicoTO() {
    }

    public ServicoTO(Long idServico, @NotBlank String descricaoServico, @PastOrPresent LocalDate dataServico) {
        this.idServico = idServico;
        this.descricaoServico = descricaoServico;
        this.dataServico = dataServico;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public void setDataServico(LocalDate dataServico) {
        this.dataServico = dataServico;
    }
}