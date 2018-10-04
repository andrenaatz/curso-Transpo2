package br.com.cursojava.aula019;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

public class ExemploStatic {

	public static void main(String[] args) {
		Teste t1 = new Teste();
		Teste t2 = new Teste();
		
		System.out.println(t1.atributo);
		System.out.println(t2.atributo);
		System.out.println(t1.atributoStatic);
		System.out.println(t2.atributoStatic);
		System.out.println(Teste.atributoStatic);
		
		t1.atributo = 10;
		t2.atributo = 20;
		t1.atributoStatic = 50;
		
		System.out.println(t1.atributo);
		System.out.println(t2.atributo);
		System.out.println(t1.atributoStatic);
		System.out.println(t2.atributoStatic);
		System.out.println(Teste.atributoStatic);
		
		t2.atributoStatic = 100;
		System.out.println(t1.atributoStatic);
		System.out.println(t2.atributoStatic);
		System.out.println(Teste.atributoStatic);
		
		Teste.atributoStatic = 500;
		System.out.println(t1.atributoStatic);
		System.out.println(t2.atributoStatic);
		System.out.println(Teste.atributoStatic);
		
		t1.oi();
		t1.hello();
		t2.oi();
		t2.hello();
		Teste.hello();
		
		NumberFormat.getInstance();
		DateFormat.getInstance();
		
		
	}
}
