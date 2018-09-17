package br.com.cursojava.aula006;

public class OperadoresCompostos {
	
	public static void main(String[] args) {
		
		/*
		 *  Operadores Compostos
		 *  +=
		 *  -=
		 *  *=
		 *  /=
		 *  %=
		 */
		System.out.println("=== (+=) ========");
		int num = 10;
		int num2 = 5;
		num += num2; // num = num + num2
		System.out.println(num);
		
		System.out.println("=== (-=) ========");
		num -= num2; // num = num - num2
		System.out.println(num);
		
		System.out.println("=== (*=) ========");
		num *= num2; // num = num * num2
		System.out.println(num);
		
		System.out.println("=== (/=) ========");
		num /= num2; // num = num / num2
		System.out.println(num);
		
		System.out.println("=== (%=) ========");
		num %= num2; // num = num % num2
		System.out.println(num);
		
		
		int n1 = 10;
		n1 *= 2 + 8;  // n1 = n1 * (2 + 8)
		System.out.println(n1);
		
		
		
		
		
		
		
		
		
		
	}

}
