import java.util.Random;

public class Dado {
    private int caras;
    private int ultimaCara;

    public Dado() {
        caras = 6;
        ultimaCara = 1;
    }

    public Dado(int caras) {
        this.caras = caras;
        ultimaCara = 1;
    }

    public int getCaras() {
        return caras;
    }

    public int getUltimaCara() {
        return ultimaCara;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public int tirar() {
        Random random = new Random();
        ultimaCara = random.nextInt(caras) + 1;
        return ultimaCara;
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Dado dado6 = new Dado();
        Dado dado10 = new Dado(10);
        Dado dado12 = new Dado(12);
        int suma = 0;

        while (suma < 20) {
            int tirada1 = dado6.tirar();
            int tirada2 = dado10.tirar();
            int tirada3 = dado12.tirar();
            suma = tirada1 + tirada2 + tirada3;

            System.out.println("Tiradas: " + tirada1 + ", " + tirada2 + ", " + tirada3);
            System.out.println("Suma: " + suma);
        }

        System.out.println("La suma es mayor o igual a 20. El juego ha terminado.");
    }
}