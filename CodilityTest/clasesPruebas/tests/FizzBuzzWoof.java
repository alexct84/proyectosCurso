package tests;

public class FizzBuzzWoof {

	
	public static void main(String[] args) {
		int numero = 24;
		
		for (int i=1; i<=numero; i++)
		{
			String salida= "";
			if (i%3 == 0)
			{
		      salida = salida + "Fizz";		
		   
			}
			if (i%5 == 0)
			{
				salida = salida + "Buzz";
				
			}
			if (i%7 == 0)
			{
				salida = salida + "Woof";
				
			}
			
			if (salida.length() == 0)
			{
				System.out.println(String.valueOf(i));
			}
			else{
				System.out.println(salida);
			}
			
		}

	}

}
