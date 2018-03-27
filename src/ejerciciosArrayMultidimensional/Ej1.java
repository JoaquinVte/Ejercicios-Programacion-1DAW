//Crea un programa para almacenar las notas de los alumnos de varias asignaturas. Para ello utiliza un vector multidimensional, 
//donde las notas de todos los alumnos apareceran en las filas, y las notas de todas las asignaturas de un alumno aparaceran en las columnas.
//
//Crea un metodo para rellene automaticamente las notas con numeros aleatorios, permitiendo cifras con dos decimales.
//
//Obten la nota media de cada alumno asi como la nota media de cada asignatura.
//
//Crea un metodo para visualizar las notas de un usuario de la siguiente forma:
//
//Notas para Jose:
//
//Matematicas:	********
//
//Tecnologia:    *******
//
//Informatica:   ******
//
//Ingles:           **
//
//Lengua:         *******
//
//Llengua:        *******
//
//Crea otro metodo como el anterior para visualizar las notas de una asignatura.

package ejerciciosArrayMultidimensional;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		int alumnos;
		int asignaturas;
		String[][] notas;

		System.out.println("Cuantos alumnos quieres almacenar notas?: ");
		alumnos = entrada.nextInt();
		System.out.println("Cuantos asignaturas quieres almacenar notas?: ");
		asignaturas = entrada.nextInt();

		notas = new String[asignaturas + 1][alumnos + 1];
		notas[0][0] = "";

		solicitarAlumnos(notas);
		System.out.println();
		
		solicitarAsignaturas(notas);
		System.out.println();
		
		rellenarNotas(notas);
		
		System.out.println();
		mostrarNotas(notas);
		System.out.println();

		System.out.println("Notas por alumnos");
		mostrarNotasAlumnos(notas);
		System.out.println();
		
		System.out.println("Notas por asignaturas");
		mostrarNotasAsignaturas(notas);
		System.out.println();
		
		System.out.println("Notas medias por alumno");
		mostrarMedias(notas);
		System.out.println();
		
		System.out.println("Notas medias por asignatura");
		mostrarMediasAsignatura(notas);
		System.out.println();

		entrada.close();

	}

	public static void solicitarAlumnos(String[][] notas) {

		Scanner entrada = new Scanner(System.in);

		for (int i = 1; i < notas[1].length; i++) {
			System.out.print("Dame el nombre del " + i + "º alumno: ");
			notas[0][i] = entrada.nextLine();
		}

	}

	public static void solicitarAsignaturas(String[][] notas) {

		Scanner entrada = new Scanner(System.in);

		for (int i = 1; i < notas.length; i++) {
			System.out.print("Dame el nombre de la " + i + "º asignatura: ");
			notas[i][0] = entrada.next();
		}

	}

	public static void rellenarNotas(String[][] notas) {

		for (int i = 1; i < notas.length; i++) {
			for (int j = 1; j < notas[1].length; j++) {
				notas[i][j] = String.valueOf(obtenerNota());
			}
			System.out.println();
		}

	}

	public static void mostrarNotas(String[][] notas) {

		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[1].length; j++) {
				System.out.printf("%20s", notas[i][j]);
			}
			System.out.println();
		}
	}

	public static float obtenerNota() {
		return (float) Math.floor(Math.random() * 1000) / 100;
	}
	
	public static void mostrarMedias(String[][] notas){
		
		float sumaNotas;
		
		for(int i=1;i<notas[1].length;i++){
			
			sumaNotas=0;
			
			for(int j=1;j<notas.length;j++){
				sumaNotas+=Float.parseFloat(notas[j][i]);
			}
			
			System.out.printf("%10s: %2.2f%n",notas[0][i],sumaNotas/(notas.length-1));
		}
	}
	
	public static void mostrarMediasAsignatura(String[][] notas){
		
		float sumaNotas;
		
		for(int i=1;i<notas.length;i++){
			
			sumaNotas=0;
			
			for(int j=1;j<notas[1].length;j++){
				sumaNotas+=Float.parseFloat(notas[i][j]);
			}
			
			System.out.printf("%10s: %2.2f%n",notas[i][0],sumaNotas/(notas[1].length-1));
		}
	}

	public static void mostrarNotasAlumnos(String[][] notas) {
		
		System.out.println("----------------------------------");

		for (int i = 1; i < notas[1].length; i++) {
			System.out.println("Notas para " + notas[0][i]);
			for (int j = 1; j < notas.length; j++) {
				System.out.printf("%15s: %-10s%n", notas[j][0], obtenerAsteriscos(notas[j][i]));
			}
			System.out.println("----------------------------------");
		}
	}
	
	public static void mostrarNotasAsignaturas(String[][] notas) {
		
		System.out.println("----------------------------------");

		for (int i = 1; i < notas.length; i++) {
			System.out.println("Notas para " + notas[i][0]);
			for (int j = 1; j < notas[1].length; j++) {
				System.out.printf("%15s: %-10s%n", notas[0][j], obtenerAsteriscos(notas[i][j]));
			}
			System.out.println("----------------------------------");
		}
	}

	public static String obtenerAsteriscos(String nota) {
		String asteriscos = "";

		for (int i = 1; i <= Float.parseFloat(nota); i++) {
			asteriscos += "*";
		}

		return asteriscos;
	}
}
