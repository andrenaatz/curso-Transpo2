package br.com.cursojava.contato;

import java.util.List;

public class ContatoFacade {

	private RepositorioContato repositorio = new RepositorioContato();
	
	public List<Contato> carregarContatos() {
		return repositorio.buscarTodos();
	}

	public Contato carregarContato(Integer id) {
		return repositorio.buscarPorId(id);
	}

	public Contato novoContato() {
		return new Contato();
	}

	public boolean salvar(Contato contatoAtual) {
		return repositorio.salvar(contatoAtual);
	}

}
