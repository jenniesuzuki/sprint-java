package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaDAO;
import br.com.fiap.to.ProblemaTO;

import java.util.ArrayList;

public class ProblemaBO {
    private ProblemaDAO problemaDAO;

    public ArrayList<ProblemaTO> findAllProblemas() {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.findAllProblemas();
    }

    public ProblemaTO findProblemaByPlaca(String placa) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.findProblemaByPlaca(placa);
    }

    public ProblemaTO saveProblema(ProblemaTO problema) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.saveProblema(problema);
    }

    public boolean deleteProblema(String placa) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.deleteProblema(placa);
    }

    public ProblemaTO updateProblema(ProblemaTO problema) {
        problemaDAO = new ProblemaDAO();
        return problemaDAO.updateProblema(problema);
    }
}
