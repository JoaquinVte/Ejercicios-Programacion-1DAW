//Realiza un programa que muestre las primeras 10 potencias de dos.

package UF1_P2;

public class Ej2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Realiza un programa que muestre las primeras 10 potencias de dos.

		System.out.println("Las primeras 10 potencias de dos son:");
		for(int i=0;i<=9;i++) {
			System.out.println("2 elevado a " + i + " es: " + (int)Math.pow(2, i));			
		}
	}
}
