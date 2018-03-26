//Programa Java para leer la altura de N personas y calcular la altura media. 
//Calcular cuántas personas tienen una altura superior a la media y cuántas tienen una altura inferior a la media. 
//El valor de N se pide por teclado y debe ser entero positivo.
package ejercicios;

import java.util.Scanner;
public class Ej9{
	public static void main(String[] args){

		Scanner entrada = new Scanner(System.in);
		float[] alturas;

		System.out.println("Cuantas alturas quieres almacenar?:");
		int longitudArray = entrada.nextInt();

		alturas = new float[longitudArray];

		rellenarAlturas(alturas);

		System.out.println("Existen " + numeroPersonasSuperiorMedia(alturas) + " personas con una altura superior a la media y " + numeroPersonasInferiorMedia(alturas) + " personas con altura inferior a la media");
		
		entrada.close();
	}

	public static void rellenarAlturas(float[] listaAlturas){
		int posicion;
		Scanner entrada = new Scanner(System.in);

		for(posicion=0;posicion<listaAlturas.length;posicion++){
			System.out.println("Añade la altura para la entrada "+ posicion);
			listaAlturas[posicion] = entrada.nextFloat();
		}
		entrada.close();
	}

	public static int numeroPersonasSuperiorMedia(float[] listaAlturas){
		int posicion, numeroPersonas=0;

		float media = obtenerMedia(listaAlturas);

		for (posicion=0;posicion<listaAlturas.length;posicion++){
			if (listaAlturas[posicion]>media){
				numeroPersonas++;
			}
		}
		return numeroPersonas;
	}

	public static int numeroPersonasInferiorMedia(float[] listaAlturas){
		int posicion, numeroPersonas=0;

		float media = obtenerMedia(listaAlturas);

		for (posicion=0;posicion<listaAlturas.length;posicion++){
			if (listaAlturas[posicion]<media){
				numeroPersonas++;
			}
		}
		return numeroPersonas;
	}

	public static float obtenerMedia(float[] listaAlturas){
		int cantidad=0,posicion;
		float resultado,suma = 0;

		for(posicion=0;posicion<listaAlturas.length;posicion++){
			
			cantidad++;
			suma=suma+listaAlturas[posicion];
			
		}

		resultado = suma / cantidad;

		return resultado;
	}
}