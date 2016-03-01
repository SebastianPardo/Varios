package co.edu.unal.ds.applications;
import co.edu.unal.ds.stack.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SwitchBox {
	public static boolean routable( int net[] ){
		Stack<Integer> stack = new DerivedArrayStack<>();
		for( int i = 0; i< net.length; i++ ){
			if( !stack.isEmpty() ){
				if( net[i] == stack.peek() )
					stack.pop();
				else stack.push( net[i] );
			}
			else stack.push( net[i] );
		}
		return stack.isEmpty();
	}
	
	public static void main (String [] args){
		Scanner sc = new Scanner( System.in );
		int n, net[];
		boolean flag;
		do{
			try{
				System.out.println("Enter the number of wires ");
				n = sc.nextInt();
				net = new int[ 2*n ];
				System.out.println("Enter the net: ");
				for( int i=0; i < 2*n; i++ )
					net[i] = sc.nextInt();
				System.out.printf("The net is %sroutable\n", routable( net ) ? "": "not ");
				flag = false;
			}
			catch( InputMismatchException ex ){
				flag = true;
				System.out.println("The input is wrong :) ");
				sc.skip(".*");
			}
		}while( flag );
	}

}
