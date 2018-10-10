package br.com.cursojava.aula023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploStreamFilter {

	public static void main(String[] args) {

		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(1, "Produto 01", 10.0, Categoria.ALIMENTO));
		produtos.add(new Produto(2, "Produto 02", 100.0, Categoria.ELETRONICO));
		produtos.add(new Produto(3, "Produto 03", 90.0, Categoria.LIMPEZA));
		produtos.add(new Produto(4, "Produto 04", 47.90, Categoria.PERFUMARIA));
		produtos.add(new Produto(5, "Produto 05", 29.51, Categoria.VESTUARIO));
		produtos.add(new Produto(6, "Produto 06", 19.90, Categoria.ALIMENTO));
		produtos.add(new Produto(7, "Produto 07", 10.0, Categoria.ELETRONICO));
		produtos.add(new Produto(8, "Produto 08", 10.0, Categoria.LIMPEZA));
		produtos.add(new Produto(9, "Produto 09", 1.0, Categoria.PERFUMARIA));
		produtos.add(new Produto(10, "Produto 10", 89.90, Categoria.VESTUARIO));

		Stream<Produto> streamProdutos = produtos.stream();

		streamProdutos.filter((Produto produto) -> {
			return Categoria.ALIMENTO.equals(produto.getCategoria());
		}).map(p -> p.getNome()).forEach(System.out::println);

		List<Produto> alimentos = produtos
		.stream()
		.filter((Produto produto) -> {
			return Categoria.ALIMENTO.equals(produto.getCategoria());
		})
		.collect(Collectors.toList());
		for (Produto alimento : alimentos) {
			System.out.println(alimento.getNome());
		}
		
		System.out.println("=============================");
		
		List<Produto> menoresQue50 = produtos
				.stream()
				.filter((Produto produto) -> {
					return produto.getPreco() <= 50;
				})
				.collect(Collectors.toList());
				for (Produto prod : menoresQue50) {
					System.out.println(prod.getNome());
				}
				
		List<String> nomesProdutosMaiorQue50 = produtos
				.stream()
				.filter(p -> p.getPreco() > 50)
				.map(p -> p.getNome())
				.collect(Collectors.toList());
		
		for (String nomesProdutos : nomesProdutosMaiorQue50) {
			System.out.println(nomesProdutos);
		}
		
		double total = produtos.stream().mapToDouble(p -> p.getPreco()).sum();
		System.out.printf("O valor total dos produtos é  %.2f\n", total);
		OptionalDouble media = produtos.stream().mapToDouble(p -> p.getPreco()).average();
		System.out.printf("A média de preços é  %.2f\n", media.getAsDouble());
		Map<Categoria,Double> map = new HashMap<>();
		Map<Categoria, Double> totalizador = produtos
				.stream()
				.filter(p -> p.getPreco() < 50)
				.reduce(map,
					   (current,prod)->{
							Double value = current.get(prod.getCategoria());
							if(value == null){
								value = 0.0;
							}
							value += prod.getPreco();
							current.put(prod.getCategoria(), value);
							return current;
					  },
				   (i,j)->{
					return  i;
				});
		for (Map.Entry<Categoria, Double> item : totalizador.entrySet()) {
			System.out.printf("%s = %.2f\n",item.getKey(), item.getValue());
		}
		
		//menor preço
		
		Optional<Produto> produtoMenor = produtos
		.stream()
		.reduce((anterior, atual)->{
			return anterior.getPreco() < atual.getPreco() ? anterior : atual;
		});
		System.out.println("O produto de menor preço é "+produtoMenor.get().getNome());
	}

}






