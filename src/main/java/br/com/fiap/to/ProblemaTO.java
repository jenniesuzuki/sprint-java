package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProblemaTO {
    @NotBlank
    private String descricaoProblema;
    @Size(min = 7, max = 7, message = "A placa deve ter 7 dígitos.")
    private String placa;

    public ProblemaTO() {
    }

    public ProblemaTO(@NotBlank String descricaoProblema, @Size(min = 7, max = 7, message = "A placa deve ter 7 dígitos.") String placa) {
        this.descricaoProblema = descricaoProblema;
        this.placa = placa;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}