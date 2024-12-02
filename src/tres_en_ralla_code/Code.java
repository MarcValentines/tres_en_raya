package tres_en_ralla_code;
import java.util.Scanner;
import java.util.Random;
public class Code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entradaTec = new Scanner(System.in);
		Random random = new Random();
		
		String[][] Tablero = {{"-", "-", "-"},
				  {"-", "-", "-"},
				  {"-", "-", "-"}};
		int posicTablero = 9;
		int numRondJ1 = 0;
		int numRondJ2 = 0;
		int contFil = 0;
		int contColumn = 0;
		
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
		
		int moneda = random.nextInt(2) + 1;
		
		if (moneda == 1) {
			System.out.println("Ha salido cara!!");
			numRondJ1++;
		}else if (moneda == 2) {
			System.out.println("Ha salido cruz!!");
			numRondJ2++;
		}
		
		//mostrar el tablero inicialmente
		for (int i = 0; i < Tablero.length; i++) {
			for (int j = 0; j < Tablero[i].length; j++) {
				System.out.print(Tablero[i][j] + " ");
			}
			System.out.println();
		}
		
		//sistema de rondas
		for (int i = 0; i < posicTablero; i++) {
			int rondas = i + 1;
			System.out.println("Ronda " + rondas);
			
			
		}
		
	}

}
