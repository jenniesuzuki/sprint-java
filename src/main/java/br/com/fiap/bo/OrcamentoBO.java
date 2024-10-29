package br.com.fiap.bo;

import br.com.fiap.dao.OrcamentoDAO;
import br.com.fiap.to.OrcamentoTO;

import java.util.ArrayList;

public class OrcamentoBO {
    private OrcamentoDAO orcamentoDAO;

    public ArrayList<OrcamentoTO> findAllOrcamentos() {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.findAllOrcamentos();
    }

    public OrcamentoTO findByIdServico(Long idServico) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.findByIdServico(idServico);
    }

    public OrcamentoTO saveOrcamento(OrcamentoTO orcamento) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.saveOrcamento(orcamento);
    }

    public boolean deleteOrcamento(Long idServico) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.deleteOrcamento(idServico);
    }

    public OrcamentoTO updateOrcamento(OrcamentoTO orcamento) {
        orcamentoDAO = new OrcamentoDAO();
        return orcamentoDAO.updateOrcamento(orcamento);
    }

//    public float calcularOrcamento(float valorProduto, int quantidade, float maoDeObra, float taxa) {
//        float orcamento = ((1 + (taxa / 100))) * ((valorProduto * quantidade) + maoDeObra);
//        return orcamento;
//    }
}
