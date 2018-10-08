package br.com.cursojava.aula021.lambda;

public class ExemploClasseAnomima {
	
	public static void main(String[] args) {
		
		Voador v1 = new Aviao();
		v1.voar();
		
		Voador v2 = new Voador(){
			public void voar(){
				System.out.println("Voador Anônimo...");
			}
		};
		
		v2.voar();
		liberarVoo(v1);
		liberarVoo(v2);
		
		liberarVoo(new Voador(){
			public void voar(){
				System.out.println("Voador Anônimo 2 ...");
			}
		});
		
	}
	
	private static void liberarVoo(Voador voador){
		voador.voar();
	}

}
