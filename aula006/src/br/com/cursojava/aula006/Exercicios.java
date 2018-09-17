package br.com.cursojava.aula006;

import java.util.Scanner;

public class Exercicios {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
//		exercicio03();
//		exercicio04(teclado);
//		exercicio05();
//		exercicio06();
		exercicio07(teclado);
		teclado.close();
	}

	public static void exercicio03() {
		int soma = 0;
		int numero = 1;
		while (numero <= 50) {
			soma += numero;
			numero++;
		}
		System.out.println("O resultado da soma é " + soma);
		System.out.println("Fim do Exercício");
	}
	
	public static void exercicio04(Scanner teclado) {
		double nota1 = 0;
		double nota2 = 0;
		double nota3 = 0;
		double media = 0;
		System.out.println("Digite a primeira nota");
		nota1 = Double.parseDouble(teclado.nextLine());
		while (nota1 >= 0) {
			System.out.println("Digite a segunda nota");
			nota2 = Double.parseDouble(teclado.nextLine());

			System.out.println("Digite a terceira nota");
			nota3 = Double.parseDouble(teclado.nextLine());

			media = (nota1 + nota2 + nota3) / 3;
			System.out.println("########## Resultado ##########");
			System.out.println("A média das notas informadas é " + media);
			System.out.println("###################");

			System.out.println("Digite a primeira nota");
			nota1 = Double.parseDouble(teclado.nextLine());
		}
		System.out.println("Fim do Exercício");
	}

	public static void exercicio05() {
		int numero = 1;
		while (numero <= 100) {
			if(numero %2 != 0){
				System.out.println(numero);
			}
			numero ++;
		}
		System.out.println("Fim do Exercício");

	}
	
	public static void exercicio06() {
		int numero = 1;
		boolean primo = true;
		while (numero <= 50) {
			int divisor = 2;
			primo = true;
			while (divisor < numero) {
				if (numero % divisor == 0 ) {
					primo = false;
					break;
				}
				divisor++;
			}
			if (primo) {
				System.out.print(numero + ", ");
			}
			numero++;
		}
		System.out.println("");
		System.out.println("Fim do Exercício");

	}

	public static void exercicio07(Scanner teclado) {
		int opcao = -1;
		while (opcao != 4) {
			System.out.println("1 - Cadastrar Aluno");
			System.out.println("2 - Cadastrar Professor");
			System.out.println("3 - Cadastrar Turma");
			System.out.println("4 - Sair");
			opcao = Integer.parseInt(teclado.nextLine());
			switch (opcao) {
			case 1:
				System.out.println("Escolheu a opção Cadastrar Aluno");
				break;
			case 2:
				System.out.println("Escolheu a opção Cadastrar Professor");
				break;
			case 3:
				System.out.println("Escolheu a opção Cadastrar Turma");
				break;
			case 4:
				System.out.println("Fim do Exercício!");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
	}

}
