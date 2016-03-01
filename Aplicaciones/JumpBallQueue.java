/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.Aplicaciones;

import co.edu.unal.ds.queue.*;
import java.util.Scanner;

/**
 *
 * @author sebastián
 */
public class JumpBallQueue {

    private static BallState finalState = new BallState();
    private static int movements = 0;
    private static ArrayQueue<BallState> queue = new ArrayQueue<>();
    private static final String movLeft = "o..";
    private static final String movRigth = "..o";
    
    public static String intro() {
        // String titulo = "SALTA LA BOLITA /c";
        String instrucciones = "Este programa lo que hace es resover el juego SALTA LA BOLITA \n"
                + "recuerda que : \n"
                + "1. las bolas se representan con la letra 'o' \n"
                + "2. los espacios vacios con el caracter '.' \n"
                + "3. Cualquier otro caracter fuera de estos sera invalido\n";
        
        return /*titulo + */ instrucciones;
        
    }
    
    public static boolean validateGame(String juego) {
        String mensaje = "Caracter Invalido!!! \n"
                + "el Siguiente caracter no es valido : ";
        
        for (int i = 0; i < juego.length(); i++) {
            char verificar = juego.charAt(i);
            if (verificar != 'o' && verificar != '.') {
                System.out.println(mensaje + verificar + "\n"
                        + "Introduzca nuevamente el juego");
                return false;
            }
        }
        return true;
    }
    
    public static void searchBols(String element) {
        movements++;
        String aux;
        for (int i = 0; i < element.length(); i++) {
            
            if (i + 1 < element.length()) {
                
                if (element.charAt(i) == 'o' && element.charAt(i + 1) == 'o') {
                    if (i + 2 < element.length()) {
                        
                        if (element.charAt(i + 2) == '.') {
                            if ((i + 3) < element.length()) {
                                if (i - 1 > -1) {
                                    aux = element.substring(0, i) + movRigth + element.substring(i + 3);
                                                                } else {
                                    aux = movRigth + element.substring(i + 3);
                                }
                            } else {
                                if (i - 1 > -1) {
                                    
                                    aux = element.substring(0, i) + movRigth;
                                } else {
                                    aux = movRigth;
                                }
                            }
                            queue.put(new BallState(aux, movements));
                        }
                    }
                    if (i - 1 >= 0) {
                        if (element.charAt(i - 1) == '.') {
                            if (i + 2 < element.length()) {
                                if (i - 2 >= 0) {
                                    aux = element.substring(0, i - 1) + movLeft + element.substring(i + 2);
                                } else {
                                    aux = movRigth + element.substring(i + 2);
                                }
                            } else {
                                if (i - 1 >= 0) {
                                    aux = element.substring(0, i - 1) + movLeft;
                                } else {
                                    aux = movRigth;
                                }
                                
                            }
                            
                            queue.put(new BallState(aux, movements));
                        }
                        
                    }
                }
            }
        }
    }
    
    public static boolean gameOver(String element) {
        int aux = 0;
        for (int i = 0; i < element.length(); i++) {
            if (element.charAt(i) == 'o') {
                aux++;
            }
        }
        return aux == 1;
    }
    
    public static void Start() {
        
        Scanner sc = new Scanner(System.in);
        String game = sc.next();
        boolean flag = false;
        while (validateGame(game) == false) {
            game = sc.next();
        }
        queue.put(new BallState(game, movements));
        while (!queue.isEmpty()) {
            BallState aux = queue.remove();
            game = aux.state;
            movements = aux.movements;
            searchBols(game);
            if (gameOver(game) == true) {
                if (flag == false) {
                    finalState = aux;
                    flag = true;
                } else {
                    if (movements < finalState.movements) {
                        finalState = aux;
                    }
                }
            }
        }
        if (flag == false) {
            System.out.println("el juego no tiene solucion");
        } else {
            System.out.println(finalState);
        }
    }
    
    public static void main(String[] arg) {
        System.out.println(intro());
        Start();
    }
    
}
