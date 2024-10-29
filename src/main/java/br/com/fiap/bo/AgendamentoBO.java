package br.com.fiap.bo;

import br.com.fiap.dao.AgendamentoDAO;
import br.com.fiap.to.AgendamentoTO;

import java.util.ArrayList;

public class AgendamentoBO {
    private AgendamentoDAO agendamentoDAO;

    public ArrayList<AgendamentoTO> findAllAgendamentos() {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.findAllAgendamentos();
    }

    public AgendamentoTO findById(Long idAgendamento) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.findById(idAgendamento);
    }

    public AgendamentoTO saveAgendamento(AgendamentoTO agendamento) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.saveAgendamento(agendamento);
    }

    public boolean deleteAgendamento(Long idAgendamento) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.deleteAgendamento(idAgendamento);
    }

    public AgendamentoTO updateAgendamento(AgendamentoTO agendamento) {
        agendamentoDAO = new AgendamentoDAO();
        return agendamentoDAO.updateAgendamento(agendamento);
    }
}
