//Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100. Obtén la suma de todos ellos y la media.

package ejercicios;

public class Ej3 {

	public static void main(String[] args) {

		int[] array = new int[100];

		rellenarVector(array);
		System.out.println("La suma de todos los elementos es: " + sumaVector(array));
		System.out.println("La media del vector es: " + obtenerMedia(array));
	}

	public static void rellenarVector(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			vector[i] = i;
		}
	}

	public static float obtenerMedia(int[] vector) {

		int suma = 0;

		for (int numero : vector) {
			suma += numero;
		}

		return suma / vector.length;
	}

	public static int sumaVector(int[] numeros) {

		int suma = 0;

		for (int numero : numeros) {
			suma += numero;
		}

		return suma;
	}

}
