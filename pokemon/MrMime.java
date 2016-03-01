package co.edu.unal.ds.pokemon;

import java.io.Serializable;

public class MrMime extends Pokemon implements Psychic, Serializable{

	private static final long serialVersionUID = 1L;

	public MrMime(){
		super();
		namePokemon = "MrMime";	
	}
	
	public void attack(){
		System.out.println("Confusion");
	}

	public void talk(){
		System.out.println("Mr mime mime");
	}

	public void eat(){
		System.out.println("Mr mime mime eating ......");
	}

	public void sleep(){
		System.out.println("Zzzz Mr mime mime zzz");
	}
	public void psybeam(){
		System.out.println("Psybeam whoooshh");
	}
}
