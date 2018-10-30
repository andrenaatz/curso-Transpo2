package br.com.cursojava.aula035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.com.cursojava.aula031.JPAUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		findWithSubquery(em, builder);

		em.getTransaction().commit();
		em.close();

		JPAUtil.shutdown();
		System.exit(0);
	}
	
	private static void findWithSubquery(EntityManager em, CriteriaBuilder builder){
		CriteriaQuery<Produto> cq = builder.createQuery(Produto.class);
		Root<Produto> root = cq.from(Produto.class);
		
		Subquery<Double> subquery = cq.subquery(Double.class);
		Root<Produto> subRoot = subquery.from(Produto.class);
		subquery = subquery.select(builder.max(subRoot.get("preco")));
		
		CriteriaQuery<Produto> select = cq.select(root).where(builder.equal(root.get("preco"), subquery));
		TypedQuery<Produto> query = em.createQuery(select);
		Produto produto = query.getSingleResult();
		System.out.println("==> "+ produto);
		
	}

	private static void findAll(EntityManager em, CriteriaBuilder builder) {
		CriteriaQuery<Produto> cq = builder.createQuery(Produto.class);
		Root<Produto> root = cq.from(Produto.class);
		CriteriaQuery<Produto> select = cq.select(root);
		TypedQuery<Produto> query = em.createQuery(select);

		List<Produto> produtos = query.getResultList();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	private static void findAllByName(EntityManager em, CriteriaBuilder builder) {
		List<Predicate> condicoes = new ArrayList<Predicate>();

		CriteriaQuery<Produto> cq = builder.createQuery(Produto.class);
		Root<Produto> root = cq.from(Produto.class);

		Path<String> atributoNome = root.get("nome");
		Predicate whereNome = builder.equal(atributoNome, "LG G7");

		condicoes.add(whereNome);

		Predicate where = builder.and(condicoes.toArray(new Predicate[condicoes.size()]));
		CriteriaQuery<Produto> select = cq.where(where);
		TypedQuery<Produto> query = em.createQuery(select);

		List<Produto> produtos = query.getResultList();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	private static void findAllByPrecoGt2000(EntityManager em, CriteriaBuilder builder) {
		List<Predicate> condicoes = new ArrayList<Predicate>();

		CriteriaQuery<Produto> cq = builder.createQuery(Produto.class);
		Root<Produto> root = cq.from(Produto.class);
		ParameterExpression<Double> p = builder.parameter(Double.class);
		CriteriaQuery<Produto> sql = cq.select(root).where(builder.gt(root.get("preco"), p));

		TypedQuery<Produto> query = em.createQuery(sql);
		query.setParameter(p, 2000.0);

		List<Produto> produtos = query.getResultList();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	private static void findNomeEPreco1(EntityManager em, CriteriaBuilder builder) {
		List<Predicate> condicoes = new ArrayList<Predicate>();

		CriteriaQuery<Object[]> cq = builder.createQuery(Object[].class);
		Root<Produto> root = cq.from(Produto.class);
		CriteriaQuery<Object[]> sql = cq.select(builder.array(root.get("nome"), root.get("preco")));

		TypedQuery<Object[]> query = em.createQuery(sql);

		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			System.out.println(Arrays.toString(objects));
		}
	}

	private static void findNomeEPreco2(EntityManager em, CriteriaBuilder builder) {

		CriteriaQuery<Tuple> cq = builder.createTupleQuery();
		Root<Produto> root = cq.from(Produto.class);
		CriteriaQuery<Tuple> sql = cq.select(builder.tuple(root.get("nome"), root.get("preco")));

		TypedQuery<Tuple> query = em.createQuery(sql);

		List<Tuple> resultList = query.getResultList();
		for (Tuple tuple : resultList) {
			System.out.println(tuple.get(0) + " - " + tuple.get(1));

		}
	}

private static void findNomeEPreco3(EntityManager em, CriteriaBuilder builder) {
	
		class NomeEPreco{
			private String nome;
			private double preco;
			
			public NomeEPreco(String nome, double preco) {
				super();
				this.nome = nome;
				this.preco = preco;
			}
			public NomeEPreco() {
				super();
				// TODO Auto-generated constructor stub
			}
			public String getNome() {
				return nome;
			}
			public void setNome(String nome) {
				this.nome = nome;
			}
			public double getPreco() {
				return preco;
			}
			public void setPreco(double preco) {
				this.preco = preco;
			}
			@Override
			public String toString() {
				return "NomeEPreco [nome=" + nome + ", preco=" + preco + "]";
			}
			
			
			
		}
		
		CriteriaQuery<NomeEPreco> cq = builder.createQuery(NomeEPreco.class);
		Root<Produto> root = cq.from(Produto.class);
		CriteriaQuery<NomeEPreco> sql = cq.select(builder.construct(NomeEPreco.class,root.get("nome"), root.get("preco")));
		
		 TypedQuery<NomeEPreco> query = em.createQuery(sql);
		
		
		List<NomeEPreco> resultList = query.getResultList();
		for (NomeEPreco tuple : resultList) {
			System.out.println(tuple);
			
		}
	}

private static void countGroupByMarca(EntityManager em, CriteriaBuilder builder){
	
	class CountByMarca{
		Marca marca;
		Long count;
		public CountByMarca() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CountByMarca(Marca marca, Long count) {
			super();
			this.marca = marca;
			this.count = count;
		}
		@Override
		public String toString() {
			return "CountByMarca [marca=" + marca + ", count=" + count + "]";
		}
		
		
		
		
	}
	CriteriaQuery<CountByMarca> q = builder.createQuery(CountByMarca.class);
	  Root<Produto> c = q.from(Produto.class);
	  q.multiselect(c.get("marca"), builder.count(c.get("marca")));
	  //q.where(cb.isMember("Europe", c.get("continents")));
	  q.groupBy(c.get("marca"));
	  q.having(builder.gt(builder.count(c), 1));
	  
	  TypedQuery<CountByMarca> query = em.createQuery(q);
	  List<CountByMarca> produtos = query.getResultList();
		for (CountByMarca produto : produtos) {
			System.out.println(produto);
		}
}

}
