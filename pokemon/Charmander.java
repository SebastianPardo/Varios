package co.edu.unal.ds.pokemon;

import java.io.Serializable;

public class Charmander extends Pokemon implements Fire, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Charmander(){
		super();
		namePokemon = "Charmander";	
	}
	
	public void attack(){
		System.out.println("Ember");
	}

	public void talk(){
		System.out.println("Char Char");
	}

	public void eat(){
		System.out.println("Char Char eating ......");
	}

	public void sleep(){
		System.out.println("Zzzz Char Char zzz");
	}
	public void flameThrower(){
		System.out.println("flame whoooshhhh whoooshh");
	}
}
