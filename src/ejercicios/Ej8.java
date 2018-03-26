//Programa Java que llene un array con 10 números enteros que se leen por teclado. 
//A continuación calcula y muestra la media de los valores positivos y la de los valores negativos del array.
package ejercicios;

import java.util.Scanner;

public class Ej8 {

	public static void main(String[] args) {

		int[] array = new int[10];
		Scanner entrada = new Scanner(System.in);
		int positivos = 0, negativos = 0, sumaPositivos = 0, sumaNegativos = 0;
		float mediaPositivos = 0, mediaNegativos = 0;

		for (int i = 0; i < array.length; i++) {
			System.out.print("Dame el valor para la posicion " + i + ": ");
			array[i] = entrada.nextInt();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				positivos++;
				sumaPositivos += array[i];
			}
			if (array[i] < 0) {
				negativos++;
				sumaNegativos += array[i];
			}
		}

		if (positivos != 0)
			mediaPositivos = (float) sumaPositivos / positivos;
		if (negativos != 0)
			mediaNegativos = (float) sumaNegativos / negativos;

		System.out.printf("La media de numeros positivos es %s, y de numeros negativos %s.", mediaPositivos,
				mediaNegativos);
		entrada.close();
	}
}
