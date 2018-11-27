package br.com.cursojava.contatos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioContato {

	private static List<Contato> lista = new ArrayList<>();
	private static Integer count = 1;
	static{
		lista.add(new Contato(count++, "João", "joao@test.com", "33220011"));
		lista.add(new Contato(count++, "Maria", "maria@test.com", "33220022"));
		lista.add(new Contato(count++, "Adão", "adao@test.com", "33220033"));
		lista.add(new Contato(count++, "Eva", "eva@test.com", "33220044"));
		lista.add(new Contato(count++, "Priscila", "pri@test.com", "33220055"));
	}
	
	public List<Contato> buscarTodos(){
		return lista;
	}
	
	public Contato buscarPorId(Integer id){
		Contato contato = null;
		for (Contato atual : lista) {
			if(atual != null && id.equals(atual.getId())){
				contato = atual;
				break;
			}
		}
		return contato;
	}
	
	public boolean salvar(Contato contato){
		boolean resultado = false;
		if(contato != null){
			if(contato.getId() == null){
				resultado = inserir(contato);
			}else{
				resultado = atualizar(contato);
			}
		}
		return resultado;
	}

	private boolean inserir(Contato contato) {
		contato.setId(count++);
		return lista.add(contato);
	}

	private boolean atualizar(Contato contato) {
		boolean resultado = false;
		int idx = lista.indexOf(contato);
		if(idx > -1){
			lista.set(idx, contato);
			resultado = true;
		}
		return resultado;
	}
	
	public boolean remover(Integer id){
		int qt = lista.size();
		lista = lista.stream().filter(c -> !id.equals(c.getId())).collect(Collectors.toList());
		return qt > lista.size();
	}
}







