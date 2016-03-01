package co.edu.unal.ds.list;

import java.io.Serializable;
import java.util.*;


public class RandomIterationList <T extends Serializable  & Comparable< ? super T >> extends ArrayLinearListImproved<T>{
	
	
	public RandomIterationList( int initialCapacity ){
		super( initialCapacity );
	}

	public RandomIterationList( ){
		this( 10 );
	}
	
	@Override
	public Iterator<T> iterator(){
		return new RandomArrayLinearListIterator<T>( this );
	}
	
	@SuppressWarnings("hiding")
	class  RandomArrayLinearListIterator<T> extends ArrayLinearList<T>.ArrayLinearListIterator<T>{
		
		private HashSet<Integer> Index;
		
		public  RandomArrayLinearListIterator ( ArrayLinearList<T> list ){
			super(list);
			Index = new HashSet<Integer>();
		}

		@Override
		public boolean hasNext(){
			return Index.size() < list.size();		
		}
		
		public int getRandomIndex(){
			Random r = new Random();
			int randomIndex = r.nextInt(list.size);
			while(Index.contains(randomIndex))
				randomIndex = r.nextInt(list.size);
			Index.add(randomIndex);
			return randomIndex;
		}
		
		@Override
		public T next(){
			if( !hasNext() )
				throw new NoSuchElementException();
			T elem = list.element[getRandomIndex()];
			return elem;
		} 
	}

}
