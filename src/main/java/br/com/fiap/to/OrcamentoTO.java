package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class OrcamentoTO {
    @PositiveOrZero
    @NotNull
    private float valorProduto;
    @PositiveOrZero
    @NotNull
    private int quantidade;
    @PositiveOrZero
    @NotNull
    private float maoDeObra;
    private Long idServico;

    public OrcamentoTO() {
    }

    public OrcamentoTO(@PositiveOrZero @NotNull float valorProduto, @PositiveOrZero @NotNull int quantidade, @PositiveOrZero @NotNull float maoDeObra, Long idServico) {
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
        this.maoDeObra = maoDeObra;
        this.idServico = idServico;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getMaoDeObra() {
        return maoDeObra;
    }

    public void setMaoDeObra(float maoDeObra) {
        this.maoDeObra = maoDeObra;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }
}
