package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class PecasTO {
    private Long idPeca;
    @NotBlank
    private String nomePeca;
    @PositiveOrZero
    @NotNull
    private int quantidadePeca;
    @PositiveOrZero
    @NotNull
    private float valorPeca;

    public PecasTO() {
    }

    public PecasTO(Long idPeca, @NotBlank String nomePeca, @PositiveOrZero @NotNull int quantidadePeca, @PositiveOrZero @NotNull float valorPeca) {
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.quantidadePeca = quantidadePeca;
        this.valorPeca = valorPeca;
    }

    public Long getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(Long idPeca) {
        this.idPeca = idPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public float getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(float valorPeca) {
        this.valorPeca = valorPeca;
    }
}
