package br.com.cursojava.aula031;

import javax.persistence.EntityManager;

public class Testes {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
//		Endereco end = new Endereco(null, "Rua teste3", "1003");
//		Funcionario func = new Funcionario(null, "Funcionario 03", end);
		//entityManager.persist(end);
//		entityManager.persist(func);
//		Funcionario funcionario = entityManager.find(Funcionario.class, 2);
//		System.out.println(funcionario.getId());
//		System.out.println(funcionario.getNome());
//		System.out.println("Mostrar os dados do endereço...");
//		System.out.println(funcionario.getEndereco().getRua());
		Endereco endereco = em.find(Endereco.class, 1);
		System.out.println(endereco.getFuncionario());
		em.getTransaction().commit();
		em.close();
		

		JPAUtil.shutdown();
		System.exit(0);
	}
}
