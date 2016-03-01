package co.edu.unal.ds.list;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SkipOddArrayLinearList <T extends Serializable  & Comparable< ? super T >> extends ArrayLinearListImproved<T>{
	
	public SkipOddArrayLinearList( int initialCapacity ){
		super( initialCapacity );
	}

	public SkipOddArrayLinearList( ){
		this( 10 );
	}
	
	@Override
	public Iterator<T> iterator(){
		return new SkipOddArrayLinearListIterator<T>( this );
	}

	@SuppressWarnings("hiding")
	class  SkipOddArrayLinearListIterator<T> extends ArrayLinearList<T>.ArrayLinearListIterator<T>{
		
		public  SkipOddArrayLinearListIterator ( ArrayLinearList<T> list ){
			super(list);
                        setNextIndex(0);
		}

		@Override
		public T next(){
			if( !hasNext() )
				throw new NoSuchElementException();
			T elem = list.element[nextIndex];
			nextIndex+=2;
			return elem;
		}
		
	}
}
