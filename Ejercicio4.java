import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Cuadricula {

    private final int TAM_TABLERO = 10;
    private final char AGUA = '-';
    private final char BARCO = 'B';
    private final char TOCADO = 'X';

    private char[][] tablero;

    public Cuadricula() {
        this.tablero = new char[TAM_TABLERO][TAM_TABLERO];
        for (int i = 0; i < TAM_TABLERO; i++) {
            Arrays.fill(tablero[i], AGUA);
        }
    }

    public void depositarBarco(int fila, int columna) {
        tablero[fila][columna] = BARCO;
    }

    public boolean disparar(int fila, int columna) {
        if (tablero[fila][columna] == BARCO) {
            tablero[fila][columna] = TOCADO;
            return true;
        } else {
            return false;
        }
    }

    public void visualizacion() {
        System.out.print("  ");
        for (int i = 0; i < TAM_TABLERO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < TAM_TABLERO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAM_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}


public class Ejercicio3 {
    private Cuadricula cuadriculaJugador;
    private Cuadricula cuadriculaComputadora;
    private Scanner scanner;

    public Ejercicio5() {
        cuadriculaJugador = new Cuadricula();
        cuadriculaComputadora = new Cuadricula();
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.println("Posicione su barco:");
        cuadriculaJugador.depositarBarco(leerCoordenadas());

        System.out.println("La computadora está posicionando su barco...");
        cuadriculaComputadora.depositarBarcoAleatorio();

        while (!cuadriculaJugador.estaHundido() && !cuadriculaComputadora.estaHundido()) {
            System.out.println("Turno del jugador humano:");
            turnoJugadorHumano();

            if (cuadriculaComputadora.estaHundido()) {
                break;
            }

            System.out.println("Turno de la computadora:");
            turnoComputadora();

            if (cuadriculaJugador.estaHundido()) {
                break;
            }
        }

        finalizarJuego();
    }

    private Coordenadas leerCoordenadas() {
        System.out.println("Ingrese las coordenadas (fila, columna):");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();
        return new Coordenadas(fila, columna);
    }

    private void turnoJugadorHumano() {
        Coordenadas coordenadas = leerCoordenadas();
        boolean acierto = cuadriculaComputadora.disparar(coordenadas);

        if (acierto) {
            System.out.println("Tocado");
            
            if (cuadriculaComputadora.estaHundido()) {
                System.out.println("Hundido");
            }
        } else {
            System.out.println("Agua");
        }
    
        System.out.println("Tablero de la computadora:");
        cuadriculaComputadora.visualizacion();
    }
    
    private void turnoComputadora() {
        Coordenadas coordenadas = cuadriculaJugador.generarCoordenadasAleatorias();
        boolean acierto = cuadriculaJugador.disparar(coordenadas);
    
        if (acierto) {
            System.out.println("Tocado");
    
            if (cuadriculaJugador.estaHundido()) {
                System.out.println("Hundido");
            }
        } else {
            System.out.println("Agua");
        }
    
        System.out.println("Tablero del jugador humano:");
        cuadriculaJugador.visualizacion();
    }
    
    private void finalizarJuego() {
        if (cuadriculaJugador.estaHundido()) {
            System.out.println("¡La computadora gana!");
        } else {
            System.out.println("¡El jugador humano gana!");
        }
    
        System.out.println("Tablero final:");
        cuadriculaJugador.visualizacion();
        cuadriculaComputadora.visualizacion();
    }
}