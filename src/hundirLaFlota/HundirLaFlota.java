package hundirLaFlota;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class HundirLaFlota {
	public static void main(String[] args) {

		// Inicializamos las variables necesarias
		char[][] tableroJugador, tableroDisparosJugador, tableroPC, tableroDisparosPC;

		// Cantidad de barcos y sus tamaños
		// int[] barcos = {4,3,3,3,2,2,2,1,1};
		int[] barcos = { 4 };

		// Dimension del tablero + 1 para coordenadas catesianas
		int dimensionTablero = 11;

		// Incializamos las variables de los marcadores a la suma de los barcos
		int marcadorJugador = sumaCeldas(barcos);
		int marcadorPC = marcadorJugador;

		// Variable que almacenara el nombre del jugador
		String nombre;

		// Variable para la obtencion de datos del usuario
		Scanner entrada = new Scanner(System.in);

		// Variable que almacena el exito de un disparo
		boolean tocado;

		tableroJugador = new char[dimensionTablero][dimensionTablero];
		tableroDisparosJugador = new char[dimensionTablero][dimensionTablero];
		tableroPC = new char[dimensionTablero][dimensionTablero];
		tableroDisparosPC = new char[dimensionTablero][dimensionTablero];

		borrarPantalla();
		System.out.println("=======================");
		System.out.println("    HUNDIR LA FLOTA!   ");
		System.out.println("  V1.0 Joaquin Alonso  ");
		System.out.println("     DAW 2016/2017     ");
		System.out.println("=======================");

		System.out.print("Introduce tu nombre: ");
		nombre = entrada.next();
		borrarPantalla();

		// inicializamos tableros
		inicializarTablero(tableroJugador);
		inicializarTablero(tableroDisparosJugador);
		inicializarTablero(tableroPC);
		inicializarTablero(tableroDisparosPC);

		// colocamos los barcos del Jugador
		colocarBarcosJugador(tableroJugador, tableroDisparosJugador, barcos);

		// Colocamos los barcos de la computadora
		colocarBarcosPC(tableroPC, barcos);

		// Mecanica de Juego
		while (marcadorJugador > 0 && marcadorPC > 0) {
			borrarPantalla();
			System.out.println("  Tablero PC \t\t\t  Tablero PC Disparos \n");
			visualizarTablero(tableroPC, tableroDisparosPC);
			System.out.println();
			System.out.println("  Tablero Jugador \t\t  Tablero Disparos \n");
			visualizarTablero(tableroJugador, tableroDisparosJugador);
			System.out.println();
			System.out.println("Disparos correctos para ganar el jugador: " + marcadorJugador);
			System.out.println("Disparos correctos para ganar el PC: " + marcadorPC);

			if (disparoJugador(tableroDisparosJugador, tableroPC)) {
				marcadorJugador--;
				if (marcadorJugador == 0) {
					break;
				}
			}
			if (disparoPC(tableroDisparosPC, tableroJugador)) {
				marcadorPC--;
				if (marcadorPC == 0) {
					break;
				}
			}

		}

		// Mostramos el nombre del ganador, si es la computadora, mostramos su
		// tablero
		if (marcadorJugador == 0) {
			System.out.println("Enhorabuena " + nombre + " has ganado !!!!");
		} else {
			System.out.println("Lo siento, ha ganado la computadora :(");
			System.out.println("Este era el tablero del PC: \n");
			System.out.println(" Tablero computadora \t\t  Tablero Disparos \n");
			visualizarTablero(tableroPC, tableroDisparosPC);
		}

		// Reproducimos el sonido de game over
		try {
			sonido();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Este metodo inicializa cada tablero de la siguiente manera:
	 * 
	 * A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ D ~ ~ ~
	 * ~ ~ ~ ~ ~ ~ ~ E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ G ~ ~ ~ ~ ~ ~ ~
	 * ~ ~ ~ H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ 0
	 * 1 2 3 4 5 6 7 8 9
	 */
	public static void inicializarTablero(char[][] tablero) {
		int fil, col;

		for (fil = 0; fil < tablero[1].length; fil++) {
			tablero[fil][0] = (char) ('A' + fil);
			if (fil != tablero[1].length - 1) {
				for (col = 1; col < tablero[0].length; col++) {
					tablero[fil][col] = '~';
				}
			} else {
				tablero[fil][0] = ' ';
				for (col = 1; col < tablero[0].length; col++) {
					tablero[fil][col] = (char) ('0' + col - 1);
				}
			}
		}
	}

	// Este metodo visualiza el tablero por pantalla
	public static void visualizarTablero(char[][] tablero, char[][] tableroDisparos) {

		int fil, col;
		// System.out.println(" Tablero Jugador \t\t Tablero Disparos \n");
		for (fil = 0; fil < tablero[1].length; fil++) {
			for (col = 0; col < tablero[0].length; col++) {
				System.out.print(tablero[fil][col] + " ");
			}
			System.out.print("\t\t");
			for (col = 0; col < tableroDisparos[0].length; col++) {
				System.out.print(tableroDisparos[fil][col] + " ");
			}
			System.out.println("");
		}
	}

	// Este metodo borra la terminal
	public static void borrarPantalla() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static int sumaCeldas(int[] unVector) {
		int suma = 0;
		for (int i = 0; i < unVector.length; i++) {
			suma = suma + unVector[i];
		}
		return suma;
	}

	// Este metodo coloca los barcos pasados como vector dentro del tablero del
	// Jugador
	public static void colocarBarcosJugador(char[][] tablero, char[][] tableroDisparos, int[] barcos) {

		Scanner entrada = new Scanner(System.in);
		boolean colocado;

		int coordenadaX, coordenadaY, orientacion;

		for (int barco : barcos) {
			colocado = false;
			do {
				borrarPantalla();
				visualizarTablero(tablero, tableroDisparos);
				System.out.println("Vamos a proceder a colocar el barco de " + barco + " celdas.");
				System.out.println("Introduce la coordenada Y (A-J):");
				coordenadaY = entrada.next().toUpperCase().charAt(0) - 'A';

				System.out.println("Introduce la coordenada X (0-9):");
				coordenadaX = entrada.nextInt() + 1;

				System.out.println("Introduce la orientacion (1-Horizontal   0-Vertical) :");
				orientacion = entrada.nextInt();

				if (orientacion == 1) {
					colocado = colocarBarco(tablero, barco, coordenadaY, coordenadaX, 1, true);
				} else {
					colocado = colocarBarco(tablero, barco, coordenadaY, coordenadaX, 0, true);
				}
			} while (!colocado);
		}
	}

	// Este metodo coloca los barcos pasados como vector dentro del tablero del
	// PC
	public static void colocarBarcosPC(char[][] tablero, int[] barcos) {

		boolean colocado;

		int coordenadaX, coordenadaY, orientacion;

		for (int barco : barcos) {
			colocado = false;

			do {
				coordenadaY = (int) (Math.random() * 10);

				coordenadaX = (int) (Math.random() * 10);

				orientacion = (int) (Math.random() * 2);

				if (orientacion == 1) {
					colocado = colocarBarco(tablero, barco, coordenadaY, coordenadaX, 1, false);
				} else {
					colocado = colocarBarco(tablero, barco, coordenadaY, coordenadaX, 0, false);
				}
			} while (!colocado);

		}
	}

	// Este metodo comprueba si hay algun barco en la zona del barco a colocar
	public static boolean hayColision(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
		boolean colision = false;

		switch (orientacion) {
		case 0:
			for (int i = fila; i < fila + longitudBarco && !colision; i++) {
				if (tablero[i][columna] != '~') {
					colision = true;
				}
			}
			break;

		case 1:
			for (int i = columna; i < columna + longitudBarco && !colision; i++) {
				if (tablero[fila][i] != '~') {
					colision = true;
				}
			}
			break;
		}
		return colision;
	}

	// Este metodo coloca un barco en una posicion si este cabe en tablero y no
	// coincide ninguna posicion con otro barco en la zona
	public static boolean colocarBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion,
			boolean jugador) {
		boolean colocado = false;
		Scanner entrada = new Scanner(System.in);

		switch (orientacion) {
		case 1: // Comprobamos que el barco no salga de los limites del vector
				// Si no supera los limites, colocamos el barco
			if (columna + longitudBarco < tablero[1].length) {
				if (!hayColision(tablero, longitudBarco, fila, columna, 1)) {
					for (int i = columna; i < columna + longitudBarco; i++) {
						tablero[fila][i] = 'B';
					}
					colocado = true;
				} else if (jugador) {
					System.out.println("Ya existe un barco en la zona donde lo quieres colocar. Vuelve a intentarlo.");
					entrada.next();
				}
			} else if (jugador) {
				System.out.println("El barco no cabe en esa poscion. Vuelve a intentarlo.");
				entrada.next();
			}
			break;
		case 0: // Comprobamos que el barco no salga de los limites del vector
				// Si no supera los limites, colocamos el barco
			if ((fila + longitudBarco) < tablero[0].length) {
				// Si no hay otro barco en esa zona
				if (!hayColision(tablero, longitudBarco, fila, columna, 0)) {
					for (int i = fila; i < fila + longitudBarco; i++) {
						tablero[i][columna] = 'B';
					}
					colocado = true;
				} else if (jugador) {
					System.out.println("Ya existe un barco en la zona donde lo quieres colocar. Vuelve a intentarlo.");
					entrada.next();
				}
			} else if (jugador) {
				System.out.println("El barco no cabe en esa poscion. Vuelve a intentarlo.");
				entrada.next();
			}
			break;
		}

		return colocado;
	}

	public static boolean disparoJugador(char[][] tableroDisparosJugador, char tableroPC[][]) {

		int horizontal, vertical;
		char letra;
		boolean fallo = true;
		boolean disparo = false;
		Scanner entrada = new Scanner(System.in);

		do {
			System.out.println("Digame una coordenada (letra): ");
			vertical = entrada.next().toUpperCase().charAt(0) - 'A';

			System.out.println("Digame una coordenada (numero): ");
			horizontal = entrada.nextInt() + 1;

			if (tableroPC[vertical][horizontal] == 'B') {
				disparo = true;
				fallo = false;
				tableroPC[vertical][horizontal] = 'T';
				tableroDisparosJugador[vertical][horizontal] = 'T';
			} else if (tableroPC[vertical][horizontal] == '~') {
				tableroPC[vertical][horizontal] = '*';
				tableroDisparosJugador[vertical][horizontal] = '*';
				fallo = false;
			} else {
				System.out.println("Por favor marque una casilla correcta");
			}
		} while (fallo);

		return disparo;
	}

	public static boolean disparoPC(char[][] tableroDisparosPC, char tableroJugador[][]) {

		int horizontal, vertical;
		boolean disparo = false;
		boolean fallo = true;

		do {
			vertical = (int) (Math.random() * 10);
			horizontal = (int) (Math.random() * 10 + 1);
			if (tableroDisparosPC[vertical][horizontal] == '~') {
				fallo = false;
			}
		} while (fallo);

		if (tableroJugador[vertical][horizontal] == 'B') {
			disparo = true;
			tableroJugador[vertical][horizontal] = 'T';
			tableroDisparosPC[vertical][horizontal] = 'T';
		} else if (tableroJugador[vertical][horizontal] == '~') {
			tableroDisparosPC[vertical][horizontal] = '*';
			tableroJugador[vertical][horizontal] = '*';
		}

		return disparo;
	}

	public static void sonido()
			throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
		Clip sonido = AudioSystem.getClip();
		sonido.open(AudioSystem.getAudioInputStream(new File("game-over.wav")));
		sonido.start();
		Thread.sleep(10000);
	}
}
