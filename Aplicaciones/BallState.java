/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.ds.Aplicaciones;

/**
 *
 * @author sebastián
 */
public class BallState {

    public String state;
    public int movements;

    public BallState(String state, int movements) {
        this.movements = movements;
        this.state = state;

    }
     public BallState() {
        this.movements = 0;
    }
    @Override
    public String toString(){
       String s = "Game Over \n"
               + state + "\n"
               + "in  " + movements + "  movements";
       return s;
      }
}
