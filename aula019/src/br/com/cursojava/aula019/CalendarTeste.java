package br.com.cursojava.aula019;

import java.util.Calendar;

public class CalendarTeste {
	public static void main(String[] args) {
		Calendar calendario = Calendar.getInstance();
		calendario.roll(Calendar.DATE, 30);
		System.out.println(calendario.getTime());
		
		int hora = calendario.get(Calendar.HOUR_OF_DAY);
		
		if(hora >= 6 && hora <=12){
			System.out.println("Bom dia");
		}else if(hora <=18){
			System.out.println("Boa tarde");
		}else{
			System.out.println("Boa noite");
		}
		
	
	}
}
