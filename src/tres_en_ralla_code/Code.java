package tres_en_ralla_code;
import java.util.Scanner;
import java.util.Arrays; //este es una librería para poder interactuar con los arrays de forma más simple
import java.util.Random;
public class Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaTec = new Scanner(System.in);
		Random random = new Random();
		
		//matriz que se va a mostrar a los jugadores
		String[][] Tablero = {{"-", "-", "-"},
				  			{"-", "-", "-"},
				  			{"-", "-", "-"}};
		
		//matriz para comprobar si hay ganador
		int[][] calcVictoria = {{0, 0, 0},
	  							{0, 0, 0},
	  							{0, 0, 0}};
		
		//las rondas disponibles
		int posicTablero = 9;
		//recuento filas y columnas para las rondas
		int contFil = 0;
		int contColumn = 0;
		//encontrar unn ganador
		boolean finPorVictoria = false;
		//Contar victórias de los jugadores
		int VictJ1 = 0;
		int VictJ2 = 0;
		
		System.out.println("|---Bienvenido al 3 en ralla!!!---|");
		System.out.println("Las normas son simples, se van a mostrar a continuación");
		System.out.println();
		System.out.println("Se lanzará una \"moneda\" (se escoge aleatoriamente) para elegir quien empezara primero, el jugador 1 o el jugador 2.");
		System.out.println("Los dos jugadores irán poniendo las fichas hasta que: ");
		System.out.println(" - Uno de los dos jugadores haya conseguido poner 3 fichas en línea, ya sea horizontalmente, verticalmente o diagonalmente.");
		System.out.println(" - Haya un empate debido a que no quedan mas huecos libres en el tablero.");
		System.out.println();
		
		//ingresar los nombres de los jugadores
		System.out.print("inserta el nombre del jugador 1 = ");
		String jugador1 = entradaTec.nextLine();
		
		System.out.println();
		
		System.out.print("Inserta el nombre del jugador 2 = ");
		String jugador2 = entradaTec.nextLine();
		
		System.out.println("Se va a lanzar una moneda, si sale cara empieza " + jugador1);
		System.out.println("Si sale cruz empieza " + jugador2);
		
		int moneda = random.nextInt(2) + 1; //aquí se declara de forma random el valor de la moneda (1 0 2)
		
		if (moneda == 1) { //en caso de que salga 1
			System.out.println("Ha salido cara!!");
		}else if (moneda == 2) { //en caso de que salga 2
			System.out.println("Ha salido cruz!!");
		}
		
		//mostrar el tablero inicialmente
		int contFilas = 0;
		int contColumnas = 0;
		
		for (int i = 0; i < Tablero.length; i++) {
			for (int j = 0; j < Tablero[i].length; j++) {
				if (contColumnas == 0) { //en caso de que el numero de columnas sea 0 se muestra la fila
					System.out.print("Fila = " + contFilas + "| " + contColumnas + Tablero[i][j] + " ");
					contColumnas++;
				}else {
					System.out.print(contColumnas + Tablero[i][j] + " ");
					contColumnas++;
				}
			}
			contColumnas = 0;
			contFilas++;
			System.out.println();
		}
		contColumnas = 0; //se ponen ambos valores a 0 por si hay que reciclarlos
		contFilas = 0;
		
		//sistema de rondas
		for (int i = 0; i < posicTablero; i++) { //se empieza un sistema de rondas donde el numero de rondas es el numero de posiciones que tiene el tablero
			int rondas = i + 1;
			System.out.println("Ronda " + rondas); //mostrar el numero de ronda
			
			//declarar los valores para seleccionar la fila y columna que quiere ser ocupada por el jugador
			int columna = 0;
			int fila = 0;
			
			//sistema para quien empieza, se determina para cada ronda quien va a jugar
			if (moneda == 1) { // en caso que el valor de moneda sea 1
				
				//mostrar a quien le toca
				System.out.println("Turno del jugador " + jugador1);
				
				System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
				fila = entradaTec.nextInt();
				while (fila > 2 || fila < 0) { //en caso de que la fila no entre dentro de los valores válidos
					System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
					fila = entradaTec.nextInt();
				}
				System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
				columna = entradaTec.nextInt();
				while (columna > 2 || columna < 0) { //en caso de que la columna no entre dentro de los valores válidos
					System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
					columna = entradaTec.nextInt();
				}
				
				//sección para comprobar que la posición no se encuentre ocupada
				while (Tablero[fila][columna].equals("x") || Tablero[fila][columna].equals("o")) {
					System.out.println("Esta posición se encuentra ocupada :( ");
					
					System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
					fila = entradaTec.nextInt();
					while (fila > 2 || fila < 0) { //en caso de que la fila no entre dentro de los valores válidos
						System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
						fila = entradaTec.nextInt(); //revalorizar el entero llamado fila
					}
					System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
					columna = entradaTec.nextInt();
					while (columna > 2 || columna < 0) { //en caso de que la columna no entre dentro de los valores válidos
						System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
						columna = entradaTec.nextInt(); //revalorizar el entero llamado columna
					}
					
				} 
				
				if (Tablero[fila][columna].equals("-")) { //si en la posición indicada se encuentra el siguiente carácter
					Tablero[fila][columna] = "x"; //modificar el interior del array
					calcVictoria[fila][columna] = 1; //para la suma de la matriz (para saber el ganador)
					
					//mostrar el contenido del tablero
					for (int x = 0; x < Tablero.length; x++) {
						for (int j = 0; j < Tablero[x].length; j++) {
							if (contColumnas == 0) {
								System.out.print("Fila = " + contFilas + "| " + contColumnas + Tablero[x][j] + " ");
								contColumnas++;
							}else {
								System.out.print(contColumnas + Tablero[x][j] + " ");
								contColumnas++;
							}
						}
						contColumnas = 0;
						contFilas++;
						System.out.println();
					}
					contColumnas = 0;
					contFilas = 0;
				}
				
			
			//en el turno del jugador 2	
			} else if (moneda == 2) { //en caso que el valor de la moneda sea 2
				
				//mostrar a quien le toca
				System.out.println("Turno del jugador " + jugador2);
				
				System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
				fila = entradaTec.nextInt();
				while (fila > 2 || fila < 0) { //en caso de que la fila no entre dentro de los valores válidos
					System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
					fila = entradaTec.nextInt();
				}
				System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
				columna = entradaTec.nextInt();
				while (columna > 2 || columna < 0) { //en caso de que la columna no entre dentro de los valores válidos
					System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
					columna = entradaTec.nextInt();
				}
				
				//sección para comprobar que la posición no se encuentre ocupada
				while (Tablero[fila][columna].equals("x") || Tablero[fila][columna].equals("o")) {
					System.out.println("Esta posición se encuentra ocupada :( ");
					
					System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
					fila = entradaTec.nextInt();
					while (fila > 2 || fila < 0) { //en caso de que la fila no entre dentro de los valores válidos
						System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
						fila = entradaTec.nextInt();
					}
					System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
					columna = entradaTec.nextInt();
					while (columna > 2 || columna < 0) { //en caso de que la columna no entre dentro de los valores válidos
						System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
						columna = entradaTec.nextInt();
					}
					
				}
				
				if (Tablero[fila][columna].equals("-")) {
					Tablero[fila][columna] = "o"; //modificar el interior del array
					calcVictoria[fila][columna] = -1; //para la suma de la matriz (para saber el ganador)
					
					//mostrar el contenido del tablero
					for (int x = 0; x < Tablero.length; x++) {
						for (int j = 0; j < Tablero[x].length; j++) {
							if (contColumnas == 0) {
								System.out.print("Fila = " + contFilas + "| " + contColumnas + Tablero[x][j] + " ");
								contColumnas++;
							}else {
								System.out.print(contColumnas + Tablero[x][j] + " ");
								contColumnas++;
							}
						}
						contColumnas = 0;
						contFilas++;
						System.out.println();
					}
					contColumnas = 0;
					contFilas = 0;
				}
				
			}
			
			//Comprobar si hay ganador
			//de forma vertical
			
			int sumCol = 0; //se declara la suma de columnas
			for (int x = 0; x < calcVictoria.length; x++) { 
				
				for (int j = 0; j < calcVictoria[x].length; j++) {
					 sumCol += calcVictoria[j][x];
				
					 if (sumCol == 3) {
						 finPorVictoria = true;
						 VictJ1++;
						 System.out.println("|| El JUGADOR " + jugador1 + " gana!! ||");
						 break;
					 }else if (sumCol == -3) {
						 finPorVictoria = true;
						 VictJ2++;
						 System.out.println("|| El JUGADOR " + jugador2 + " gana!! ||");
						 break;
					 }
				}
				sumCol = 0;
			}
			
			//en horizontal
			
			for (int x = 0; x < calcVictoria.length; x++) {
				int sumFil = 0; // se declara entero para la suma del valor de las filas
				for (int j = 0; j < calcVictoria[x].length; j++) {
					sumFil += calcVictoria[x][j];
				}
				if (sumFil == 3) { // en caso que una suma de 3
					finPorVictoria = true;
					VictJ1++;
					System.out.println("|| El personaje " + jugador1 + " gana!! ||");
					break;
				}else if (sumFil == -3) { // en caso que una suma de -1
					finPorVictoria = true;
					VictJ2++;
					System.out.println("|| El personaje " + jugador2 + " gana!! ||");
					break;
				}
			}
			
			//en diagonal
			int filas = calcVictoria.length; // se declara la longitud de las filas
			//de izquierda a derecha
			int sumDiag1 = 0;
		    for (int x = 0; x < filas; x++) { 
		        sumDiag1 += calcVictoria[x][x];  // Suma los elementos de la diagonal principal
		    }
		    if (sumDiag1 == 3) { // en caso que una suma de 3
		    	finPorVictoria = true;
				VictJ1++;
				System.out.println("|| El chavo llamao " + jugador1 + " gana!! ||");
			} else if (sumDiag1 == -3) { // en caso que una suma de -3
				finPorVictoria = true;
				VictJ2++;
				System.out.println("|| El chavo llamao " + jugador2 + " gana!! ||");
			}
		    
		    //de derecha a izquierda
		    int sumDiag2 = 0;
		    for (int x = 0; x < filas; x++) {
		        sumDiag2 += calcVictoria[x][filas - x - 1];  // Suma los elementos de la diagonal secundaria
		    }
	    	if (sumDiag2 == 3) {
	    		finPorVictoria = true;
	    		VictJ1++;
	    		System.out.println("|| El niño este -> " + jugador1 + " gana la partida :O ||");
	    	} else if (sumDiag2 == -3) {
	    		finPorVictoria = true;
	    		VictJ2++;
	    		System.out.println("|| El niño este -> " + jugador2 + " gana la partida :O ||");
	    	}
	    	
	    	//en caso de que terminen todas las rondas y no haya ningún ganador =
	    	if (i == 9 && !finPorVictoria) {
				System.out.println("|| NO HAY GANADOR, HA SIDO EMPATE ||");
				finPorVictoria = true;
			}
			
			//En caso de que haya un final por victória
			if(finPorVictoria) {
				System.out.println("Fin de la partida!!");
				System.out.println("El Jugador " + jugador1 + " tiene " + VictJ1 + " victorias!!");
				System.out.println("El Jugador " + jugador2 + " tiene " + VictJ2 + " victorias!!");
				entradaTec.nextLine();
				System.out.println("Quieres una revancha ?");
				System.out.println("Escribe 'si' para realizarla");
				String revancha = entradaTec.nextLine().toLowerCase();
				if (revancha.equals("si")) {
					//poner el tablero entero con "-" para poder jugar
					
					for (int x = 0; x < Tablero.length; x++) {
						for (int j = 0; j < Tablero[x].length; j++) {
							Tablero[x][j] = "-";
							calcVictoria[x][j] = 0;
						}
					}
					
					//cancelar el fin por victória y lanzar una moneda de nuevo
					finPorVictoria = false;
					i = 0 -1; // se vuelve a empezar el bucle for para una nueva partida
					System.out.println("Se vuelve a lanzar una moneda !!");
					moneda = random.nextInt(2) +1;
					if(moneda == 1) {
						System.out.println("empieza el jugador " + jugador1);
					}else if (moneda == 2) {
						System.out.println("Empieza el jugador " + jugador2);
					}
					//mostrar por pantalla el tablero
					for (int x = 0; x < Tablero.length; x++) {
						for (int j = 0; j < Tablero[x].length; j++) {
							if (contColumnas == 0) {
								System.out.print("Fila = " + contFilas + "| " + contColumnas + Tablero[x][j] + " ");
								contColumnas++;
							}else {
								System.out.print(contColumnas + Tablero[x][j] + " ");
								contColumnas++;
							}
						}
						contColumnas = 0;
						contFilas++;
						System.out.println();
					}
					contColumnas = 0;
					contFilas = 0;
				}else { // en caso de que el usuário no escriba "si"
					System.out.println("Has seleccionado salir");
					System.out.println("|| ... Exiting ... ||");
					break;
				}
			}
			
			//revalorizar rondTip
			if (moneda == 1) {
				moneda++;
			} else if (moneda == 2) {
				moneda--;
			}
			
		}
		
	}

}
