package br.com.fiap.dao;

import br.com.fiap.bo.CentroAutomotivoBO;
import br.com.fiap.to.CentroAutomotivoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CentroAutomotivoDAO extends Repository{
    public ArrayList<CentroAutomotivoTO> findAllCentros() {
        ArrayList<CentroAutomotivoTO> centros = new ArrayList<CentroAutomotivoTO>();
        String sql = "select * from centro_automotivo order by nome_centro";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    CentroAutomotivoTO centro = new CentroAutomotivoTO();
                    centro.setNomeCentro(rs.getString("nome_centro"));
                    centro.setCep(rs.getString("cep"));
                    centro.setEndereco(rs.getString("endereco"));
                    centros.add(centro);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return centros;
    }

    public CentroAutomotivoTO findByCep(String cep) {
        CentroAutomotivoTO centro = new CentroAutomotivoTO();
        String sql = "select * from centro_automotivo where cep = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cep);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                centro.setCep(rs.getString("cep"));
                centro.setNomeCentro(rs.getString("nome_centro"));
                centro.setEndereco(rs.getString("endereco"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return centro;
    }

    public CentroAutomotivoTO saveCentro(CentroAutomotivoTO centro) {
        String sql = "insert into centro_automotivo(nome_centro, cep, endereco) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, centro.getNomeCentro());
            ps.setString(2, centro.getCep());
            ps.setString(3, centro.getEndereco());
            if (ps.executeUpdate() > 0) {
                return centro;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean deleteCentro(String cep) {
        String sql = "delete from centro_automotivo where cep = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, cep);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public CentroAutomotivoTO updateCentro(CentroAutomotivoTO centro) {
        String sql = "update centro_automotivo set nome_centro=?, endereco=? where cep=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, centro.getNomeCentro());
            ps.setString(2, centro.getEndereco());
            ps.setString(3, centro.getCep());
            if (ps.executeUpdate() > 0) {
                return centro;
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
