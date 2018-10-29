package br.com.cursojava.aula031;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Tarefa t1 = new Tarefa(null,"tarefa do Bonzao",StatusTarefa.NOVA,new Date(),new Date());
		Usuario u = new Usuario(null,"Tibúrcio Adm","tibadm@teste.com", Arrays.asList(t1));
		t1.setUsuario(u);
		u.addPerfil(PerfilUsuario.BAGRINHO);
		u.addPerfil(PerfilUsuario.MANAGER);
		u.addPerfil(PerfilUsuario.ADMIN);
		entityManager.persist(u);
//		Endereco end = new Endereco(null, "Rua teste", "1000");
//		Funcionario func = new Funcionario(null, "Funcionario 01", end);
//		entityManager.persist(func);
//		
//		Pessoa ana = new Pessoa(4,"Ana Maria da Silva");
//		Pessoa anaSincronizada = entityManager.merge(ana);
//
//		Pessoa p = entityManager.find(Pessoa.class, 5);
//		System.out.println(p.getId());
//		System.out.println(p.getNome());
//		p.setNome("Tibúrcio Brasil");
//		
//		String sql = "select count(*) from pessoas";
//		BigInteger result = (BigInteger) entityManager.createNativeQuery(sql).getSingleResult();
//
//		System.out.println(result.intValue());
//		System.out.println(p.getId());
//		System.out.println(p.getNome());
//		
		entityManager.getTransaction().commit();
		entityManager.close();

		JPAUtil.shutdown();
		System.exit(0);
	}
}
