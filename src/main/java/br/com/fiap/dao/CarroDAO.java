package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository{
    public ArrayList<CarroTO> findAllCarros() {
        ArrayList<CarroTO> carros = new ArrayList<CarroTO>();
        String sql = "select * from carro order by placa";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CarroTO carro = new CarroTO();
                    carro.setPlaca(rs.getString("placa"));
                    carro.setModelo(rs.getString("modelo"));
                    carro.setCpf(rs.getString("cpf"));
                    carros.add(carro);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carros;
    }

    public CarroTO findByPlaca(String placa) {
        CarroTO carro = new CarroTO();
        String sql = "select * from carro where placa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carro.setPlaca(rs.getString("placa"));
                carro.setModelo(rs.getString("modelo"));
                carro.setCpf(rs.getString("cpf"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return carro;
    }

    public CarroTO saveCarro(CarroTO carro) {
        String sql = "insert into carro(placa, modelo, cpf) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getCpf());
            if (ps.executeUpdate() > 0) {
                return carro;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean deleteCarro(String placa) {
        String sql = "delete from carro where placa = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, placa);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public CarroTO updateCarro(CarroTO carro) {
        String sql = "update carro set modelo=?, cpf=? where placa=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getCpf());
            ps.setString(3, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return carro;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
