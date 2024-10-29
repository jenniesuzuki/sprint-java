package br.com.fiap.dao;

import br.com.fiap.to.AgendamentoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AgendamentoDAO extends Repository {
    public ArrayList<AgendamentoTO> findAllAgendamentos() {
        ArrayList<AgendamentoTO> agendamentos = new ArrayList<AgendamentoTO>();
        String sql = "select * from agendamento order by id_agendamento";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AgendamentoTO agendamento = new AgendamentoTO();
                    agendamento.setIdAgendamento(rs.getLong("id_agendamento"));
                    agendamento.setData(rs.getDate("data").toLocalDate());
                    agendamento.setPlaca(rs.getString("placa"));
                    agendamentos.add(agendamento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamentos;
    }

    public AgendamentoTO findById(Long idAgendamento) {
        AgendamentoTO agendamento = new AgendamentoTO();
        String sql = "select * from agendamento where id_agendamento = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idAgendamento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                agendamento.setIdAgendamento(rs.getLong("id_agendamento"));
                agendamento.setData(rs.getDate("data").toLocalDate());
                agendamento.setPlaca(rs.getString("placa"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamento;
    }

    public AgendamentoTO saveAgendamento(AgendamentoTO agendamento) {
        String sql = "insert into agendamento(data, placa) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(agendamento.getData()));
            ps.setString(2, agendamento.getPlaca());
            if (ps.executeUpdate() > 0) {
                return agendamento;
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

    public boolean deleteAgendamento(Long idAgendamento) {
        String sql = "delete from agendamento where id_agendamento = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idAgendamento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AgendamentoTO updateAgendamento(AgendamentoTO agendamento) {
        String sql = "update agendamento set data=?, placa = ? where id_agendamento=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(agendamento.getData()));
            ps.setString(2, agendamento.getPlaca());
            ps.setLong(3, agendamento.getIdAgendamento());
            if (ps.executeUpdate() > 0) {
                return agendamento;
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
