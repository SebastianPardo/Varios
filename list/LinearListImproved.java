package co.edu.unal.ds.list;

import java.util.*;

public interface LinearListImproved<T> extends LinearList<T>{
	public void save( String fn );
	public void load( String fn );
	public void sort( );
	public void sort( Comparator<T> c );
}
