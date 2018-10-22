package br.com.cursojava.aula029;

import java.util.List;

public class ContatoDAOTest {

	public static void main(String[] args) {
		ContatoDAO dao = new ContatoDAO();
		int qt = dao.contar();
		System.out.println("Quantidade = "+qt);
		Contato contato1 = new Contato(null,"Tiburcio","tib@teste.com","33221100");
		Contato contato2 = new Contato(null,"Pedro","pedro@teste.com","33221111");
		Contato contato3 = new Contato(null,"Tiago","tiago@teste.com","33221122");
		System.out.println("Inserindo contatos ...");
		dao.inserir(contato1);
		dao.inserir(contato2);
		dao.inserir(contato3);
		qt = dao.contar();
		System.out.println("Quantidade = "+qt);
		System.out.println("Listando todos os contatos...");
		List<Contato> lista = dao.buscarTodos();
		for (Contato contato : lista) {
			System.out.println(contato);
		}
		
		System.out.println("Procurando contatos por nome ...");
		lista = dao.buscarPorNome("Ti");
		for (Contato contato : lista) {
			System.out.println(contato);
		}
		
		System.out.println("Buscando contatos por telefone");
		System.out.println(dao.buscarPorTelefone("33221122"));
		
		System.out.println("Buscando contatos por id");
		System.out.println(dao.buscarPorId(contato2.getId()));
		
		System.out.println("Atualizando contato...");
		System.out.println(contato3);
		contato3.setNome("Tiago da Silva");
		dao.atualizar(contato3);
		System.out.println(dao.buscarPorId(contato3.getId()));
		
		System.out.println("Removendo contatos ...");
		dao.remover(contato1.getId());
		qt = dao.contar();
		System.out.println("Quantidade = "+qt);
		dao.remover(contato2.getId());
		qt = dao.contar();
		System.out.println("Quantidade = "+qt);
		dao.remover(contato3.getId());
		
		qt = dao.contar();
		System.out.println("Quantidade = "+qt);
		
		
	}
}
