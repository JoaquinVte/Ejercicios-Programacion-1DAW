//Crea un programa que averigüe si un texto es palíndromo o no. 
//Realiza la solución por medio de un algoritmo iterativo y mediante un algoritmo recursivo.
//
//Recuerda que el programa no ha de ser case sensitive, y tampoco tener en cuenta los espacios en blanco.

package palindromo;

import java.util.Scanner;

public class PalindromoRecursivo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String texto;
	
		System.out.print("Introduce una texto: ");
		
		// Obtengo el texto y se pasa a minusculas, eliminando los espacios en blanco.
		texto = entrada.nextLine().toLowerCase().replaceAll(" ", "");
		
		System.out.println("El texto es palindromo: " + Palindromo(texto));

		entrada.close();
	}

	public static boolean Palindromo(String text) {
		
		//Descomentar la siguiente linea para ver la sucesivas llamadas recursivas
		//System.out.println(text);
		
		if (text.length() == 1) {
			return true;
		} else if (text.charAt(0) != text.charAt(text.length() - 1)) {
			return false;
		} else {
			return Palindromo(text.substring(1, text.length()-1));
		}

	}
}
