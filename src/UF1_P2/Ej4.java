//Un programa que pida el valor del radio y calcule el área del circulo para ese radio.

package UF1_P2;
import java.util.Scanner;

public class Ej4 {
	public static void main (String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		float radio;
		
		// Solicitamos el radio.
		System.out.println("Introduce el radio :");
		radio = Float.parseFloat(entrada.nextLine()); // Obtenemos lo introducido por teclado como string y lo pasamos a Float
				
		// Calculamos el area del circulo y mostramos la salida formateada.
		System.out.printf("El area del circulo de radio %s es: %.2f", String.valueOf(radio), Math.pow(Math.PI,2)*radio);
		
		// Cerramos el flujo.
		entrada.close();
	}
}
