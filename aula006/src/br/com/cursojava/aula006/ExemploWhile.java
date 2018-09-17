package br.com.cursojava.aula006;

public class ExemploWhile {

	public static void main(String[] args) {

		int numero = 10;
		
		meulabel:
			while (numero < 15) {
			while (numero <= 20) {
				if (numero == 13) {
					break meulabel;
				}
				System.out.print((numero++) + ", ");
			}
		}
		System.out.println("");
		System.out.println(numero);
		System.out.println("Fim da Aplicação");
	}

}
