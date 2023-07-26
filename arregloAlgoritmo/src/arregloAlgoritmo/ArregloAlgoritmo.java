package arregloAlgoritmo;

public class ArregloAlgoritmo {

	public static void main(String[] args) {

		int[] numeros = { -8, 4, 5, 8, 9, 23, 25, 32, 40, 45, 56, 60, 78 };
		int numero;
		
		for(int i = 0; i < numeros.length; i++) {
			numero = numeros[i];
			switch(numero) {
			case 9:
				System.out.println("el número: " + numero + " se encuentra en el índice " + i );
				break;
			}
					
		}
		
	}

}
