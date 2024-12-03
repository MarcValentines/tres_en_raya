package tres_en_ralla_code;
import java.util.Scanner;
import java.util.Arrays; //este es una librería para poder interactuar con los arrays de forma más simple
import java.util.Random;
public class Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaTec = new Scanner(System.in);
		Random random = new Random();
		
		String[][] Tablero = {{"-", "-", "-"},
				  			{"-", "-", "-"},
				  			{"-", "-", "-"}};
		
		
		//las rondas disponibles
		int posicTablero = 9;
		//recuento filas y columnas para las rondas
		int contFil = 0;
		int contColumn = 0;
		//encontrar unn ganador
		boolean finPorVictoria = false;
		
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
		
		int rondTip = random.nextInt(2) + 1;
		
		if (rondTip == 1) {
			System.out.println("Ha salido cara!!");
		}else if (rondTip == 2) {
			System.out.println("Ha salido cruz!!");
		}
		
		//mostrar el tablero inicialmente
		int contFilas = 0;
		int contColumnas = 0;
		
		for (int i = 0; i < Tablero.length; i++) {
			for (int j = 0; j < Tablero[i].length; j++) {
				if (contColumnas == 0) {
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
		contColumnas = 0;
		contFilas = 0;
		
		//sistema de rondas
		for (int i = 0; i < posicTablero; i++) {
			int rondas = i + 1;
			System.out.println("Ronda " + rondas);
			
			int columna = 0;
			int fila = 0;
			
			//sistema para quien empieza, se determina para cada ronda quien va a jugar
			if (rondTip == 1) {
				
				//mostrar a quien le toca
				System.out.println("Turno del jugador " + jugador1);
				
				System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
				fila = entradaTec.nextInt();
				while (fila > 2 | fila < 0) {
					System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
					fila = entradaTec.nextInt();
				}
				System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
				columna = entradaTec.nextInt();
				while (columna > 2 | columna < 0) {
					System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
					columna = entradaTec.nextInt();
				}
				
				//sección para comprobar que la posición no se encuentre ocupada
				while (Tablero[fila][columna].equals("x") | Tablero[fila][columna].equals("o")) {
					System.out.println("Esta posición se encuentra ocupada :( ");
					
					System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
					fila = entradaTec.nextInt();
					while (fila > 2 | fila < 0) {
						System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
						fila = entradaTec.nextInt();
					}
					System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
					columna = entradaTec.nextInt();
					while (columna > 2 | columna < 0) {
						System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
						columna = entradaTec.nextInt();
					}
					
				} 
				
				if (Tablero[fila][columna].equals("-")) {
					Tablero[fila][columna] = "x"; //modificar el interior del array
					
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
			} else if (rondTip == 2) {
				
				//mostrar a quien le toca
				System.out.println("Turno del jugador " + jugador2);
				
				System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
				fila = entradaTec.nextInt();
				while (fila > 2 | fila < 0) {
					System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
					fila = entradaTec.nextInt();
				}
				System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
				columna = entradaTec.nextInt();
				while (columna > 2 | columna < 0) {
					System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
					columna = entradaTec.nextInt();
				}
				
				//sección para comprobar que la posición no se encuentre ocupada
				while (Tablero[fila][columna].equals("x") | Tablero[fila][columna].equals("o")) {
					System.out.println("Esta posición se encuentra ocupada :( ");
					
					System.out.println("Selecciona la fila donde quieres colocar la ficha = ");
					fila = entradaTec.nextInt();
					while (fila > 2 | fila < 0) {
						System.out.println("No es un valor válido, vuelve a intentarlo (0 - 2) = ");
						fila = entradaTec.nextInt();
					}
					System.out.println("Selecciona la columna en la que quieres poner la ficha = ");
					columna = entradaTec.nextInt();
					while (columna > 2 | columna < 0) {
						System.out.println("No es una columna válida, vuelve a intentarlo (0 - 2) = ");
						columna = entradaTec.nextInt();
					}
					
				}
				
				if (Tablero[fila][columna].equals("-")) {
					Tablero[fila][columna] = "o"; //modificar el interior del array
					
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
//			if(Tablero[0][0].equals("x") && Tablero[1][0].equals("x") && Tablero[2][0].equals("x")) {
//				System.out.println("Gana el jugador " + jugador1);
//				finPorVictoria = true;
//			}else if (Tablero[0][0].equals("o") && Tablero[1][0].equals("o") && Tablero[2][0].equals("o")) {
//				System.out.println("Gana el jugador " + jugador2);
//				finPorVictoria = true;
//			}else if (Tablero[0][1].equals("x") && Tablero[1][1].equals("x") && Tablero[2][1].equals("x")) {
//				System.out.println("Gana el jugador " + jugador1);
//				finPorVictoria = true;
//			}else if (Tablero[0][1].equals("o") && Tablero[1][1].equals("o") && Tablero[2][1].equals("o")) {
//				System.out.println("Gana el jugador " + jugador2);
//				finPorVictoria = true;
//			}else if (Tablero[0][2].equals("o") && Tablero[1][2].equals("o") && Tablero[2][2].equals("o")) {
//				System.out.println("Gana el jugador " + jugador2);
//			}else if (Tablero[0][2].equals("x") && Tablero[1][2].equals("x") && Tablero[2][2].equals("x")) {
//				System.out.println("Gana el jugador " + jugador1);
//				finPorVictoria = true;
//			}
			
			//en horizontal
//			if(Tablero[0][0].equals("x") && Tablero[0][1].equals("x") && Tablero[0][2].equals("x")) {
//				System.out.println("Gana el jugador " + jugador1);
//				finPorVictoria = true;
//			}else if (Tablero[0][0].equals("o") && Tablero[0][1].equals("o") && Tablero[0][2].equals("o")) {
//				System.out.println("Gana el jugador " + jugador2);
//				finPorVictoria = true;
//			}else if (Tablero[1][0].equals("x") && Tablero[1][1].equals("x") && Tablero[1][2].equals("x")) {
//				System.out.println("Gana el jugador " + jugador1);
//				finPorVictoria = true;
//			}else if (Tablero[1][0].equals("o") && Tablero[1][1].equals("o") && Tablero[1][2].equals("o")) {
//				System.out.println("Gana el jugador " + jugador2);
//				finPorVictoria = true;
//			}else if (Tablero[2][0].equals("o") && Tablero[2][1].equals("o") && Tablero[2][2].equals("o")) {
//				System.out.println("Gana el jugador " + jugador2);
//			}else if (Tablero[2][0].equals("x") && Tablero[2][1].equals("x") && Tablero[2][2].equals("x")) {
//				System.out.println("Gana el jugador " + jugador1);
//				finPorVictoria = true;
//			}
			
			//en diagonal
			
			
			if(finPorVictoria) {
				System.out.println("Fin de la partida!!");
				entradaTec.nextLine();
				System.out.println("Quieres una revancha (si - no) ?");
				String revancha = entradaTec.nextLine().toLowerCase();
				if (revancha.equals("si")) {
					finPorVictoria = false;
					i = 0 -1; // se vuelve a empezar el bucle for para una nueva partida
					System.out.println("Se vuelve a lanzar una moneda !!");
					rondTip = random.nextInt(2) +1;
					if(rondTip == 1) {
						System.out.println("empieza el jugador " + jugador1);
					}else if (rondTip == 2) {
						System.out.println("Empieza el jugador " + jugador2);
					}
				}else {
					System.out.println("Has seleccionado salir");
					System.out.println("|| ... Exiting ... ||");
					break;
				}
			}
			
			//revalorizar rondTip
			if (rondTip == 1) {
				rondTip++;
			} else if (rondTip == 2) {
				rondTip--;
			}
			
		}
		
	}

}
