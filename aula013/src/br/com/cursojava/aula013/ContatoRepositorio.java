package br.com.cursojava.aula013;

public class ContatoRepositorio {
	private static int count = 1;
	private static Contato[] contatos = new Contato[50];
	private static int quantidade = 0;
	
	public boolean adicionarContato(Contato contato) {
		boolean resultado = false;
		if(contato != null){
			if(quantidade < contatos.length){
				contato.setId(count++);
				contatos[quantidade++] = contato;
				resultado = true;
			}
		}
		
		return resultado;
	}

	public Contato[] buscarTodos() {
		Contato[] retorno = new Contato[quantidade];
		int index = 0;
		for (Contato contato : contatos) {
			if(contato != null && index < quantidade){
				retorno[index++] = contato;
			}
		}
		return retorno;
	}

}
