//Realiza lo mismo que el ejercicio anterior pero ordenadas por nombre ascendente utilizando el algoritmo quicksort.

package ordenar;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int cantidad;
		String[][] palabras;
		int contador = 0;

		System.out.println("Cuantas personas vas a introducir?: ");
		cantidad = entrada.nextInt();

		palabras = new String[cantidad][2];

		while (contador < palabras.length) {

			System.out.println("Dame un nombre: ");
			palabras[contador][0] = entrada.next();
			System.out.println("Dame una altura: ");
			palabras[contador][1] = entrada.next();

			contador++;
		}

		_Quicksort(palabras,0,palabras.length-1);
		System.out.println(vectorToString(palabras));

		entrada.close();
	}
	
	public static void _Quicksort(String[][] arreglo, int a, int b){

		int izq=a, der=b;
		String pivote = arreglo[(izq+der)/2][0];

		// Avanzamos izq hasta encontrar un elemento que deba estar a la derecha del pivote,
		// igualmente el indice derecho hasta encontrar un elemento que deba estar a la izquierda
		// del pivote. Si los indices no se han cruzado realizamos el intercambio.
		do{
			while(arreglo[izq][0].compareToIgnoreCase(pivote) < 0){
				izq++;
			}
			while(arreglo[der][0].compareToIgnoreCase(pivote) > 0 ){
				der--;
			}
			if(izq <= der){
				intercambiar(arreglo,izq,der);
				izq++; der--;
			}
		}while(izq <= der);

		// Si el indiador derecho se ha desplazado realizamos _Quicksort de la parte derecha
		if(a < der)
		{
			_Quicksort(arreglo, a, der);
		}

		// Si el indiador izquierdo se ha desplazado realizamos _Quicksort de la parte derecha
		if(izq < b)
		{
			_Quicksort(arreglo, izq, b);
		}
	}
	public static void intercambiar(String[][] arreglo, int i, int j){
		String[] buffer = arreglo[j];
		arreglo[j] = arreglo[i];
		arreglo[i] = buffer;
	}
	
	public static String vectorToString(String[][] vector) {
		String resultado = "";
		for (int i = 0; i < vector.length; i++) {
			resultado = resultado + vector[i][0] + ": " + vector[i][1] + "\n";
		}
		return resultado;
	}
	
}
