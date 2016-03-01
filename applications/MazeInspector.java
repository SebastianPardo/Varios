package co.edu.unal.ds.applications;

import co.edu.unal.ds.queue.*;
import co.edu.unal.ds.stack.*;
import co.edu.unal.ds.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class MazeInspector {

    private static String field[][];
    private static int sizeH, sizeA;
    private static Position start;
    private static Position[] path;
    private static final int nbrs = 4;
    private static ArrayStack<Position> stack = new ArrayStack<>();
    private static int paredes = 0;
    
    public static void main(String[] args) {
        input();
        while (!stack.isEmpty()) {
            start = stack.pop();
            findPath();
        }
        System.out.println("se necesitan " + paredes + " litros de pintura");
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Altura: ");
        sizeH = sc.nextInt();
        System.out.println("Enter Ancho: ");
        sizeA = sc.nextInt();

        field = new String[sizeH + 2][sizeA + 2];

        System.out.println("Enter the Matrix: ");

        for (int i = 1; i <= sizeH; i++) {
            for (int j = 1; j <= sizeA; j++) {
                field[i][j] = sc.next();
            }
        }

        for (int i = 0; i < sizeH + 2; i++) {
            field[i][0] = field[i][sizeA + 1] = "0";
        }
        for (int i = 0; i < sizeA + 2; i++) {
            field[0][i] = field[sizeH + 1][i] = "0";
        }

        for (int i = 1; i <= sizeH; i++) {

            if (".".equals(field[i][1])) {
                stack.push(new Position(i, 1));
            } else {
                paredes++;
            }
            if (field[i][sizeA].equals(".")) {
                stack.push(new Position(i, sizeA));
            } else {
                paredes++;
            }
        }
        for (int i = 1; i <= sizeA; i++) {
            if (field[1][i].equals(".")) {
                stack.push(new Position(1, i));
            } else {
                paredes++;
            }
            if (field[sizeH][i].equals(".")) {
                stack.push(new Position(sizeH, i));
            } else {
                paredes++;
            }
        }

    }

    public static void findPath() {
        Stack<Position> s = new ArrayStack<>();
        Position here = new Position(start.row, start.col);
        if ("Y".equals(field[ here.row][ here.col])) {
            return;
        }
        field[ here.row][ here.col] = "Y";
        Position offset[] = new Position[4];
        offset[0] = new Position(0, 1);
        offset[1] = new Position(1, 0);
        offset[2] = new Position(0, -1);
        offset[3] = new Position(-1, 0);
        
        while (true) {
            System.out.println(start);
            for (int i = 1; i <= sizeH; i++) {
                for (int j = 1; j <= sizeA; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            for (int i = 0; i < nbrs; i++) {
                if (field[ here.row + offset[i].row][ here.col + 
                        offset[i].col].equals("#")) {
                    paredes++;
                }
                if (".".equals(field[ here.row + offset[i].row][ here.col 
                        + offset[i].col])) {
                    field[ here.row + offset[i].row][ here.col 
                            + offset[i].col] = "Y";  
                    s.push(new Position(here.row + offset[ i].row, here.col 
                            + offset[i].col));
                }
            }
            if (!s.isEmpty()) {
                here = s.pop();
            } else {
                return;
            }
        }
    }

}
