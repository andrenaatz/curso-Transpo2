package br.com.cursojava.aula009;

public class Pratica01 {

	public static void main(String[] args) {
		int[][] matriz = new int[3][3];
		matriz[0][0] = 10;
		matriz[0][1] = 9;
		matriz[0][2] = 8;
		matriz[1][0] = 7;
		matriz[1][1] = 9;
		matriz[1][2] = 10;
		matriz[2][0] = 10;
		matriz[2][1] = 7;
		matriz[2][2] = 8;
		
		int soma = 0;
		for(int indice = 0; indice < matriz.length; indice++){
			soma += matriz[indice][indice];
		}
		System.out.println("O resultado da soma da diagonal principal é "+ soma);

	}

}
