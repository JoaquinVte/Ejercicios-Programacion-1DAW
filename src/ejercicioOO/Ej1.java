//1) Haz una clase llamada Persona que siga las siguientes condiciones:
//
//-Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura. No queremos que se accedan directamente a ellos. 
// Piensa que modificador de acceso es el más adecuado, también su tipo. Si quieres añadir algún atributo puedes hacerlo.
//-Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía para String, etc.). 
// Sexo sera hombre por defecto, usa una constante para ello.
//-Se implantaran varios constructores:
//	Un constructor por defecto.
//	Un constructor con el nombre, edad y sexo, el resto por defecto.
//	Un constructor con todos los atributos como parámetro.
//-Los métodos que se implementaran son:
//	calcularIMC(): calculara si la persona esta en su peso ideal (peso en kg/(altura^2  en m)), devuelve un -1 si esta por debajo de su peso ideal, 
//	un 0 si esta en su peso ideal y un 1 si tiene sobrepeso .Te recomiendo que uses constantes para devolver estos valores.
//		Bajo peso (IMC <18,5)
//		Rango normal (IMC = 18,5-24,99)
//		Sobrepeso (IMC = 25-29,99)
//-esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
//-comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si no es correcto, sera H. No sera visible al exterior.
//-toString(): devuelve toda la información del objeto.
//-generaDNI(): genera un numero aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente. 
// Este método sera invocado cuando se construya el objeto. Puedes dividir el método para que te sea más fácil. 
// No será visible al exterior.
//-Métodos set de cada parámetro, excepto de DNI.
//
//Ahora, crea una clase ejecutable que haga lo siguiente:
//
//-Pide por teclado el nombre, la edad, sexo, peso y altura.
//-Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores variables pedidas por teclado, 
// el segundo objeto obtendrá todos los anteriores menos el peso y la altura y el último por defecto, para este último utiliza 
// los métodos set para darle a los atributos un valor.
//-Para cada objeto, deberá comprobar si esta en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
//-Indicar para cada objeto si es mayor de edad.
//-Por último, mostrar la información de cada objeto.
package ejercicioOO;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String nombre;
		int edad;
		char sexo;
		float peso;
		float altura;
		Persona persona1;
		Persona persona2;
		Persona persona3;
		
		System.out.println("Dame el nombre: ");
		nombre = entrada.next();
		System.out.println("Dame la edad: ");
		edad = entrada.nextInt();
		System.out.println("Dame el sexo: ");
		sexo = entrada.next().charAt(0);
		System.out.println("Dame el peso: ");
		peso = entrada.nextFloat();
		System.out.println("Dame la altura: ");
		altura = entrada.nextFloat();
		
		persona1 = new Persona(nombre,edad,sexo,peso,altura);
		persona2 = new Persona(nombre,edad,sexo);
		persona3 = new Persona();
		
		persona3.setNombre(nombre);
		persona3.setEdad(edad);
		persona3.setSexo(sexo);
		persona3.setPeso(peso);
		persona3.setAltura(altura);
		
		System.out.println("El peso para la persona1 es: " + persona1.calcularIMC());
		System.out.println("El peso para la persona2 es: " + persona2.calcularIMC());
		System.out.println("El peso para la persona3 es: " + persona3.calcularIMC());
		
		System.out.println("La persona 1 es mayor de edad: " + persona1.esMayorDeEdad());
		System.out.println("La persona 2 es mayor de edad: " + persona2.esMayorDeEdad());
		System.out.println("La persona 3 es mayor de edad: " + persona3.esMayorDeEdad());
		
		System.out.println("Datos de la persona1:");
		System.out.println(persona1.toString());
		System.out.println("Datos de la persona2:");
		System.out.println(persona2.toString());
		System.out.println("Datos de la persona3:");
		System.out.println(persona3.toString());
		
		entrada.close();
	}

}
