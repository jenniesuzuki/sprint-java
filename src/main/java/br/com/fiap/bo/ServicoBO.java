package br.com.fiap.bo;

import br.com.fiap.dao.ServicoDAO;
import br.com.fiap.to.ServicoTO;

import java.util.ArrayList;

public class ServicoBO {
    private ServicoDAO servicoDAO;

    public ArrayList<ServicoTO> findAllServicos() {
        servicoDAO = new ServicoDAO();
        return servicoDAO.findAllServicos();
    }

    public ServicoTO findServicoById(Long idServico)  {
        servicoDAO = new ServicoDAO();
        return servicoDAO.findServicoById(idServico);
    }

    public ServicoTO saveServico(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.saveServico(servico);
    }

    public boolean deleteServico(Long idServico) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.deleteServico(idServico);
    }

    public ServicoTO updateServico(ServicoTO servico) {
        servicoDAO = new ServicoDAO();
        return servicoDAO.updateServico(servico);
    }
}
