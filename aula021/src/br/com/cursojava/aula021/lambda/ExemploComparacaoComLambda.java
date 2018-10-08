package br.com.cursojava.aula021.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExemploComparacaoComLambda {
	public static void main(String[] args) {
		
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Feijão", 4.90));
		produtos.add(new Produto("Macarrão", 3.68));
		produtos.add(new Produto("Leite", 2.75));
		produtos.add(new Produto("Café", 8.90));
		produtos.add(new Produto("Margarina", 3.57));
		produtos.add(new Produto("Arroz", 3.50));
		System.out.println(produtos);
		Collections.sort(produtos);
		System.out.println(produtos);
		produtos.sort((o1,o2) -> {
			if(o1 != null){
				if(o2 != null){
					return Double.compare(o1.getPreco(), o2.getPreco());
				}else{
					return -1;
				}
			}
			return 1;
	});
		System.out.println(produtos);
	}

}
