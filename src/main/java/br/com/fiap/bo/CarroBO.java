package br.com.fiap.bo;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.CarroTO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class CarroBO {
    private CarroDAO carroDAO;

    public ArrayList<CarroTO> findAllCarros() {
        carroDAO = new CarroDAO();
        return carroDAO.findAllCarros();
    }

    public CarroTO findByPlaca(String placa) {
        carroDAO = new CarroDAO();
        return carroDAO.findByPlaca(placa);
    }

    public CarroTO saveCarro(CarroTO carro) {
        carroDAO = new CarroDAO();
        return carroDAO.saveCarro(carro);
    }

    public boolean deleteCarro(String placa) {
        carroDAO = new CarroDAO();
        return carroDAO.deleteCarro(placa);
    }

    public CarroTO updateCarro(CarroTO carro) {
        carroDAO = new CarroDAO();
        return carroDAO.updateCarro(carro);
    }
}
