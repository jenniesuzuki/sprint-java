package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CentroAutomotivoTO {
    @NotBlank
    private String nomeCentro;
    @Size(min = 8, max = 8, message = "O CEP deve ter 8 dígitos.")
    private String cep;
    @NotBlank
    private String endereco;

    public CentroAutomotivoTO() {
    }

    public CentroAutomotivoTO(@NotBlank String nomeCentro, @Size(min = 8, max = 8, message = "O CEP deve ter 8 dígitos.") String cep, @NotBlank String endereco) {
        this.nomeCentro = nomeCentro;
        this.cep = cep;
        this.endereco = endereco;
    }

    public String getNomeCentro() {
        return nomeCentro;
    }

    public void setNomeCentro(String nomeCentro) {
        this.nomeCentro = nomeCentro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
