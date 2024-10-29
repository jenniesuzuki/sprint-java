package br.com.fiap.dao;

import br.com.fiap.to.MecanicoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MecanicoDAO extends Repository{
    public ArrayList<MecanicoTO> findAllMecanicos() {
        ArrayList<MecanicoTO> mecanicos = new ArrayList<MecanicoTO>();
        String sql = "select * from mecanico order by id_mecanico";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MecanicoTO mecanico = new MecanicoTO();
                    mecanico.setIdMecanico(rs.getLong("id_mecanico"));
                    mecanico.setNomeMecanico(rs.getString("nome_mecanico"));
                    mecanico.setEspecialidade(rs.getString("especialidade"));
                    mecanicos.add(mecanico);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return mecanicos;
    }

    public MecanicoTO findMecanicoById(Long idMecanico) {
        MecanicoTO mecanico = new MecanicoTO();
        String sql = "select * from mecanico where id_mecanico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idMecanico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mecanico.setIdMecanico(rs.getLong("id_mecanico"));
                mecanico.setNomeMecanico(rs.getString("nome_mecanico"));
                mecanico.setEspecialidade(rs.getString("especialidade"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return mecanico;
    }

    public MecanicoTO saveMecanico(MecanicoTO mecanico) {
        String sql = "insert into mecanico(nome_mecanico, especialidade) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, mecanico.getNomeMecanico());
            ps.setString(2, mecanico.getEspecialidade());
            if (ps.executeUpdate() > 0) {
                return mecanico;
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

    public boolean deleteMecanico(Long idMecanico) {
        String sql = "delete from mecanico where id_mecanico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idMecanico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public MecanicoTO updateMecanico(MecanicoTO mecanico) {
        String sql = "update mecanico set nome_mecanico=?, especialidade=? where id_mecanico=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, mecanico.getNomeMecanico());
            ps.setString(2, mecanico.getEspecialidade());
            ps.setLong(3, mecanico.getIdMecanico());
            if (ps.executeUpdate() > 0) {
                return mecanico;
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
