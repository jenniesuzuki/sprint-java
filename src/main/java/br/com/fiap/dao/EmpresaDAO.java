package br.com.fiap.dao;

import br.com.fiap.to.EmpresaTO;
import br.com.fiap.to.PecasTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO extends Repository {
    public ArrayList<EmpresaTO> findAllInfos() {
        ArrayList<EmpresaTO> infos = new ArrayList<EmpresaTO>();
        String sql = "select * from empresa order by id_empresa";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    EmpresaTO empresa = new EmpresaTO();
                    empresa.setIdEmpresa(rs.getLong("id_empresa"));
                    empresa.setNomeEmpresa(rs.getString("nome_empresa"));
                    empresa.setInformacoesEmpresa(rs.getString("infos_empresa"));
                    infos.add(empresa);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return infos;
    }

    public EmpresaTO findByIdEmpresa(Long idEmpresa) {
        EmpresaTO empresa = new EmpresaTO();
        String sql = "select * from empresa where id_empresa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, idEmpresa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empresa.setIdEmpresa(rs.getLong("id_empresa"));
                empresa.setNomeEmpresa(rs.getString("nome_empresa"));
                empresa.setInformacoesEmpresa(rs.getString("infos_empresa"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return empresa;
    }

    public EmpresaTO saveEmpresa(EmpresaTO empresa) {
        String sql = "insert into empresa(nome_empresa, infos_empresa) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setString(2, empresa.getInformacoesEmpresa());
            if (ps.executeUpdate() > 0) {
                return empresa;
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

    public boolean deleteEmpresa(Long idEmpresa) {
        String sql = "delete from empresa where id_empresa = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, idEmpresa);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public EmpresaTO updateEmpresa(EmpresaTO empresa) {
        String sql = "update empresa set nome_empresa=?, infos_empresa=? where id_empresa=?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, empresa.getNomeEmpresa());
            ps.setString(2, empresa.getInformacoesEmpresa());
            ps.setLong(3, empresa.getIdEmpresa());
            if (ps.executeUpdate() > 0) {
                return empresa;
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
