package co.edu.unal.ds.util;

public class Position{
	public int row, col;
	public Position( int row, int col ){
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals( Object other ){
		if( !(other instanceof Position ) )
			return false;
		Position pos = (Position) other;
		return this.row == pos.row && this.col == pos.col;
	}

	@Override
	public String toString() {
		return String.format( "{ %d %d }", row, col );
	}
}
