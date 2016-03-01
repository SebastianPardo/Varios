package co.edu.unal.ds.list;

public interface LinearList<T>{
	public boolean isEmpty();
	public int size();
	public T get(int index);
	public int indexOf(T elem);
	public T remove(int index);
	public void add(int index, T elem);
	
}
