//Crea un programa que averigüe si un texto es palíndromo o no. 
//Realiza la solución por medio de un algoritmo iterativo y mediante un algoritmo recursivo.
//
//Recuerda que el programa no ha de ser case sensitive, y tampoco tener en cuenta los espacios en blanco.

package palindromo;

import java.util.Scanner;

public class PalindromoIterativo {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String texto;
		boolean palindromo = true;
		int izq = 0, der;

		System.out.print("Introduce una texto: ");

		texto = entrada.nextLine();
		der = texto.length() - 1;

		while (palindromo && izq <= der) {

			while (texto.charAt(izq) == ' ') {
				izq++;
			}

			while (texto.charAt(der) == ' ') {
				der--;
			}

			if (texto.toLowerCase().charAt(izq) != texto.toLowerCase().charAt(der)) {
				palindromo = false;
			}
			
			izq++;
			der--;
		}

		System.out.println("El texto es palindromo: " + palindromo);

		entrada.close();
	}

}
