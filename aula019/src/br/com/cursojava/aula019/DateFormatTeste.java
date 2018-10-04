package br.com.cursojava.aula019;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class DateFormatTeste {

	public static void main(String[] args) {
		String data = "31/10/2018 16:42:40";
		DateFormat dataFormatada = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,Locale.US);
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
		Date recebeDataFormada = null;
		
		
			try {
				System.out.println(df.format(new Date()));
				recebeDataFormada = dataFormatada.parse(data);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			System.out.println(df.format(recebeDataFormada));
		
	}
}
