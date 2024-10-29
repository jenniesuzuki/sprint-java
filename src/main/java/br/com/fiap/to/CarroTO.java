package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarroTO {
    @Size(min = 7, max = 7, message = "A placa deve ter 7 dígitos.")
    private String placa;
    @NotBlank
    private String modelo;
    @NotBlank
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos.")
    private String cpf;

    public CarroTO() {
    }

    public CarroTO(@NotBlank @Size(min = 7, max = 7, message = "A placa deve ter 7 dígitos.") String placa, @NotBlank String modelo, @NotBlank @Size(min = 11, max = 11, message = "O CPF deve ter 11 dígitos.") String cpf) {
        this.placa = placa;
        this.modelo = modelo;
        this.cpf = cpf;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
