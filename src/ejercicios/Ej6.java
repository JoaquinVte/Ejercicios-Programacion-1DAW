//Crear un programa que calcule la letra del DNI de cualquier persona. Para calcular la letra 
//se debe dividir el DNI por 23, y el resto buscarlo en la siguiente lista:
//
//Posición 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22
//
//Letra      T R W  A G M  Y  F  P D  X  B   N  J   Z  S   Q  V   H  L  C  K   E

package ejercicios;

import java.util.Scanner;

public class Ej6 {
	public static void main (String[] args){
		
		char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int dni;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escribe tu DNI: ");
		dni = entrada.nextInt();
		
		System.out.printf("Tu dni es : %s - %s", dni, letras[dni%23]);
		
		entrada.close();
	}
}
