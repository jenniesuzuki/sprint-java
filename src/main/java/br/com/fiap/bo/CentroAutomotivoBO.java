package br.com.fiap.bo;

import br.com.fiap.dao.CentroAutomotivoDAO;
import br.com.fiap.to.CentroAutomotivoTO;

import java.util.ArrayList;

public class CentroAutomotivoBO {
    private CentroAutomotivoDAO centroAutomotivoDAO;

    public ArrayList<CentroAutomotivoTO> findAllCentros() {
        centroAutomotivoDAO = new CentroAutomotivoDAO();
        return centroAutomotivoDAO.findAllCentros();
    }

    public CentroAutomotivoTO findByCep(String cep) {
        centroAutomotivoDAO = new CentroAutomotivoDAO();
        return centroAutomotivoDAO.findByCep(cep);
    }

    public CentroAutomotivoTO saveCentro(CentroAutomotivoTO centro) {
        centroAutomotivoDAO = new CentroAutomotivoDAO();
        return centroAutomotivoDAO.saveCentro(centro);
    }

    public boolean deleteCentro(String cep) {
        centroAutomotivoDAO = new CentroAutomotivoDAO();
        return centroAutomotivoDAO.deleteCentro(cep);
    }

    public CentroAutomotivoTO updateCentro(CentroAutomotivoTO centro) {
        centroAutomotivoDAO = new CentroAutomotivoDAO();
        return centroAutomotivoDAO.updateCentro(centro);
    }
}
