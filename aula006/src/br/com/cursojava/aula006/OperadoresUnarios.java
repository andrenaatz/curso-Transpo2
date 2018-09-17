package br.com.cursojava.aula006;

public class OperadoresUnarios {

	public static void main(String[] args) {
		//Operadores Unarios
		/*
		 *    ++
		 *    --
		 */
		
		//pr�-incremento
		int numero = 10;
		System.out.println("==== PR� INCREMENTO ====");
		System.out.println(numero);
		System.out.println(++numero);
		System.out.println(numero);
		
		int numero2 = 20;
		System.out.println("==== P�S INCREMENTO ====");
		System.out.println(numero2);
		System.out.println(numero2++);
		System.out.println(numero2);
		
		int res = numero++;
		System.out.println(res == numero);
		int numeros[] = {1,2,3,4,5};
		int i = 0;
		while(i< numeros.length){
			System.out.println(numeros[i++]);
		}
		
		System.out.println("==== PR� DECREMENTO ====");
		System.out.println(numero);
		System.out.println(--numero);
		System.out.println(numero);
		
		System.out.println("==== P�S DECREMENTO ====");
		System.out.println(numero2);
		System.out.println(numero2--);
		System.out.println(numero2);
		
		
	}
}
