//Un programa que pida el valor del radio y calcule la longitud de la circunferencia para ese radio.

package ejercicios;
import java.util.Scanner;

public class Ej3 {
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		int radio;
		
		// Solicitamos el radio
		
		System.out.println("Introduce el radio: ");
		radio = entrada.nextInt(); // Se debe introducir un entero sino, da error en tiempo de ejecucion
		
		// Mostramos el resultado
		System.out.printf("La longitud de la circunferencia de radio " + radio + " es: %.2f %n" , 2*Math.PI*radio);
		
		// Cerramos el flujo entrada
		entrada.close();
	}
}
