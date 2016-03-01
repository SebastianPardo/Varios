package co.edu.unal.ds.main;
import java.util.Comparator;
import co.edu.unal.ds.pokemon.*;
import co.edu.unal.ds.list.*;

public class Driver{
	
	public static PokemonComparator DESC = new PokemonComparator();
	
	public static void main(String args[]){
		LinearListImproved<Pokemon> list = new ArrayLinearListImproved<>();
		list.load( "poke_list.poke" );
		System.out.println(list);
		list.remove( list.size() - 1 );
		System.out.println(list);
		list.save( "poke_list.poke" );
		LinearListImproved<Pokemon> list2 = new ArrayLinearListImproved<>();
		list2.load( "poke_list.poke" );
		System.out.println(list2);

		for( int i=0; i<5; i++ ){
			Pokemon p = new Charmander();
			list.add(i, p);
		}
		System.out.println(list);
		System.out.println("Ordering...");
		list.sort();
		System.out.println(list);
		System.out.println("Descending order...");
		list.sort( DESC );
		System.out.println(list);
		list.save( "poke_list.poke" );
	}
	static class PokemonComparator implements Comparator<Pokemon>{
		
		public int compare( Pokemon a, Pokemon b){
			return -1 * ( a.getLevel() - b.getLevel() );
		}
	}
}
