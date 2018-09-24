package br.com.cursojava.aula011;

public class Produto {
	
	private String nome;
	private double preco;
	private  boolean promocao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		if(preco >= 0.01){
			this.preco = preco;
		}else{
			System.out.println("Valor inválido para o produto");
		}
	}
	public boolean isPromocao() {
		return promocao;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	
	
	
	
	
	

}
