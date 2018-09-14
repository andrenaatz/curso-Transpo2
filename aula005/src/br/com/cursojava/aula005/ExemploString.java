package br.com.cursojava.aula005;

public class ExemploString {
	
	public static void main(String[] args) {
		
		String curso = "Java Web TranspoBrasil";
		
		//length() retorna a quantidade de caracteres 
		System.out.println(curso.length());
		
		//charAt retorna o caracter em uma posição específica
		for(int posicao = 0; posicao< curso.length();posicao++){
			System.out.println(curso.charAt(posicao));
		}
		
		//indexOf() retorna o indice da String
		System.out.println(curso.indexOf("Web"));
		System.out.println(curso.indexOf("a", 4));
		
		int pos = -1;
		do{
			pos++;
			pos = curso.indexOf('a', pos);
			System.out.print(pos+", ");
		}while(pos != -1);
		
		String a = "bola";
		System.out.println(a.replace('o','a'));
		System.out.println(a);
		String b = "bola";
		String c = new String ("bola");
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(c));
		
		System.out.println(curso.substring(9));
		System.out.println(curso.substring(0,5));
		
		
	}

}
