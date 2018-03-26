//Modifica el programa anterior para que el programa pida el nombre de la persona junto con su altura, 
//una vez finalice muestre un listado de los nombre de las personas cuya altura es inferior a la media y cuales superior, 
//asi como el nombre de las personas mas alta y baja. Intenta resolver el ejercicio cumpliendo los siguientes requisitos:
//
//Utiliza un array multidimensional (String[ ][ ]) para almacenar los datos.
//Implementa un método para rellenar el array multidimensional.
//Implementa un método para visualizar todos los valores del array multidimensional.
//Implementa un método para obtener la altura media. 
//Las alturas deben ser del tipo Float.
//Los valores de las alturas se deben mostrar con solo dos decimales.
package ejercicios;

import java.util.Scanner;

public class Ej10 {

	public static void main(String[] args) {
		String[][] personas;
		int cantidad;
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Cuantas personas quieres almacenar? (Introducir un valor entero positivo)");
			cantidad = entrada.nextInt();
		} while (cantidad <= 0);

		personas = new String[2][cantidad];

		rellenarArray(personas);

		System.out.println("Los datos con en el vector son:");

		mostrarArray(personas);

		System.out.printf("La altura media es %.2f %n", obtenerAlturaMedia(personas));

		System.out.println("La/s personas mas alta/s es/son: \n" + obtenerPersonaMasAlta(personas));

		System.out.println("La/s personas mas baja/s es/son: \n" + obtenerPersonaMasBaja(personas));

		System.out.println("La/s personas con una altura superior a la media son: " + listarSuperiorALaMedia(personas));

		System.out.println("La/s personas con una altura superior a la media son: " + listarInferiorALaMedia(personas));

		entrada.close();
	}

	public static void rellenarArray(String[][] personas) {

		int posicion;
		String nombre, altura;
		Scanner entrada = new Scanner(System.in);

		for (posicion = 0; posicion < personas[1].length; posicion++) {
			entrada = new Scanner(System.in);
			System.out.println("Dame el nombre de la persona numero " + (posicion + 1));
			nombre = entrada.nextLine();
			System.out.println("Dame la altura para " + nombre);
			altura = Float.toString(entrada.nextFloat());

			personas[0][posicion] = nombre;
			personas[1][posicion] = altura;

		}

		entrada.close();
	}

	public static String obtenerPersonaMasAlta(String[][] personas) {
		String resultado = "";
		float alturaMaxima = obtenerAlturaMaxima(personas);

		for (int i = 0; i < personas[1].length; i++) {
			if (Float.parseFloat(personas[1][i]) == alturaMaxima) {
				resultado += personas[0][i] + "\n";
			}
		}

		return resultado;
	}

	public static String obtenerPersonaMasBaja(String[][] personas) {
		String resultado = "";
		float alturaMinima = obtenerAlturaMaxima(personas);

		for (int i = 0; i < personas[1].length; i++) {
			if (Float.parseFloat(personas[1][i]) == alturaMinima) {
				resultado += personas[0][i] + "\n";
			}
		}

		return resultado;
	}

	public static float obtenerAlturaMedia(String[][] personas) {

		float sumaAlturas = 0;

		for (int i = 0; i < personas[1].length; i++) {
			sumaAlturas += Float.parseFloat(personas[1][i]);
		}

		return sumaAlturas / personas[1].length;
	}

	public static String listarSuperiorALaMedia(String[][] personas) {
		String resultado = "";
		float media = obtenerAlturaMedia(personas);

		for (int i = 0; i < personas[1].length; i++) {
			if (Float.parseFloat(personas[1][i]) > media) {
				resultado += personas[0][i] + "\n";
			}
		}

		return resultado;
	}

	public static String listarInferiorALaMedia(String[][] personas) {
		String resultado = "";
		float media = obtenerAlturaMedia(personas);

		for (int i = 0; i < personas[1].length; i++) {
			if (Float.parseFloat(personas[1][i]) < media) {
				resultado += personas[0][i] + "\n";
			}
		}

		return resultado;
	}

	public static float obtenerAlturaMaxima(String[][] personas) {
		float maxima = 0;
		for (int i = 0; i < personas[1].length; i++) {
			maxima = (Float.parseFloat(personas[1][i]) > maxima) ? Float.parseFloat(personas[1][i]) : maxima;
		}
		return maxima;
	}

	public static float obtenerAlturaMinima(String[][] personas) {
		float minima = 0;
		for (int i = 0; i < personas[1].length; i++) {
			minima = (Float.parseFloat(personas[1][i]) < minima) ? Float.parseFloat(personas[1][i]) : minima;
		}
		return minima;
	}

	public static void mostrarArray(String[][] personas) {

		for (int i = 0; i < personas[1].length; i++) {
			System.out.printf("Nombre: %s Altura: %.2f %n", personas[0][i], Float.parseFloat(personas[1][i]));
		}

	}

}
