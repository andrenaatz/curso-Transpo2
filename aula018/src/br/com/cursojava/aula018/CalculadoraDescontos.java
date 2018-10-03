package br.com.cursojava.aula018;

public class CalculadoraDescontos {

	private static final double _0_05 = 0.05;
	private static final double DESCONTO_NIVEL3 = 0.22;
	private static final double DESCONTO_NIVEL4 = 0.32;

	public double calcular(double valor) {
		double retorno = 0;
		if(valor >= 3600){
			retorno = valor  * (1 - DESCONTO_NIVEL4);
		}else if(valor > 2400){
			retorno = valor  * (1 - DESCONTO_NIVEL3);
		}else if(valor > 1800){
			retorno = valor  * (1 - _0_05);
		}else if(valor >= 0){
			retorno = valor;
		}
		return retorno;
	}

}
