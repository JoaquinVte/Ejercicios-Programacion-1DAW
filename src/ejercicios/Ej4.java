//Crea un array de números de un tamaño pasado por teclado, el array contendrá números 
//aleatorios primos entre los números deseados, por último nos indica cual es el mayor de todos.

package ejercicios;

import java.util.Scanner;

public class Ej4 {

	public static void main(String[] arg) {
		
		int[] numeros;
		int cantidad, limiteSuperior, limiteInferior = 2;
		Scanner entrada = new Scanner(System.in);

		System.out.println("De que tamaño quieres el Array?");
		cantidad = entrada.nextInt();

		numeros = new int[cantidad];

		System.out.println("Cual es el mayor numero primo que quieres que contenga el vector?");
		limiteSuperior = entrada.nextInt();

		rellenarArray(numeros, limiteInferior, limiteSuperior);

		System.out.println("El mayor numero primo es : " + numeros[obtenerPosicionMayor(numeros)]);
		System.out.println("Los numeros del vector son: \n" + mostrarVector(numeros));
		
		entrada.close();
	}

	// La funcion indica si un numero pasado por parametro es, o no, un numero
	// primo
	public static boolean esPrimo(int numero) {
		boolean encontrado = false;
		int i = 2;
		while (!encontrado && i < numero) {
			if (numero % i == 0) {
				encontrado = true;
			}
			i++;
		}

		return !encontrado;
	}

	// La funcion devuelve un nuermo aleatorio entre un limite inferior y un
	// limite superior
	public static int obtenerAleatorio(int limInf, int limSup) {
		return (int) (Math.random() * (limSup - limInf + 1) + limInf);
	}

	// La funcion rellena un vector pasado por parametro con numeros primos
	// comprendidos entre un limite inferior y un limite superior
	public static void rellenarArray(int[] lista, int limInf, int limSup) {

		int i = 0, numero;

		for (i = 0; i < lista.length; i++) {
			do {
				numero = obtenerAleatorio(limInf, limSup);
			} while (!esPrimo(numero));

			lista[i] = numero;
		}
	}

	// Esta funcion devuelve el elmento mayor de un vector pasado por parametro
	public static int obtenerPosicionMayor(int[] lista) {
		int posicion, posicionMayor = 0;
		int mayor = lista[0];

		for (posicion = 0; posicion < lista.length; posicion++) {

			if (lista[posicion] > mayor) {
				posicionMayor = posicion;
				mayor = lista[posicion];
			}
		}

		return posicionMayor;
	}

	// Esta funcion devuelve un String con los elementos del vector pasado por
	// parametro
	public static String mostrarVector(int[] numeros) {

		String vector = "";

		for (int numero : numeros) {
			vector += numero + " ";
		}

		return vector;
	}
}
