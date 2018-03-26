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

		System.out.println(mostrarArray(personas));

//		System.out.println("La altura media es " + obtenerAlturaMedia(personas));
//
//		mostrarPersonaMasAlta(personas);
//
//		mostrarPersonaMasBaja(personas);
//
//		listarSuperiorALaMedia(personas);
//
//		listarInferiorALaMedia(personas);

		entrada.close();
	}

	public static void rellenarArray(String[][] personas) {
		
		int posicion;
		String nombre, altura;
		Scanner entrada = new Scanner(System.in);

		for(posicion = 0; posicion < personas[1].length; posicion++){
			System.out.println("Dame el nombre de la persona numero " + (posicion + 1));
			nombre = entrada.next();
			System.out.println("Dame la altura para " + nombre);
			altura = Float.toString(entrada.nextFloat());

			personas[0][posicion] = nombre;
			personas[1][posicion] = altura;
		}
		entrada.close();
	}

	public static void mostrarPersonaMasAlta(String[][] personas) {

	}

	public static void mostrarPersonaMasBaja(String[][] personas) {

	}

	public static float obtenerAlturaMedia(String[][] personas) {
		float media = 0;

		return media;
	}

	public static void listarSuperiorALaMedia(String[][] personas) {

	}

	public static void listarInferiorALaMedia(String[][] personas) {

	}

	public static String mostrarArray(String[][] personas) {
		String resultado = "";

		for (int i = 0; i < personas[1].length; i++) {
			resultado = resultado + "Nombre: " + personas[0][i] + "\n" + "Altura: " + personas[1][i] + "\n";
		}
		return resultado;
	}

}
