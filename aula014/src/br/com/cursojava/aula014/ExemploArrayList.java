package br.com.cursojava.aula014;

import java.util.ArrayList;

public class ExemploArrayList {
	
	public static void main(String[] args) {
		
		//definir uma lista de nomes
		ArrayList<String> listaNomes = new ArrayList<>();
		
		//quantos elementos tem a lista?
		int quantidadeInicial = listaNomes.size();
		System.out.println(quantidadeInicial);
		
		//adicionar elementos
		listaNomes.add("João"); //adiciona um elemento ao final da lista
		System.out.println(listaNomes.size());
		
		listaNomes.add("Maria");//adiciona um elemento ao final da lista
		System.out.println(listaNomes.size());
		System.out.println(listaNomes);
		
		listaNomes.add(0,"Adão");//adiciona um elemento em um índice específico
		System.out.println(listaNomes);
		listaNomes.add(1,"Eva");
		System.out.println(listaNomes);
		
		listaNomes.set(1, "Eva Maria da Silva");// altera um elemento da lista
		System.out.println(listaNomes);
		
		System.out.println(listaNomes.get(2));//Busca um elemento da lista de acordo com o índice
		System.out.println(listaNomes.get(3));
		
		System.out.println(listaNomes.remove(1));
		System.out.println(listaNomes);
		System.out.println(listaNomes.remove("João"));
		System.out.println(listaNomes);
		System.out.println(listaNomes.remove("João"));
		System.out.println(listaNomes);
		
		System.out.println(listaNomes.indexOf("Adão"));
		System.out.println(listaNomes.indexOf("Eva"));
		
	}

}
