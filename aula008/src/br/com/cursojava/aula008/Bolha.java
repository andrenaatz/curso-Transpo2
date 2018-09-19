package br.com.cursojava.aula008;

import java.util.Arrays;

public class Bolha {
	
	public static void main(String[] args) {
		int[] numeros = {10,1,2,3,5,4,8,7,9,6};
		int temp = 0;
		for(int i = 0; i < numeros.length -1; i++){
			for(int j = i+1; j< numeros.length; j++){
				if(numeros[j] < numeros[i]){
					temp = numeros[j];
					numeros[j] = numeros[i];
					numeros[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numeros));
	}

}
