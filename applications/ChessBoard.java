package co.edu.unal.ds.applications;

import co.edu.unal.ds.util.Position;
import co.edu.unal.ds.stack.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ChessBoard {

    private static int[][] board;
    private static List< Position> pawns;
    private static boolean done = false;
    private static Position[] neighbors;
    private static int nbrs = 8;
    private static Position start, end;

    static {
        neighbors = new Position[8];
        neighbors[ 0] = new Position(-2, -1);
        neighbors[ 1] = new Position(-2, 1);
        neighbors[ 2] = new Position(-1, 2);
        neighbors[ 3] = new Position(1, 2);
        neighbors[ 4] = new Position(2, 1);
        neighbors[ 5] = new Position(2, -1);
        neighbors[ 6] = new Position(1, -2);
        neighbors[ 7] = new Position(-1, -2);

    }

    private static void dfs(int r, int c, int np, int step) {
        if (!ok(r, c)) {
            return;
        }
        board[r][c] = step;
        if (np == 1 && hasPawn(r, c)) {
            done = true;
            end = new Position(r, c);
            return;
        }
        for (int i = 0; !done && i < nbrs; i++) {
            dfs(r + neighbors[i].row, c + neighbors[i].col, hasPawn(r, c) ? np - 1 : np, step + 1);
        }
    }

    private static void outputPath() {
        Stack< Position> stack = new DerivedArrayStack<>();
        Position here = new Position(end.row, end.col);
        while (!here.equals(start)) {
            stack.push(new Position(here.row, here.col));
            for (int i = 0; i < nbrs; i++) {
                int nr = neighbors[i].row + here.row;
                int nc = neighbors[i].col + here.col;
                if (nr >= 0 && nr <= 7 && nc <= 7 && nc >= 0 && board[nr][nc] == board[here.row][here.col] - 1) {
                    here.row = nr;
                    here.col = nc;
                    break;
                }
            }
        }
        System.out.println(start);
        while (!stack.isEmpty()) {
            here = stack.pop();
            System.out.println(here);
        }
    }

    private static boolean hasPawn(int r, int c) {
        return pawns.contains(new Position(r, c));
    }

    private static boolean ok(int r, int c) {
        return r >= 0 && c >= 0 && r < 8 && c < 8 && board[r][c] == 0 && !done;
    }

    public static void main(String[] args) {
        int npawns;
        board = new int[8][8];
        pawns = new ArrayList< Position>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of pawns: ");
        npawns = sc.nextInt();
        System.out.println("Enter the start position: ");
        start = new Position(sc.nextInt(), sc.nextInt());
        System.out.println("Enter the positions for each pawn( 0-indexed ): ");
        for (int i = 0; i < npawns; i++) {
            pawns.add(new Position(sc.nextInt(), sc.nextInt()));
        }

        dfs(start.row, start.col, npawns, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%3s", board[i][j]);
            }
            System.out.println();
        }
        System.out.println("Path: ");

        outputPath();
    }

}
