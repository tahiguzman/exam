package matrizEjercicio;

import java.util.ArrayList;
import java.util.List;

public class Matriz {

	public static void main(String[] args) {

		int[] numeros = { 2, 7, 11, 15 };
		int objetivo = 17;
		List numeros2 = new ArrayList<>();

		for (int i = 0; i < numeros.length; i++) {
			int num1 = numeros[i];
			for (int j = 0; j < numeros.length; j++) {
				int num2 = numeros[j];
				if (num1 + num2 == objetivo) {
					numeros2.add(i);
					numeros2.add(j);
				}
			}
		}
		
		numeros2.forEach(System.out::println);
		
		

	}

}
