package br.com.cursojava;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RepositorioContatoTest {
	
	@Test
	public void testAdicionar(){
		RepositorioContato repositorio = new RepositorioContatoMemory();
		int quantidade = repositorio.buscarTodos().size();
		Assert.assertEquals(0, quantidade);
		repositorio.adicionar(new Contato(null,"Contato01","contato01@teste.com","33221100",TipoContato.AMIGO));
		quantidade = repositorio.buscarTodos().size();
		Assert.assertEquals(1, quantidade);
	}
	
	@Test
	public void testAdicionar02(){
		RepositorioContato repositorio = new RepositorioContatoMemory();
		int quantidade = repositorio.buscarTodos().size();
		Assert.assertEquals(0, quantidade);
		repositorio.adicionar(new Contato(null,"Contato01","contato01@teste.com","33221100",TipoContato.AMIGO));
		Assert.assertTrue(repositorio.buscarTodos().get(0).getId() != null);
	}
	
	@Test
	public void testEditar(){
		RepositorioContato repositorio = new RepositorioContatoMemory();
		repositorio.adicionar(new Contato(null,"Contato01","contato01@teste.com","33221100",TipoContato.AMIGO));
		Integer id = repositorio.buscarTodos().get(0).getId();
		Contato contato = new Contato(id,"NomeAlterado","","",TipoContato.FAMILIA);
		repositorio.editar(contato);
		Contato alterado = repositorio.buscarTodos().get(0);
		Assert.assertEquals(contato.getId(), alterado.getId());
		Assert.assertEquals(contato.getNome(), alterado.getNome());
		Assert.assertEquals(contato.getEmail(), alterado.getEmail());
		Assert.assertEquals(contato.getTelefone(), alterado.getTelefone());
		Assert.assertEquals(contato.getTipo(), alterado.getTipo());
		
	}
	
	@Test
	public void testBuscarTodos(){
		RepositorioContato repositorio = new RepositorioContatoMemory();
		int quantidade = repositorio.buscarTodos().size();
		Assert.assertEquals(0, quantidade);
		repositorio.adicionar(new Contato(null,"Contato01","contato01@teste.com","33221100",TipoContato.AMIGO));
		quantidade = repositorio.buscarTodos().size();
		Assert.assertEquals(1, quantidade);
	}
	
	@Test
	public void testBuscarPorNome(){
		RepositorioContato repositorio = new RepositorioContatoMemory();
		repositorio.adicionar(new Contato(null,"Contato01","contato01@teste.com","33221101",TipoContato.AMIGO));
		repositorio.adicionar(new Contato(null,"Contato02","contato02@teste.com","33221102",TipoContato.AMIGO));
		repositorio.adicionar(new Contato(null,"Contato03","contato03@teste.com","33221103",TipoContato.AMIGO));
		
		List<Contato> filtrados = repositorio.buscarPorNome("Contato01");
		
		Assert.assertEquals(1, filtrados.size());
		
		
		
	}

}
