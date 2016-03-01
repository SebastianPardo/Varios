package co.edu.unal.ds.applications;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import co.edu.unal.ds.util.*;
import co.edu.unal.ds.queue.*;

public class LabyrinthPainter {
	private static char[][] field;
	private static int paint, col, row;

	public static void main(String[] args) {
		input();
		printLab();
		walk();
		System.out.printf("\nSe necesitan %d litros de pintura", paint);
	}

	private static void printLab() {
		System.out.println("\nEl laberinto ingresado es:\n");
		for (int i = 2; i <= row + 1; i++) {
			for (int j = 2; j <= col + 1; j++) {
				System.out.printf("%c ", field[i][j]);
			}
			System.out.println();
		}

	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean flag;

		System.out.println("ingrese las dimensiones del laberinto");
		do {
			try {
				col = sc.nextInt();
				row = sc.nextInt();
				flag = false;
			} catch (InputMismatchException e) {
				flag = true;
				System.out
						.println("Dimensiones incorrectas, ingreselas nuevamente.");
				sc.skip(".*");
			}
		} while (flag);
		field = new char[row + 4][];
		System.out.println("Ingrese el laberinto");
		do {
			for (int i = 2; i < row + 2; i++) {
				field[i] = sb.append("*.").append(sc.next()).append(".*")
						.toString().toCharArray();
				sb.setLength(0);
			}
		} while (!checkLab());

		field[0] = field[row + 3] = new char[col + 4];
		field[1] = new char[col + 4];
		field[row + 2] = new char[col + 4];
		Arrays.fill(field[0], '*');
		Arrays.fill(field[1], 1, col + 4, '.');
		Arrays.fill(field[row + 2], 1, col + 4, '.');
		field[1][0] = field[1][col + 3] = field[row + 2][0] = field[row + 2][col + 3] = '*';
		sc.close();
	}

	private static boolean checkLab() {
		for (int i = 2; i <= row + 1; i++) {
			// check row's length
			if (field[i].length != col + 4) {
				System.out
						.println("El tamaño de alguna(s) filas es incorrecto, ingrese el laberinto nuevamente");
				return false;
			}
			// check characters
			for (int j = 2; j <= col + 1; j++) {
				if (field[i][j] != '.' && field[i][j] != '#') {
					System.out
							.println("El laberinto contiene elementos desconocidos, ingreselo nuevamente");
					return false;
				}
			}
		}
		return true;
	}

	private static void walk() {
		Queue<Position> q = new ArrayQueue<>();
		Position here = new Position(1, 1);
		final int nbrs = 4;
		Position offset[] = new Position[nbrs];
		offset[0] = new Position(0, 1);
		offset[1] = new Position(1, 0);
		offset[2] = new Position(0, -1);
		offset[3] = new Position(-1, 0);
		paint = 0;
		field[1][1] = '*';
		while (here != null) {
			for (int i = 0; i < nbrs; i++) {
				if (field[here.row + offset[i].row][here.col + offset[i].col] == '.') {
					field[here.row + offset[i].row][here.col + offset[i].col] = '*';
					q.put(new Position(here.row + offset[i].row, here.col
							+ offset[i].col));
				} else if (field[here.row + offset[i].row][here.col
						+ offset[i].col] == '#') {
					paint++;
				}
			}
			here = q.remove();
		}
	}

}