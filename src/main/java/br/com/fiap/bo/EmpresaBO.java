package br.com.fiap.bo;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.to.EmpresaTO;

import java.util.ArrayList;

public class EmpresaBO {
    private EmpresaDAO empresaDAO;

    public ArrayList<EmpresaTO> findAllInfos() {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findAllInfos();
    }

    public EmpresaTO findByIdEmpresa(Long idEmpresa) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findByIdEmpresa(idEmpresa);
    }

    public EmpresaTO saveEmpresa(EmpresaTO empresa) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.saveEmpresa(empresa);
    }

    public boolean deleteEmpresa(Long idEmpresa) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.deleteEmpresa(idEmpresa);
    }

    public EmpresaTO updateEmpresa(EmpresaTO empresa) {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.updateEmpresa(empresa);
    }
}
