package co.edu.unal.ds.chain; 

public class ChainNode<T> {

	public T element;
	public ChainNode<T> next; 

	public ChainNode( T element ){
		this( element , null );
	}

	public ChainNode( ){
		this( null, null );
	}
	public ChainNode( T element, ChainNode<T> next ){
		this.element = element;
		this.next = next;
	}

}
