package br.com.cursojava.aula013;

import java.util.Arrays;

public class ContatoController {

	private ContatoRepositorio repositorio = new ContatoRepositorio();

	public boolean adicionarContato(String nome, String email, String telefone) {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		return repositorio.adicionarContato(contato);
	}

	public boolean isNomeValido(String nome) {
		boolean valido = nome !=null && !"".equals(nome.trim()) && nome.length() >=3;
		return valido;
	}

	public Contato[] buscarTodos() {
		
		return repositorio.buscarTodos();
	}

	public Contato[] filtrarPorNome(String nome) {
		int quantidade = 0;
		Contato[] todos = buscarTodos();
		Contato[] lista = new Contato[todos.length];
		for (Contato contato : todos) {
			if(contato != null && contato.getNome() != null && contato.getNome().startsWith(nome)){
				lista[quantidade++] = contato;
			}
		}
		return Arrays.copyOf(lista, quantidade);
	}

}
