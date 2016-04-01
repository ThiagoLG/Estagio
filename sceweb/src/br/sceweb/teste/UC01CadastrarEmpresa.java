package br.sceweb.teste;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;

	
	@BeforeClass
	public static void setUpBeforeClass()throws Exception{
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setCnpj("123456");
		empresa.setEndereco("Rua xxxxxxx");
		empresa.setNomeDaEmpresa("Nome yyyyyy");
		empresa.setNomeFantasia("Fantasia pppppppp");
		empresa.setTelefone("25648795");
	}
	
	@Test
	public void CT01UC01Cadastrar_empresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		assertEquals(1, empresaDAO.remove(empresa.getCnpj()));
	}

}
