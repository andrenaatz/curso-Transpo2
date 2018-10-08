package br.com.cursojava.aula021;

public class ExemploExcecaoChecada {
	
	public static void main(String[] args)  {
		boolean ok = usaImprimirRange();
		if(ok){
			System.out.println("Range impresso com sucesso");
		}
	}
	
	private static boolean usaImprimirRange(){
		boolean ok = true;
		int inicio = 1;
		int fim = 10;
		try{
			imprimirRange(inicio,fim);
			return ok;
		}catch(RangeInvalidoException e){
			System.out.println(e.getMessage());
			System.out.println("Fiz alguns tratamentos");
			ok = false;
			return ok;
		}finally {
			System.out.println("Finally executado");
		}
	}
	
	private static void imprimirRange(int inicio, int fim) throws RangeInvalidoException {
		if(fim <= inicio){
			throw new RangeInvalidoException("Fim deve ser maior que início");
		}else{
			for(int i = inicio; i<=fim;i++){
				System.out.printf("%d ",i);
			}
			System.out.println("");
		}
	}

}
