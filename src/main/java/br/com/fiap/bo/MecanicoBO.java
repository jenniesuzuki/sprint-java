package br.com.fiap.bo;

import br.com.fiap.dao.MecanicoDAO;
import br.com.fiap.to.MecanicoTO;

import java.util.ArrayList;

public class MecanicoBO {
    private MecanicoDAO mecanicoDAO;

    public ArrayList<MecanicoTO> findAllMecanicos() {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.findAllMecanicos();
    }

    public MecanicoTO findMecanicoById(Long idMecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.findMecanicoById(idMecanico);
    }

    public MecanicoTO saveMecanico(MecanicoTO mecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.saveMecanico(mecanico);
    }

    public boolean deleteMecanico(Long idMecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.deleteMecanico(idMecanico);
    }

    public MecanicoTO updateMecanico(MecanicoTO mecanico) {
        mecanicoDAO = new MecanicoDAO();
        return mecanicoDAO.updateMecanico(mecanico);
    }
}
