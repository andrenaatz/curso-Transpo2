package br.com.cursojava;

import java.util.List;

public interface RepositorioContato {

	public boolean adicionar(Contato contato);
	public boolean editar(Contato contato);
	public List<Contato> buscarTodos();
	public List<Contato> buscarPorNome(String nome); 
	public List<Contato> buscarPorTelefone(String telefone); 
	public List<Contato> buscarPorTipo(TipoContato tipo); 
	public Contato buscarPorId(Integer id); 
	public boolean remover(Contato contato);
}
