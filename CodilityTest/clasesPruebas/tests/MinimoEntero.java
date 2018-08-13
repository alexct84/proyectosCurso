package tests;

import utils.Ordenacion;

public class MinimoEntero {
    
	
	private static int findMinimoEntero(int[] conjunto)
	{
		Ordenacion.quicksort(conjunto, 0, conjunto.length-1);
		int solucion = conjunto[conjunto.length-1];
		//System.out.println(solucion);
		//buscamos que no este en el array la solucion pensada
		int cont = 1;
		for (int i=0; i<conjunto.length; i++)
		{
			if (cont == conjunto[i])
				cont++;
		}
		
		if ((cont == 1) || (cont< solucion))
			return cont;
		else
			return solucion +1; 
	}
	
	public static void main(String args[])
	{
		int []a = {1, 3, 6, 4, 1, 2};
		System.out.println("El entero mas pequeño mayor es :"+findMinimoEntero(a));
		
		
	}
}
