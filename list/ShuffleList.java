package co.edu.unal.ds.list;

import java.io.Serializable;
import java.util.Random;

public class ShuffleList<T extends Serializable  & Comparable< ? super T >> extends ArrayLinearListImproved<T>{
	
	public ShuffleList( int initialCapacity ){
		super( initialCapacity );
	}

	public ShuffleList( ){
		this( 10 );
	}
	
	public int[] randomGenerator(int initialCapacity){
		int counter = 0; 
		int randomNumber = 0; 
		int aux = 0; 
		int[] skipRandomArrays = new int[initialCapacity];
		Random r = new Random(); 
		do { 
			randomNumber = r.nextInt(initialCapacity); 
			for(int i = 0; i< counter; i++){ 
				if(randomNumber == skipRandomArrays[i]) 
					aux = 1; 
			} 
			if(aux == 0){ 
				skipRandomArrays[counter] = randomNumber; 
				counter++; 
			} 
			aux = 0; 
		} while(counter < initialCapacity); 
		return skipRandomArrays;
	}


	public void toShuffle(){
		ArrayLinearListImproved<T> tmp = this;
		int tmpTamano = tmp.size; 
		int[] a =randomGenerator(tmpTamano);
		for (int i = 0; i < tmpTamano; i++) {
			this.add(i, tmp.get(a[i]+i));
		}
		for (int i = tmp.size-1; i >= tmpTamano; i--) {
			this.remove(i);
		}
	}

}
