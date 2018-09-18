package br.com.cursojava.aula007;

import java.util.Scanner;

public class Exercicios {
	
	public static void main(String[] args) {
		Scanner teclado  = new Scanner(System.in);
		exercicio04(teclado);
		teclado.close();
	}
	
	public static void exercicio01(Scanner teclado){
		long fatorial = 1;
		int numero = -1;
		do{
			System.out.println("Digite um número entre 1 e 20");
			numero = Integer.parseInt(teclado.nextLine());
		}while(numero < 1 || numero > 20);
		
		for(int i = 1; i <= numero; i++){
			fatorial *= i;
		}
		System.out.println(fatorial);
	}
	public static void exercicio02(){
		for(int i = 100; i<=200; i+=2){
			System.out.println(i);
		}
	}
	public static void exercicio03(Scanner teclado){
		int maior = 0;
		int numero = 0;
		for(int i = 1; i<=5; i++){
			System.out.printf("Digite o %dº número:\n",i);
			numero = Integer.parseInt(teclado.nextLine());
			if(i == 1 || maior < numero){
				maior = numero;
			}
		}
		System.out.println("O maior número foi "+maior);
	}
	public static void exercicio04(Scanner teclado){
		int soma = 0;
		int nota = 0;
		for(int i = 1; i<=5; i++){
			System.out.printf("Digite o %dª nota:\n",i);
			nota = Integer.parseInt(teclado.nextLine());
			soma += nota;
		}
		double media = soma /5.0;
		System.out.println("O soma das notas foi "+soma);
		System.out.println("O média das notas foi "+media);
	}
	public static void exercicio05(Scanner teclado){
		System.out.println("Digite uma frase");
		String frase = teclado.nextLine();
		for(int i = 0; i < frase.length(); i++){
			if(i % 2 != 0) {
				System.out.print(frase.charAt(i));
			}
		}
	}
	public static void exercicio06(Scanner teclado){
		System.out.println("Digite uma palavra");
		String palavra = teclado.nextLine();
		for(int i = palavra.length()-1; i >= 0; i--){
			System.out.print(palavra.charAt(i));
		}
	}
	
	public static void exercicio07(){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j<=i;j++){
				System.out.print("X");
			}
			System.out.println("");
		}
	}
	public static void exercicio08(){
		for(int i = 4; i >=0; i--){
			for(int j = 0; j<=i;j++){
				System.out.print("#");
			}
			System.out.println("");
		}
	}
	
	

}
