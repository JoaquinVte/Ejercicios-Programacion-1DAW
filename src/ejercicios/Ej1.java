//Crea un array de 10 posiciones de números con valores pedidos por teclado. Muestra por consola el indice y el valor al que corresponde. 
//Haz dos métodos, uno para rellenar valores y otro para mostrar.

package ejercicios;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		int[] numeros = new int[10];

		rellenar(numeros);
		mostrar(numeros);

	}

	// Esta funcion rellena el vector pasado por parametro
	public static void rellenar(int[] num) {

		Scanner entrada = new Scanner(System.in);

		for (int i = 0; i < num.length; i++) {
			System.out.println("Dame el numero para la posicion " + i + ":");
			num[i] = entrada.nextInt();
		}

		entrada.close();
	}

	// Esta funcion muestra el vector pasado por parametro
	public static void mostrar(int[] num) {

		System.out.println("Los valores introducidos son:");

		for (int numero : num) {
			System.out.println(numero);
		}
	}

}
