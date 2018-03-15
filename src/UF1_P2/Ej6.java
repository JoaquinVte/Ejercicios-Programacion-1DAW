//Realiza un programa que genere resultados de la quiniela como si fueran realizados por un dado. 
//Los dados de este tipo tiene 3 caras con un 1, 2 caras con una X, y una cara con un 2.

package ejercicios;

public class Ej6 {
	public static void main (String[] args){
		
		int cara;
		
		System.out.println(" Local\t Empate\tVisitante");
		System.out.println("-------------------------------");
		for(int i=1;i<=16;i++){
			
			cara=(int)(Math.random()*6+1);
			
			switch (cara) {
			case 1: case 2: case 3:
				System.out.printf("   %s\n",1);
				break;
			
			case 4: case 5:
				System.out.printf("\t   %s\n","X");
				break;
				
			case 6:
				System.out.printf("\t\t   %s\n", 2);
				break;
			}
		}
	}
}
