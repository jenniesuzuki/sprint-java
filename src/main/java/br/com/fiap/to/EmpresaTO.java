package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class EmpresaTO {
    private Long idEmpresa;
    @NotBlank
    private String nomeEmpresa;
    @NotBlank
    private String informacoesEmpresa;

    public EmpresaTO() {
    }

    public EmpresaTO(Long idEmpresa, @NotBlank String nomeEmpresa, @NotBlank String informacoesEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.informacoesEmpresa = informacoesEmpresa;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getInformacoesEmpresa() {
        return informacoesEmpresa;
    }

    public void setInformacoesEmpresa(String informacoesEmpresa) {
        this.informacoesEmpresa = informacoesEmpresa;
    }
}
