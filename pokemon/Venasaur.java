package co.edu.unal.ds.pokemon;

import java.io.Serializable;

public class Venasaur extends Pokemon implements Grass, Serializable{

	private static final long serialVersionUID = 1L;

	public Venasaur(){
		super();
		namePokemon = "Venasaur";	
	}
	
	public void attack(){
		System.out.println("Razor Leaf");
	}

	public void talk(){
		System.out.println("Vina Vina");
	}

	public void eat(){
		System.out.println("Vina Vina eating.....");
	}

	public void sleep(){
		System.out.println("Zzzz Vina Vina zzz");
	}

	public void solarBeam(){
		System.out.println("Solar Beam Washhhh");
	}

}
