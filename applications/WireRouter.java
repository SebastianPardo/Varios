package co.edu.unal.ds.applications;
import  co.edu.unal.ds.queue.*;
import  co.edu.unal.ds.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class WireRouter {
	private static int field[][];
	private static int size;
	private static Position start, finish;
	private static Position[] path;
	private static final int nbrs = 4;
	public static void main (String [] args){
		input();
		if( findPath() ){
			outputPath();
			prettyPrint();
		}
	}

	public static void input(){
		Scanner sc = new Scanner( System.in );
		System.out.println("Enter size: ");
		size = sc.nextInt();
		field = new int[ size + 2 ][ size + 2 ];
		System.out.println("Enter start position: ");
		start = new Position( sc.nextInt(), sc.nextInt() );
		System.out.println("Enter finish position: ");
		finish = new Position( sc.nextInt(), sc.nextInt() );
		
		System.out.println("Enter the Matrix: ");
		
		for( int i=1; i <= size; i++ )
			for( int j=1; j <= size; j++ )
				field[i][j] = sc.nextInt();
		for( int i=0; i < size + 2; i++ )
			field[i][0] = field[i][size+1] = field[0][i] = field[size+1][i] = 1;
	
	}
	public static boolean findPath(){
		Queue<Position> queue = new ArrayQueue<>();
		Position here = new Position( start.row, start.col );
		field[ here.row ][ here.col ] = 2;
		Position offset[] = new Position[4];
		offset[0] = new Position( 0, 1 ); 
		offset[1] = new Position( 1, 0 ); 
		offset[2] = new Position( 0, -1 ); 
		offset[3] = new Position( -1, 0 ); 
		pedro:while( true ){
			for( int i=0; i < nbrs; i++ ){
				if( field[ here.row + offset[i].row ][ here.col + offset[i].col ] == 0 ){
					field[ here.row + offset[i].row ][ here.col + offset[i].col ] = field[ here.row ][ here.col ] + 1; //please 
					if( here.row + offset[i].row == finish.row  && here.col + offset[ i ].col == finish.col ){
						here = finish;
						break pedro;
					}
					queue.put( new Position( here.row + offset[ i ].row, here.col + offset[i].col ) );
				}
			}
			here = queue.remove();
			if( here == null )
				return false;
		}

		int pathLength = field[ here.row ][ here.col ] - 2;
		path = new Position[ pathLength ];
		for( int j = pathLength - 1; j >= 0; j-- ){
			path[ j ] = here;
			for( int i = 0; i < nbrs; i++ ){
				if( field[ here.row + offset[ i ].row ][ here.col + offset[i].col ] == j + 2 ){
					here = new Position( here.row + offset[ i ].row, here.col + offset[i].col );
					break;
				}
			}
		}
		return true;
	}
	public static void outputPath(){
		System.out.printf("The path from %s to %s is: \n", start, finish);
		for( Position p : path )
			System.out.println(p);
	}

	public static void prettyPrint(){
		List< Position > list = Arrays.asList( path );
		for( int i = 0; i <= size+1; i++ ){
			for( int j = 0; j <= size+1; j++ ){
				if( field[i][j] == 1 )
					System.out.print("#");
				else if( field[i][j] == 2 )
					System.out.print("S");
				else if ( i == finish.row && j == finish.col )
					System.out.print("F");
				else if (list.contains( new Position( i, j ) ) )
					System.out.print("*");
				else 
					System.out.print(".");
			}
			System.out.println();
		}
	}
	
}

