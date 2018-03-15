//Realiza un programa que genere letras aleatoriamente y determine si son vocales o consonantes.

package ejercicios;

public class Ej7 {
	public static void main(String[] arg){
		
		char letra;
		int i;

		for (i=1;i<=20;i++){
			//Generamos letra aleatoria
			letra = (char)(Math.random()*26 + 'a');
			if (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u'){
				System.out.println("la letra " + letra + " es una consonante");
			} else {
				System.out.println("la letra " + letra + " es una vocal");
			}
			
		}
		

	}
}
