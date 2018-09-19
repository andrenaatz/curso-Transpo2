package br.com.cursojava.aula008;

public class ExemploArray {
	
	public static void main(String[] args) {
		
		int[] numeros;
		String nomes[];
		numeros = new int[10];
		nomes = new String[3];
		
		String[] frutas = {"Abacaxi","Banana","Pêssego"};
		double[] medias = new double[3];
		int[] notas = new int[]{10,9,8,10,9,8};
		int[] notas2 = {10,9,8,10,9,8};
		System.out.println(notas);
		
		System.out.println(medias.length);
		System.out.println(notas.length);
//		notas = new int []{10,10,10,10};
		for(int index = 0; index < notas.length; index++){
			System.out.print(notas[index] + " ");
		}
		System.out.println("");
		for(int atual: notas){
			System.out.print(atual +" ");
			atual = 0;
		}
		System.out.println("");
		for(int i = 0; i< notas.length;i++){
			int atual = notas[i];
			System.out.print(atual+" ");
			notas[i] = 0;
		}
		
		
		
		
		
	}

}
