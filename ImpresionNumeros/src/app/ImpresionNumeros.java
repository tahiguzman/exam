package app;

public class ImpresionNumeros {

	public static void main(String[] args) {

		imprimeNumeros();
		
	}

	public static void imprimeNumeros() {
		int tam = 4;
		for(int ren = 1; ren<=tam; ren++) {
			for (int col = 1; col <= tam; col++) {
				System.out.print((ren-col) + " ");
			}
			System.out.println();
		}
		
	}

}
