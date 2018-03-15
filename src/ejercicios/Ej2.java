//Crea un array de números donde le indicamos por teclado el tamaño del array, rellenaremos el array con números aleatorios entre 0 y 9, 
//al final muestra por pantalla el valor de cada posición y la suma de todos los valores. Haz un método para rellenar 
//el array (que tenga como parámetros los números entre los que tenga que generar), para mostrar el contenido y la suma del array y 
//un método para generar número aleatorio (lo puedes usar para otros ejercicios).

package ejercicios;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int[] vector;

		System.out.println("Dame el tamaño del vector:");
		vector = new int[entrada.nextInt()];

		rellenarVector(vector, 0, 9);

		System.out.printf("Los valores del vector son :\n%s\n", mostrarVector(vector));
		System.out.println("La suma de todos sus valores es: " + sumaVector(vector));

		entrada.close();
	}

	public static int sumaVector(int[] numeros) {

		int suma = 0;

		for (int numero : numeros) {
			suma += numero;
		}

		return suma;
	}

	public static String mostrarVector(int[] numeros) {

		String vector = "";

		for (int numero : numeros) {
			vector += numero + " ";
		}

		return vector;
	}

	public static void rellenarVector(int[] numeros, int limiteInferior, int limiteSuperior) {

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = obtenerAleatorio(0, 9);
		}
	}

	public static int obtenerAleatorio(int limiteInferior, int limiteSuperior) {
		return (int) (Math.random() * (limiteSuperior - limiteInferior + 1) + limiteInferior);
	}

}
