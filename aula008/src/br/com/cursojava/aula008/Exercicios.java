package br.com.cursojava.aula008;

import java.util.Scanner;

public class Exercicios {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		exercicio03(teclado);
		teclado.close();
	}
	
	public static void exercicio01(Scanner teclado){
		double[] notas = new double[3];
		double media = 0;
		for(int index = 0; index < notas.length; index++){
			System.out.printf("Informe a %dª nota:\n",index+1);
			notas[index] = Double.parseDouble(teclado.nextLine());
			media += notas[index];
		}
		media /=notas.length;
		System.out.println("As notas informadas foram:");
		for (double nota : notas) {
			System.out.print(nota +" ");
		}
		System.out.println("");
		System.out.println("O valor da média é "+media);
	}
	
	public static void exercicio02(Scanner teclado){
		int[] notas = {1,3,2};
		for (int nota : notas) {
			System.out.print(nota +" ");
		}
		
		int temp = 0;
		for (int i = 0; i< notas.length -1;i++) {
			temp = notas[i];
			notas[i] = notas[i+1];
			notas[i+1] = temp;
		}
		System.out.println("");
		for (int nota : notas) {
			System.out.print(nota +" ");
		}
		
	}
	
	public static void exercicio03(Scanner teclado){
		double[] notas = new double[3];
		int posMaior = 0;
		for(int index = 0; index < notas.length; index++){
			System.out.printf("Informe a %dª nota:\n",index+1);
			notas[index] = Double.parseDouble(teclado.nextLine());
			if(notas[index] > notas[posMaior]){
				posMaior = index;
			}
		}
		
		System.out.println("A maior nota é "+notas[posMaior]);
		System.out.println("Sua posição é "+posMaior);
		
	}
	
	
	
	public static void exercicio04(Scanner teclado){
		String[] nomes = new String[3];
		for(int index = 0; index < nomes.length; index++){
			System.out.printf("Informe o %dº nome:\n",index+1);
			nomes[index] = teclado.nextLine();
		}
		System.out.println("A ordem inversa da lista é");
		for(int index = nomes.length -1; index >=0; index--){
			System.out.println(nomes[index]);
		}
		
	}

}
