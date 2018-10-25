package br.com.cursojava.aula031;

import java.util.List;

public class ContatoDAOTest {
	
	public static void main(String[] args) {
		
//		Contato c1 =  new Contato(null,"João da Silva", "joao@teste.com","33221100");
//		Contato c2 =  new Contato(null,"Maria", "maria@teste.com","33221111");
		ContatoDAO dao = new ContatoDAO();
//		dao.inserir(c1);
//		dao.inserir(c2);
		
		List<Contato> lista = dao.buscarTodos();
		
		for (Contato contato : lista) {
			System.out.println(contato);
		}
		lista = dao.buscarPorNome("jo");
		for (Contato contato : lista) {
			System.out.println(contato);
		}
		System.out.println(dao.contar());
	}

}
