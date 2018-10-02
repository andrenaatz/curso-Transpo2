package br.com.cursojava.aula017.colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploList {
	
	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		nomes.add("João");
		nomes.add("Maria");
		nomes.add("Adão");
		nomes.add("Eva");
		
		System.out.println(nomes);
		Collections.sort(nomes);
		System.out.println(nomes);
		Collections.sort(nomes,Collections.reverseOrder());
		System.out.println(nomes);
		
		List<Contato> contatos = new ArrayList<>();
		contatos.add(new Contato());
		contatos.add(new Contato("Maria"));
		contatos.add(new Contato("Adão"));
		contatos.add(new Contato("Eva"));
		contatos.add(new Contato("Eva"));
		
		System.out.println(contatos);
		Collections.sort(contatos);
		System.out.println(contatos);
		Collections.sort(contatos,Collections.reverseOrder());
		System.out.println(contatos);
		
		
	}

}
