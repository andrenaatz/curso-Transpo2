package br.com.cursojava.aula031;

import java.util.Date;

import javax.persistence.EntityManager;

public class TestesTarefa {
	
public static void main(String[] args) {
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	entityManager.getTransaction().begin();
	
	Tarefa tarefa = new Tarefa();
	tarefa.setTitulo("Minha primeira Tarefa");
	tarefa.setStatus(StatusTarefa.NOVA);
	tarefa.setCriadoEm(new Date());
	tarefa.setAtualizadoEm(new Date());
	entityManager.persist(tarefa);	
	
	entityManager.getTransaction().commit();
	entityManager.close();

	JPAUtil.shutdown();
	System.exit(0);
}

}
