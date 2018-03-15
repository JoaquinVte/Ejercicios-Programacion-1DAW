//Realiza un juego, en el que el usuario deba adivinar un numero del 1 al 10 genereado por el ordenador, en tres intentos como máximo. 
//Al final del juego se debe mostrar un mensaje donde se indique si se ha acertado el numero, o en caso contrario el numero no adivinado.

package UF1_P2;
import java.util.Scanner;

public class Ej8 {
	public static void main(String[] arg){
		int intentos=3,numero,i;
		boolean acertado = false;
		Scanner entrada = new Scanner(System.in);

		
		numero = (int)(Math.random()*10 + 1);
		System.out.println("Adivina el numero:");

		while(!acertado && intentos > 0){
			i= entrada.nextInt();
			if (i==numero){
				System.out.println("Enhorabuena !!!, el numero buscado era "+numero);
				acertado=true;
			} else if (i>numero){
				System.out.println("Error !! El numero buscado es menor. Intentalo otra vez .");
			} else {
				System.out.println("Error !! El numero buscado es mayor. Intentalo otra vez .");
			}
			intentos--;
		}
		if(intentos==0 && acertado==false){
			System.out.println("Lo siento has perdido, el numero era "+numero);
		}
		
		entrada.close();
	}
}
