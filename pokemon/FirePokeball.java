package co.edu.unal.ds.pokemon;

public class FirePokeball<P extends Pokemon & Fire> extends Pokeball<P>{

	public FirePokeball(P pokemon){
		super(pokemon);
	}

	public void rapidFlameThrower(){
		getPokemon().flameThrower();
	}

}
