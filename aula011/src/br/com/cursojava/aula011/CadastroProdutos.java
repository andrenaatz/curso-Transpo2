package br.com.cursojava.aula011;

import java.util.Scanner;

public class CadastroProdutos {

	private static final int SAIR = 5;
	ProdutoController controller = new ProdutoController();

	public void mostrarMenu(Scanner teclado) {

		int opcao = 0;
		do {
			System.out.println("========== MENU PRINCIPAL ===========");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Listar Produtos");
			System.out.println("3 - Somar produtos");
			System.out.println("4 - Listar Produtos por preço");
			System.out.println("5 - Saír");
			opcao = Integer.parseInt(teclado.nextLine());
			tratarOpcao(opcao, teclado);

		} while (opcao != SAIR);
	}

	private void tratarOpcao(int opcao, Scanner teclado) {
		switch (opcao) {
		case 1:
			cadastrarProduto(teclado);
			break;
		case 2:
			listarProdutos();
			break;
		case 3:
			somarProdutos();
			break;
		case 4:
			filtrarPorPreco(teclado);
			break;
		case 5:
			System.out.println("Obrigado por usar nossos terminais.");
			break;
		default:
			System.out.println("Opção inválida");
		}

	}

	private void somarProdutos() {
		System.out.println("========== SOMAR PRODUTOS ===========");
		double soma = controller.somaProdutos();
		System.out.printf("A soma dos produtos cadastrados é %.2f \n",soma);
	}

	private void filtrarPorPreco(Scanner teclado) {
		//pedir para o usuário informar um preço mínimo
		System.out.println("Informe o preço mínimo do produto");
		//ler o preço mínimo
		double precoMinimo = Double.parseDouble(teclado.nextLine()); 
		//percorrer a lista mostrando apenas os produtos com valor maior ou igual ao preço mínimo
		Produto[] produtos = controller.listarProdutosPorPrecoMinimo(precoMinimo);
		if(produtos != null && produtos.length > 0){
			for (Produto atual : produtos) {
				System.out.printf("%.2f - %s \n", atual.getPreco(),atual.getNome());
			}
		}else{
			System.out.println("Não existem produtos com o preço mínimo informado ");
		}
		
		
	}

	private void cadastrarProduto(Scanner teclado) {
		System.out.println("========== CADASTRAR PRODUTO ===========");
		System.out.println("Informe o nome do produto");
		String nome = teclado.nextLine();
		System.out.println("Informe o preço do produto");
		double preco = Double.parseDouble(teclado.nextLine());
		boolean ok = controller.adicionar(nome, preco);
		if(ok){
			System.out.println("Produto adicionado com sucesso");
		}else{
			System.out.println("Não foi possível adicionar o produto");
		}
	}

	private void listarProdutos() {
		System.out.println("========== LISTA PRODUTOS ===========");
		Produto atual = null;
		Produto[] produtos = controller.listarProdutos();
		for(int index = 0; index < produtos.length; index++){
			atual = produtos[index];
			System.out.printf("%d - %.2f - %s \n",index+1, atual.getPreco(),atual.getNome());
		}
	}

}
