package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class MecanicoTO {
    private Long idMecanico;
    @NotBlank
    private String nomeMecanico;
    @NotBlank
    private String especialidade;

    public MecanicoTO() {
    }

    public MecanicoTO(Long idMecanico, @NotBlank String nomeMecanico, @NotBlank String especialidade) {
        this.idMecanico = idMecanico;
        this.nomeMecanico = nomeMecanico;
        this.especialidade = especialidade;
    }

    public Long getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Long idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNomeMecanico() {
        return nomeMecanico;
    }

    public void setNomeMecanico(String nomeMecanico) {
        this.nomeMecanico = nomeMecanico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
