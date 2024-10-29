package br.com.fiap.dao;

import br.com.fiap.to.OrcamentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrcamentoDAO extends Repository{
    public ArrayList<OrcamentoTO> findAllOrcamentos() {
        ArrayList<OrcamentoTO> orcamentos = new ArrayList<OrcamentoTO>();
        String sql = "select * from orcamento order by id_servico";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OrcamentoTO orcamento = new OrcamentoTO();
                    orcamento.setIdServico(rs.getLong("id_servico"));
                    orcamento.setValorProduto(rs.getFloat("valor_produto"));
                    orcamento.setQuantidade(rs.getInt("quantidade"));
                    orcamento.setMaoDeObra(rs.getFloat("mao_de_obra"));
                    orcamentos.add(orcamento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamentos;
    }

    public OrcamentoTO findByIdServico(Long idServico) {
        OrcamentoTO orcamento = new OrcamentoTO();
        String sql = "select * from orcamento where id_servico = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idServico);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orcamento.setIdServico(rs.getLong("id_servico"));
                orcamento.setValorProduto(rs.getFloat("valor_produto"));
                orcamento.setQuantidade(rs.getInt("quantidade"));
                orcamento.setMaoDeObra(rs.getFloat("mao_de_obra"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return orcamento;
    }

    public OrcamentoTO saveOrcamento(OrcamentoTO orcamento) {
        String sql = "insert into orcamento(valor_produto, quantidade, mao_de_obra, id_servico) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setFloat(1, orcamento.getValorProduto());
            ps.setInt(2, orcamento.getQuantidade());
            ps.setFloat(3, orcamento.getMaoDeObra());
            ps.setLong(4, orcamento.getIdServico());
            if (ps.executeUpdate() > 0) {
                return orcamento;
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

    public boolean deleteOrcamento(Long idServico) {
        String sql = "delete from orcamento where id_servico = ?";
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

    public OrcamentoTO updateOrcamento(OrcamentoTO orcamento) {
        String sql = "update orcamento set valor_produto=?, quantidade=?, mao_de_obra=? where id_servico=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setFloat(1, orcamento.getValorProduto());
            ps.setInt(2, orcamento.getQuantidade());
            ps.setFloat(3, orcamento.getMaoDeObra());
            ps.setLong(4, orcamento.getIdServico());
            if (ps.executeUpdate() > 0) {
                return orcamento;
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
