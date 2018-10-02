package br.com.cursojava.aula017;

public class Delorian extends Carro implements Turbinavel, Voador {

	@Override
	public void acionarTurbo() {
		System.out.println("Acionando turbo...");
		
	}

	@Override
	public void desligarTurbo() {
		System.out.println("Desligando turbo...");
	}

	@Override
	public void voar() {
		System.out.println("Delorian Voando....");
		
	}

}
