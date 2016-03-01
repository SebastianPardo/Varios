package co.edu.unal.ds.pokemon;

import java.io.Serializable;
import java.util.Random;

public abstract class Pokemon implements Pet, Comparable<Pokemon>, Serializable{

	private static final long serialVersionUID = 1L;
	protected int level;
	protected int pokeId;
	protected String namePokemon;
	private static Random generator = new Random(1000);
	private static Integer idGenerator = 0;
	
	public Pokemon( int level ){
		this.level = level;
		this.pokeId = idGenerator++;
	}

	public Pokemon( ){
		level = generator.nextInt(10) + 1;
		this.pokeId = idGenerator++;
	}

	public int getLevel(){
            return level;
	}

        public String getPokeName(){
            return namePokemon;
        }
        
	public abstract void attack();

	public abstract void talk();

	@Override
	public int compareTo( Pokemon p ){
		return this.pokeId - p.pokeId;
	}

	@Override
	public String toString(){
		return String.format("%s [Lv:%d Id:%d]" , namePokemon , level , pokeId);
	}
	
	@Override
	public boolean equals(Object o){
		if ( o == null )
			return false;
		if ( !( o instanceof Pokemon) )
			return false;
		return this.pokeId == ((Pokemon)o).pokeId; 
	}	

	@Override
	public int hashCode(){
		return pokeId;
	}
} 
