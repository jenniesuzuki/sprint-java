package br.com.fiap.bo;

import br.com.fiap.dao.PecasDAO;
import br.com.fiap.to.PecasTO;

import java.util.ArrayList;

public class PecasBO {
    private PecasDAO pecasDAO;

    public ArrayList<PecasTO> findAllPecas() {
        pecasDAO = new PecasDAO();
        return pecasDAO.findAllPecas();
    }

    public PecasTO findByIdPeca(Long idPeca) {
        pecasDAO = new PecasDAO();
        return pecasDAO.findByIdPeca(idPeca);
    }

    public PecasTO savePeca(PecasTO peca) {
        pecasDAO = new PecasDAO();
        return pecasDAO.savePeca(peca);
    }

    public boolean deletePeca(Long idPeca) {
        pecasDAO = new PecasDAO();
        return pecasDAO.deletePeca(idPeca);
    }

    public PecasTO updatePeca(PecasTO peca) {
        pecasDAO = new PecasDAO();
        return pecasDAO.updatePeca(peca);
    }

}
