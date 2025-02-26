
// Version 3 definitiva
import java.util.Scanner;

public class PacmanV3 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        char inputUsuario;
        boolean terminar = false;

        int[][] unaMatriz = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[] posicionPersonaje = { 7, 10 };
        int[] posicionFantasma = { 5, 10 };
        int[][] posicionInvencibilidad = { { 10, 1 }, { 10, 20 }, { 1, 1 }, { 1, 20 } };
        int puntos = 0;
        int turnosInvencible = 0;
        boolean invencible = false;

        do {
            System.out.println("PUNTOS: [" + puntos + "]");
            for (int laFila = 0; laFila < unaMatriz.length; laFila++) {
                for (int laColumna = 0; laColumna < unaMatriz[laFila].length; laColumna++) {
                    if (posicionPersonaje[0] == laFila && posicionPersonaje[1] == laColumna
                            && unaMatriz[laFila][laColumna] == 0) {
                        unaMatriz[laFila][laColumna] = 2;
                        puntos = puntos + 3;
                    }
                    if (laFila == posicionPersonaje[0] && laColumna == posicionPersonaje[1]) {
                        System.out.print("P");
                    } else if (laFila == posicionFantasma[0] && laColumna == posicionFantasma[1]) {
                        System.out.print("F");
                    } else if (laFila == posicionInvencibilidad[0][0] && laColumna == posicionInvencibilidad[0][1]) {
                        System.out.print("X");
                    } else if (laFila == posicionInvencibilidad[1][0] && laColumna == posicionInvencibilidad[1][1]) {
                        System.out.print("X");
                    } else if (laFila == posicionInvencibilidad[2][0] && laColumna == posicionInvencibilidad[2][1]) {
                        System.out.print("X");
                    } else if (laFila == posicionInvencibilidad[3][0] && laColumna == posicionInvencibilidad[3][1]) {
                        System.out.print("X");
                    } else {
                        if (unaMatriz[laFila][laColumna] == 0) {
                            System.out.print(".");
                        } else if (unaMatriz[laFila][laColumna] == 1) {
                            System.out.print("#");
                        } else if (unaMatriz[laFila][laColumna] == 2) {
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println();
            }
            if ((posicionPersonaje[0] == posicionInvencibilidad[0][0] && posicionPersonaje[1] == posicionInvencibilidad[0][1])
                    || (posicionPersonaje[0] == posicionInvencibilidad[1][0]
                            && posicionPersonaje[1] == posicionInvencibilidad[1][1])
                    || (posicionPersonaje[0] == posicionInvencibilidad[2][0]
                            && posicionPersonaje[1] == posicionInvencibilidad[2][1])
                    || (posicionPersonaje[0] == posicionInvencibilidad[3][0]
                            && posicionPersonaje[1] == posicionInvencibilidad[3][1])) {
                puntos = puntos + 3;
                invencible = true;
                turnosInvencible = turnosInvencible + 15;
            }
            if (turnosInvencible <= 0) {
                invencible = false;
            }
            if (invencible) {
                System.out.println("INVENCIBILIDAD: [" + turnosInvencible + "]");
                turnosInvencible = turnosInvencible - 1;
            }

            inputUsuario = entrada.nextLine().charAt(0);
            switch (inputUsuario) {
                case 's':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'S':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case '8':
                    posicionPersonaje[0] = posicionPersonaje[0] + 1;
                    break;
                case 'w':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case 'W':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case '2':
                    posicionPersonaje[0] = posicionPersonaje[0] - 1;
                    break;
                case 'a':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case 'A':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case '4':
                    posicionPersonaje[1] = posicionPersonaje[1] - 1;
                    break;
                case 'd':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'D':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case '6':
                    posicionPersonaje[1] = posicionPersonaje[1] + 1;
                    break;
                case 'f':
                    terminar = true;
                case 'F':
                    terminar = true;
            }
        } while (!terminar);
    }
}
