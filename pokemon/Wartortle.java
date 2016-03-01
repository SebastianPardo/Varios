package co.edu.unal.ds.pokemon;

import java.io.Serializable;

public class Wartortle extends Pokemon implements Water, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Wartortle(){
		super();
		namePokemon = "Wartortle";	
	}
	
	public void attack(){
		System.out.println("Bubblebeam");
	}

	public void talk(){
		System.out.println("Wart Wart");
	}

	public void eat(){
		System.out.println("Wart Wart eating .....");
	}

	public void sleep(){
		System.out.println("Zzzz Wart Wart zzz");
	}

	public void waterGun() {
		System.out.println("water whoooshhhh whoooshh");
	}

}
