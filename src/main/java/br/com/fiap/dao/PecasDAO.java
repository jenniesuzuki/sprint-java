package br.com.fiap.dao;

import br.com.fiap.to.PecasTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecasDAO extends Repository{
    public ArrayList<PecasTO> findAllPecas() {
        ArrayList<PecasTO> pecas = new ArrayList<PecasTO>();
        String sql = "select * from pecas order by id_peca";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PecasTO peca = new PecasTO();
                    peca.setIdPeca(rs.getLong("id_peca"));
                    peca.setNomePeca(rs.getString("nome_peca"));
                    peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                    peca.setValorPeca(rs.getFloat("valor_peca"));
                    pecas.add(peca);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pecas;
    }

    public PecasTO findByIdPeca(Long idPeca) {
        PecasTO peca = new PecasTO();
        String sql = "select * from pecas where id_peca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idPeca);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                peca.setIdPeca(rs.getLong("id_peca"));
                peca.setNomePeca(rs.getString("nome_peca"));
                peca.setQuantidadePeca(rs.getInt("quantidade_peca"));
                peca.setValorPeca(rs.getFloat("valor_peca"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return peca;
    }

    public PecasTO savePeca(PecasTO peca) {
        String sql = "insert into pecas(nome_peca, quantidade_peca, valor_peca) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNomePeca());
            ps.setInt(2, peca.getQuantidadePeca());
            ps.setFloat(3, peca.getValorPeca());
            if (ps.executeUpdate() > 0) {
                return peca;
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

    public boolean deletePeca(Long idPeca) {
        String sql = "delete from pecas where id_peca = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idPeca);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public PecasTO updatePeca(PecasTO peca) {
        String sql = "update pecas set nome_peca=?, quantidade_peca=?, valor_peca=? where id_peca=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNomePeca());
            ps.setInt(2, peca.getQuantidadePeca());
            ps.setFloat(3, peca.getValorPeca());
            ps.setLong(4, peca.getIdPeca());
            if (ps.executeUpdate() > 0) {
                return peca;
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
