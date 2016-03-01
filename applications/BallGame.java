package co.edu.unal.ds.applications;

import co.edu.unal.ds.stack.*;
import java.util.Scanner;

public class BallGame {

    private static String initial;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the initial configuration of the game: ");
        initial = sc.next();
        //Convert the input string to lowercase to avoid errors if the user is annoying enough to use uppercase 'o's.
        initial = initial.toLowerCase();
        System.out.printf("The game is %ssolvable (recursive).\n", solveRecursive(initial.toCharArray()) ? "" : "not ");
        System.out.printf("The game is %ssolvable (iterative).\n", solveIterative(initial.toCharArray()) ? "" : "not ");

    }

    public static boolean solveRecursive(char[] game) {
        if (solved(game)) {
            return true;
        }
        System.out.println("game : " + game);
        boolean ans = false;
        for (int i = 0; i < game.length; i++) {
            //We only need to check positions with a ball, these are the position from where we can make an action.
            if (game[i] == 'o') {
                if (i > 1) {
					//If there is a ball at position i, and this position is greater than 1, we can make a movement to the left.
                    //( Given that the condition on the line below this one is true )
                    if (game[i - 1] == 'o' && game[i - 2] == '.') {
						// Make the movement to the left ( the ball in positions i and i-1 dissapear and the space at position
                        // i-2 is filled with this ball.
                        game[i - 2] = 'o';
                        game[i] = game[i - 1] = '.';
						// We only need to check if the game is solvable so if there is one path that leads us to solve it, the
                        // answer will be 'yes' ( true ). Remember that false OR true = true.
                        ans |= solveRecursive(game);
						//Return the game to its previous configuration to check all the other possibilities that can be used
                        //from here.
                        game[i - 2] = '.';
                        game[i] = game[i - 1] = 'o';
                    }
                }
                if (i < game.length - 2) {
                    if (game[i + 1] == 'o' && game[i + 2] == '.') {
                        game[i + 2] = 'o';
                        game[i] = game[i + 1] = '.';
                        ans |= solveRecursive(game);
                        game[i + 2] = '.';
                        game[i] = game[i + 1] = 'o';
                    }
                }
            }
        }
        return ans;
    }

    public static boolean solveIterative(char game[]) {
        Stack< String> st = new DerivedArrayStack<>();
        if (solved(game)) {
            return true;
        }
        st.push(new String(game));
        while (!st.isEmpty()) {
            String top = st.pop();
            game = top.toCharArray();
            if (solved(game)) {
                return true;
            }
            //Does this code look familiar?			
            for (int i = 0; i < game.length; i++) {
                if (game[i] == 'o') {
                    if (i > 1) {
                        if (game[i - 1] == 'o' && game[i - 2] == '.') {
                            game[i - 2] = 'o';
                            game[i] = game[i - 1] = '.';
                            //Add the generated state ( the next possibility ) to the stack.
                            st.push(new String(game));
                            //Return to the previous config to look at the other options that can be taken from here.	
                            game[i - 2] = '.';
                            game[i] = game[i - 1] = 'o';
                        }
                    }
                    if (i < game.length - 2) {
                        if (game[i + 1] == 'o' && game[i + 2] == '.') {
                            game[i + 2] = 'o';
                            game[i] = game[i + 1] = '.';
                            st.push(new String(game));
                            game[i + 2] = '.';
                            game[i] = game[i + 1] = 'o';
                        }
                    }
                }
            }
        }
        //We didn't find any path that lead us to solving the game.
        return false;
    }

    private static boolean solved(char[] game) {
		//Count the number of balls left. A game is considered solved
        //if there are less than two balls left.
        int c = 0;
        for (int i = 0; i < game.length; i++) {
            if (game[i] == 'o') {
                c++;
            }
        }
        return c <= 1;
    }
}
