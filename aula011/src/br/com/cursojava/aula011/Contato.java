package br.com.cursojava.aula011;

public class Contato {
	
	//variáveis de instância/propriedades/atributos
	String nome;
	String email;
	String telefone;
	
	
	void configuraNome(String nome){
		this.nome = nome;
	}
	String retornaNome(){
		return nome;
	}
	
	void configuraEmail(String email){
		this.email = email;
	}
	String retornaEmail(){
		return email;
	}
	
	void configuraTelefone(String telefone){
		this.telefone = telefone;
	}
	String retornaTelefone(){
		return telefone;
	}
	
	void ligar(){
		System.out.println("Ligando para o contato "+nome);
		System.out.println("Telefone: "+telefone);
	}
	
	void enviarMensagem(String mensagem){
		System.out.println("Enviando a mensagem ");
		System.out.println(mensagem);
		System.out.println("Para o email : "+email);
	}

}
