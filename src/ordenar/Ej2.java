//Crea un vector de dos dimensiones que contenga el nombre y la altura de personas. 
//El programa debe devolver un listado de personas ordenadas por altura. Utiliza el algoritmo de mergesort.

package ordenar;

import java.util.Scanner;

public class Ej2 {

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

		mergeSort(palabras,0,palabras.length);
		System.out.println(vectorToString(palabras));

		entrada.close();
	}
	
	public static void mergeSort(String[][] arreglo, int inicio, int longitud){

		int longitud1; // Longitud de la primera mitad del arreglo
		int longitud2; // Longitud de la segunda mitad del arreglo
		if (longitud > 1)
		{
			longitud1 = longitud / 2;
			longitud2 = longitud - longitud1;
			// Se realizan divisiones recursivas del arreglo y llama al funcion
			// merge para mezclarlos.
			mergeSort(arreglo, inicio, longitud1);
			mergeSort(arreglo, inicio + longitud1, longitud2);
			merge(arreglo, inicio, longitud1, longitud2);
		}
	}


	public static void merge(String[][] arreglo, int inicio, int longitud1, int longitud2)	{
		// Vector utilizado temporalmente para ordenar el vector
		String[][] arregloBuffer = new String[longitud1+longitud2][2];

		// Indice del vector temporal
		int indiceBuffer = 0;

		// Indice del vector que representa la primera mitad
		int indice1 = 0; 

		// Indice del vector que representa la segunda mitad
		int indice2 = 0;

		// Indice utilizado para el volcado del buffer en el vector original
		int i;

		// Mientras los subindices no lleguen al final de sus respectivos 
		// subvectores, se van colocando de menor a mayor los elementos en el
		// vector temporal.
		while ((indice1 < longitud1) && (indice2 < longitud2))
		{
			if (Integer.parseInt(arreglo[inicio + indice1][1]) < Integer.parseInt(arreglo[inicio + longitud1 + indice2][1]))
				arregloBuffer[indiceBuffer++] = arreglo[inicio + (indice1++)];
			else
				arregloBuffer[indiceBuffer++] = arreglo[inicio + longitud1 + (indice2++)];
		}

		// Cuando alguno de los subindices llega al final se copia el contenido del 
		// otro subvector en el vector temporal
		while (indice1 < longitud1){
			arregloBuffer[indiceBuffer++] = arreglo[inicio + (indice1++)];
		}
		while (indice2 < longitud2){
			arregloBuffer[indiceBuffer++] = arreglo[inicio + longitud1 + (indice2++)];
		}

		// Una vez se tiene el vector temporal ordenado se vuelcan los datos en el
		// vector original.
		for (i = 0; i < longitud1+longitud2; i++){
			arreglo[inicio + i] = arregloBuffer[i];
		}
	}

	public static String vectorToString(String[][] vector) {
		String resultado = "";
		for (int i = 0; i < vector.length; i++) {
			resultado = resultado + vector[i][0] + ": " + vector[i][1] + "\n";
		}
		return resultado;
	}

}
