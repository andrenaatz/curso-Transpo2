package br.com.cursojava.aula031;

import java.math.BigInteger;

import javax.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		Pessoa ana = new Pessoa(4,"Ana Maria da Silva");
		entityManager.getTransaction().begin();
		Pessoa anaSincronizada = entityManager.merge(ana);

		Pessoa p = entityManager.find(Pessoa.class, 5);
		System.out.println(p.getId());
		System.out.println(p.getNome());
		p.setNome("Tibúrcio Brasil");
		
		String sql = "select count(*) from pessoas";
		BigInteger result = (BigInteger) entityManager.createNativeQuery(sql).getSingleResult();

		System.out.println(result.intValue());
		System.out.println(p.getId());
		System.out.println(p.getNome());
		
		entityManager.getTransaction().commit();
		entityManager.close();

		JPAUtil.shutdown();
		System.exit(0);
	}
}
