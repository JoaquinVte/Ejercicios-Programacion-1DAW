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

package ejercicioOO;

public class Persona {
	private final static char DEFAULT_SEX = 'H';

	private final static int SOBREPESO = 1;
	private final static int PESOIDEAL = 0;
	private final static int INFRAPESO = -1;

	private String nombre;
	private int edad;
	private int DNI;
	private char letraDNI;
	private char sexo;
	private float peso;
	private float altura;

	public Persona() {
		nombre = "";
		edad = 0;
		DNI = generaDNI();
		letraDNI = generaLetraDNI();
		peso = 0;
		altura = 0;
		sexo = DEFAULT_SEX;
	}
	public Persona(String nombre,int edad, char sexo){
		this.nombre = nombre;
		this.edad = edad;
		DNI = generaDNI();
		letraDNI = generaLetraDNI();
		peso = 0;
		altura = 0;
		sexo = comprobarSexo(sexo);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	private int generaDNI() {
		return (int) (Math.random() * 100000000);
	}

	private char generaLetraDNI() {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		return letras.charAt(DNI % 23);
	}

	private char comprobarSexo(char sexo) {
		if (sexo == 'M' || sexo == 'm')
			return 'M';
		else
			return DEFAULT_SEX;
	}
	
	public int calcularIMC(){
		float imc = this.peso/(int)Math.pow(this.altura/100,2);
		if (imc>=25) return SOBREPESO;
		else if (imc<18.5) return INFRAPESO;
		else return PESOIDEAL;
	}

	public boolean esMayorDeEdad() {
		return (edad >= 18) ? true : false;
	}

	public String toString() {

		return "Los datos de la persona son:\n" + "Nombre: " + this.nombre + "\n" + "Edad: " + this.edad + "\n"
				+ "DNI : " + this.DNI + "-" + this.letraDNI + "\n" + "Sexo: "
				+ ((this.sexo == 'H') ? "Hombre" : "Mujer") + "\n" + "Peso: " + this.peso + "\n" + "Altura: "
				+ this.altura + "\n";
	}
}
