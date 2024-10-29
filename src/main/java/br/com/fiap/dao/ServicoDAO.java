package br.com.fiap.dao;

import br.com.fiap.to.ServicoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO extends Repository {
    public ArrayList<ServicoTO> findAllServicos() {
        ArrayList<ServicoTO> servicos = new ArrayList<ServicoTO>();
        String sql = "select * from servico order by id_servico";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ServicoTO servico = new ServicoTO();
                    servico.setIdServico(rs.getLong("id_servico"));
                    servico.setDescricaoServico(rs.getString("desc_servico"));
                    servico.setDataServico(rs.getDate("data_servico").toLocalDate());
                    servicos.add(servico);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servicos;
    }

    public ServicoTO findServicoById(Long idServico) {
        ServicoTO servico = new ServicoTO();
        String sql = "select * from servico where id_servico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idServico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servico.setIdServico(rs.getLong("id_servico"));
                servico.setDescricaoServico(rs.getString("desc_servico"));
                servico.setDataServico(rs.getDate("data_servico").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return servico;
    }

    public ServicoTO saveServico(ServicoTO servico) {
        String sql = "insert into servico(desc_servico, data_servico) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getDescricaoServico());
            ps.setDate(2, Date.valueOf(servico.getDataServico()));
            if (ps.executeUpdate() > 0) {
                return servico;
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

    public boolean deleteServico(Long idServico) {
        String sql = "delete from servico where id_servico = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idServico);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public ServicoTO updateServico(ServicoTO servico) {
        String sql = "update servico set desc_servico=?, data_servico=? where id_servico=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, servico.getDescricaoServico());
            ps.setDate(2, Date.valueOf(servico.getDataServico()));
            ps.setLong(3, servico.getIdServico());
            if (ps.executeUpdate() > 0) {
                return servico;
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
