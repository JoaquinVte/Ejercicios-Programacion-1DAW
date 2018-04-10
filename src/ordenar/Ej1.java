//Crea un vector que almacene Strings desordenados y devuelve el vector con los mismos Strings ordenados de forma ascendente (A-Z), utilizando el método de inserción.

package ordenar;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int cantidad;
		String[] palabras;
		int contador = 0;

		System.out.println("Cuantas palabras vas a introducir?: ");
		cantidad = entrada.nextInt();

		palabras = new String[cantidad];

		while (contador < palabras.length) {

			System.out.println("Dame una palabra: ");
			palabras[contador] = entrada.next();

			contador++;
		}

		insercion(palabras);
		System.out.println(vectorToString(palabras));

		entrada.close();
	}

	public static void insercion(String[] arreglo) {
		String buffer;
		int i, j, k;
		for (i = 1; i < arreglo.length; i++) {
			j = 0;
			buffer = arreglo[i];

			// Avanzamos por el arreglo hasta encontrar la posicion donde
			// colocar el valor de buffer
			while (arreglo[j].compareToIgnoreCase(buffer) < 0) {
				j++;
			}

			// Comprobamos si su posicion no es la ultima de la parte ordenada
			if (j < i) {
				// Movemos todos los valores a la derecha de la posicion un
				// puesto a la derecha.
				for (k = i; k > j; k--) {
					intercambiar(arreglo, k, k - 1);
				}
			}
		}
	}

	public static void intercambiar(String[] arreglo, int i, int j) {
		String buffer = arreglo[j];
		arreglo[j] = arreglo[i];
		arreglo[i] = buffer;
	}

	public static String vectorToString(String[] vector) {
		String resultado = "";
		for (int i = 0; i < vector.length; i++) {
			resultado = resultado + vector[i] + " ";
		}
		return resultado;
	}

}
