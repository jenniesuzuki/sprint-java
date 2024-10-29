package br.com.fiap.dao;

import br.com.fiap.to.ProblemaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaDAO extends Repository{
    public ArrayList<ProblemaTO> findAllProblemas() {
        ArrayList<ProblemaTO> problemas = new ArrayList<ProblemaTO>();
        String sql = "select * from problema order by placa";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProblemaTO problema = new ProblemaTO();
                    problema.setDescricaoProblema(rs.getString("desc_problema"));
                    problema.setPlaca(rs.getString("placa"));
                    problemas.add(problema);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return problemas;
    }

    public ProblemaTO findProblemaByPlaca(String placa) {
        ProblemaTO problema = new ProblemaTO();
        String sql = "select * from problema where placa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                problema.setPlaca(rs.getString("placa"));
                problema.setDescricaoProblema(rs.getString("desc_problema"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problema;
    }

    public ProblemaTO saveProblema(ProblemaTO problema) {
        String sql = "insert into problema(desc_problema, placa) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema.getDescricaoProblema());
            ps.setString(2, problema.getPlaca());
            if (ps.executeUpdate() > 0) {
                return problema;
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

    public boolean deleteProblema(String placa) {
        String sql = "delete from problema where placa = ?";
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

    public ProblemaTO updateProblema(ProblemaTO problema) {
        String sql = "update problema set desc_problema=? where placa=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema.getDescricaoProblema());
            ps.setString(2, problema.getPlaca());
            if (ps.executeUpdate() > 0) {
                return problema;
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
