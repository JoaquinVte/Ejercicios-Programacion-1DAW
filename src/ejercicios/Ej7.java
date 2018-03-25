//Programa Java que guarda en un array 10 números enteros que se leen por teclado. 
//A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
package ejercicios;

import java.util.Scanner;

public class Ej7 {

	public static void main(String[] args) {
		int[] array = new int[10];
		Scanner entrada = new Scanner(System.in);

		int positivos = 0;
		int negativos = 0;
		int ceros = 0;

		for (int i = 0; i < array.length; i++) {
			System.out.print("Dame el valor para la posicion " + i + " del array: ");
			array[i] = entrada.nextInt();
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				ceros++;
			} else {
				if (array[i] > 0)
					positivos++;
				else
					negativos++;
			}
		}
		System.out.printf("La cantidad de numeros positivos es %s, de negativos %s y de ceros %s.", positivos,negativos,ceros);
		entrada.close();
	}
}
