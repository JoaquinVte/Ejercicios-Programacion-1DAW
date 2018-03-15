//Crea un array de caracteres que contenga de la ‘A’ a la ‘Z’ (solo las mayúsculas). 
//Después, ve pidiendo posiciones del array por teclado y si la posicion es correcta, 
//se añadira a una cadena que se mostrara al final, se dejará de insertar cuando 
//se introduzca un -1.

package ejercicios;

import java.util.Scanner;

public class Ej5 {

	public static void main(String[] args) {

		char[] letras = new char['Z' - 'A' + 1];
		Scanner entrada = new Scanner(System.in);
		int posicion;
		String resultado = "";

		rellenarLetras(letras);

		System.out.println("Dame una posicon /(-1 salir/): ");
		posicion = entrada.nextInt();

		while (posicion != -1) {

			if (posicion >= 0 && posicion < letras.length) {
				resultado += letras[posicion];
			}

			System.out.println("Dame una posicon /(-1 salir/): ");
			posicion = entrada.nextInt();
		}
		System.out.println("El vector es: \n" + mostrarVector(letras));
		System.out.println("El resultado es: \n" + resultado);

		entrada.close();
	}

	// Esta funcion rellena el vector con las letras de la A - Z
	public static void rellenarLetras(char[] letras) {
		char letra = 'A';
		for (int i = 0; i < letras.length; i++, letra++) {
			letras[i] = letra;
		}
	}

	// Esta funcion devuelve un String con los valores del vector.
	public static String mostrarVector(char[] letras) {

		String vector = "";

		for (char letra : letras) {
			vector += letra;
		}

		return vector;
	}
}
