package co.edu.unal.ds.pokemon;

import java.io.Serializable;

public class Flareon extends Pokemon implements Fire, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Flareon(){
		super();
		namePokemon = "Flareon";	
	}
	
	public void attack(){
		System.out.println("Ember");
	}

	public void talk(){
		System.out.println("Flare Flare");
	}

	public void eat(){
		System.out.println("Flare Flare eating .......");
	}

	public void sleep(){
		System.out.println("Zzzz Flare Flare zzz");
	}
	public void flameThrower(){
		System.out.println("flame whoooshhhh whoooshh");
	}

}
