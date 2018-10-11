package br.com.cursojava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioContatoMemory  implements RepositorioContato{

	private List<Contato> contatos = new ArrayList<>();
	private static int count = 1;
	@Override
	public boolean adicionar(Contato contato) {
		boolean resultado = false;
		if(contato != null){
			contato.setId(count++);
			resultado = contatos.add(contato);
		}
		return resultado;
	}

	@Override
	public boolean editar(Contato contato) {
		boolean resultado = false;
		Optional<Contato> data = contatos.stream().filter((c)-> c.getId().equals(contato.getId())).findFirst();
		if(data.isPresent()){
			Contato atualiza = data.get();
			atualiza.setNome(contato.getNome());
			atualiza.setEmail(contato.getEmail());
			atualiza.setTelefone(contato.getTelefone());
			atualiza.setTipo(contato.getTipo());
			resultado = true;
		}
		return resultado;
	}

	@Override
	public List<Contato> buscarTodos() {
		return contatos;
	}

	@Override
	public List<Contato> buscarPorNome(String nome) {
		List<Contato> contatosPorNome = contatos
				.stream()
				.filter((contato)-> nome != null && nome.equals(contato.getNome()))
				.collect(Collectors.toList());
		return contatosPorNome;
	}

	@Override
	public List<Contato> buscarPorTelefone(String telefone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarPorTipo(TipoContato tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contato buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(Contato contato) {
		// TODO Auto-generated method stub
		return false;
	}

}
