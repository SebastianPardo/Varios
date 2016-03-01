package co.edu.unal.ds.aplicaciones;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import co.edu.unal.ds.queue.*;
import co.edu.unal.ds.util.*;

public class PabloRemalas {

    private static char[][] field;
    private static int stepts = 0, col, row;

    public static void main(String[] args) {
        input();
        printLab();
        if (findExit()) {
            System.out.printf("\nPablo puede salir en %d pasos", stepts);
        } else {
            System.out.println("IMPOSIBLE");
        }
    }

    private static void input() {
        boolean flag;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Ingrese las dimensiones del laberinto");
        do {
            try {
                row = sc.nextInt();
                col = sc.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                flag = true;
                System.out
                        .println("Dimensiones incorrectas, ingreselas nuevamente.");
                sc.skip(".*");
            }
        } while (flag);
        field = new char[row + 2][];
        System.out.println("Ingrese el Laberinto");
        do {
            for (int i = 1; i <= row; i++) {
                field[i] = sb.append('*').append(sc.next().toUpperCase())
                        .append('*').toString().toCharArray();
                sb.setLength(0);
            }
        } while (!checkLab());
        field[0] = field[row + 1] = new char[col + 2];
        Arrays.fill(field[0], '*');
        sc.close();
    }

    private static boolean checkLab() {
        char[] allowed = "PF#.".toCharArray();
        boolean flag;
        int pablos = 0;
        for (int i = 1; i <= row; i++) {
            // check row's length
            if (field[i].length != col + 2) {
                System.out
                        .println("El tama�o de alguna(s) filas es incorrecto, ingrese el laberinto nuevamente");
                return false;
            }
            for (int j = 1; j <= col; j++) {
                flag = false;
                for (int k = 0; k < allowed.length; k++) {
                    // check characters
                    if (field[i][j] == allowed[k]) {
                        flag = true;
                        if (field[i][j] == 'P') {
                            pablos++;
                        }
                        break;
                    }
                }
                if (!flag) {
                    System.out
                            .println("El laberinto contiene elementos desconocidos, ingreselo nuevamente");
                    return false;
                }

            }
        }
        // check if Pablo is in the labyrinth
        if (pablos < 1) {
            System.out
                    .println("Pablo no se encuenta en el laberinto, ingreselo nuevamente");
            return false;
        } else if (pablos > 1) {
            System.out
                    .println("Pablo est� en mas de una ubicaci�n en el laberinto, ingreselo nevamente");
            return false;
        }

        return true;
    }

    private static void printLab() {
        System.out.println("El laberinto ingresado es\n");
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.printf("%c ", field[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean findExit() {
        final int nbrs = 4;
        Queue<Position> fireActual;
        Queue<Position> fireNext;
        Queue<Position> pabloActual;
        Queue<Position> pabloNext;
        Position offset[], actualPosition;
        offset = new Position[nbrs];
        offset[0] = new Position(0, 1);
        offset[1] = new Position(1, 0);
        offset[2] = new Position(0, -1);
        offset[3] = new Position(-1, 0);
        fireActual = searchChar('F');
        pabloActual = searchChar('P');
        while (!pabloActual.isEmpty()) {
            stepts++;
            // fire Expands
            fireNext = new ArrayQueue<Position>();
            while (!fireActual.isEmpty()) {
                actualPosition = fireActual.remove();
                for (int i = 0; i < nbrs; i++) {
                    if (getElement(actualPosition, offset[i]) == '.'
                            || getElement(actualPosition, offset[i]) == 'P') {
                        fireNext.put(sumPosition(actualPosition, offset[i]));
                        field[fireNext.getRearElement().row][fireNext
                                .getRearElement().col] = 'F';
                    }
                }
            }
            // move Pablo
            pabloNext = new ArrayQueue<Position>();
            while (!pabloActual.isEmpty()) {
                actualPosition = pabloActual.remove();
                for (int i = 0; i < nbrs; i++) {
                    if (getElement(actualPosition, offset[i]) == '*') {
                        return true;
                    } else if (getElement(actualPosition, offset[i]) == '.') {
                        pabloNext.put(sumPosition(actualPosition, offset[i]));
                        field[pabloNext.getRearElement().row][pabloNext
                                .getRearElement().col] = 'P';
                    }
                }
            }
            pabloActual = pabloNext;
            fireActual = fireNext;
        }
        return false;
    }

    private static Position sumPosition(Position a, Position b) {
        return new Position(a.row + b.row, a.col + b.col);
    }

    private static char getElement(Position a, Position b) {
        return field[a.row + b.row][a.col + b.col];
    }

    private static ArrayQueue<Position> searchChar(char c) {
        ArrayQueue<Position> q = new ArrayQueue<Position>();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (field[i][j] == c) {
                    q.put(new Position(i, j));
                }
            }
        }
        return q;
    }

}
