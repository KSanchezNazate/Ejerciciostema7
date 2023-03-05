import java.util.Arrays;
import java.util.Scanner;

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

    public static void main(String[] args) {
        Cuadricula cuadricula = new Cuadricula();
        Scanner scanner = new Scanner(System.in);
        boolean barcoColocado = false;
        int filaBarco = 0;
        int columnaBarco = 0;

        while (true) {
            cuadricula.visualizacion();
            System.out.print("Introduce la fila de disparo (0-9): ");
            int filaDisparo = scanner.nextInt();
            System.out.print("Introduce la columna de disparo (0-9): ");
            int columnaDisparo = scanner.nextInt();
            boolean acierto = cuadricula.disparar(filaDisparo, columnaDisparo);
            if (acierto) {
                System.out.println("¡Has acertado!");
            } else {
                System.out.println("Has fallado");
            }
            if (barcoColocado && cuadricula.disparar(filaBarco, columnaBarco)) {
                System.out.println("¡Has hundido el barco!");
                break;
            }
            if (!barcoColocado) {
                System.out.print("Introduce la fila donde quieres depositar el barco (0-9): ");
                filaBarco = scanner.nextInt();
                System.out.print("Introduce la columna donde quieres depositar el barco (0-9): ");
                columnaBarco = scanner.nextInt();
                cuadricula.depositarBarco(filaBarco, columnaBarco);
                barcoColocado = true;
            }
        }
    }
}