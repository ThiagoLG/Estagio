package br.sceweb.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.sceweb.servico.FabricaDeConexoes;

public class EmpresaDAO {
	public  int adiciona(Empresa e) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection con = new FabricaDeConexoes().getConnection()) {
			String query = "INSERT INTO empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values (?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, e.getCnpj());
			ps.setString(2, e.getNomeDaEmpresa());
			ps.setString(3, e.getNomeFantasia());
			ps.setString(4, e.getEndereco());
			ps.setString(5, e.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (Exception e2) {
			throw new RuntimeException(e2);
		}
		return codigoRetorno;
	}

	public int remove(String cnpj) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection con = new FabricaDeConexoes().getConnection()) {
			String query = "DELETE FROM empresa WHERE cnpj like ?";
			ps = con.prepareStatement(query);
			ps.setString(1, cnpj);
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	public Empresa consultaEmpresa(String cnpj) {
		Empresa empresa = new Empresa();
		return empresa;
	}
}
