package br.com.fiap.to;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AgendamentoTO {

    private Long idAgendamento;
    @FutureOrPresent
    private LocalDate data;
    @Size(min = 7, max = 7, message = "A placa deve ter 7 dígitos.")
    private String placa;

    public AgendamentoTO() {
    }

    public AgendamentoTO(Long idAgendamento, @FutureOrPresent LocalDate data, @Size(min = 7, max = 7, message = "A placa deve ter 7 dígitos.") String placa) {
        this.idAgendamento = idAgendamento;
        this.data = data;
        this.placa = placa;
    }

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
