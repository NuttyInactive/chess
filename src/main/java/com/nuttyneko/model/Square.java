package com.nuttyneko.model;

/**
 * A representation of a position of a Square on a Chess board.
 */
public class Square
{
	/**
	 * The rank (or row) of this <code>Square</code>.
	 * The numbering starts at 0.
	 */
	public int rank;
	
	/**
	 * The file (or column) of this <code>Square</code>.
	 * The numbering starts at 0.
	 */
	public int file;
	
	/**
	 * Constructs and initializes a square with the same location as the
	 * specified <code>Square</code> object.
	 * 
	 * @param square {@link Square}
	 */
	public Square(Square square)
	{
		this(square.file, square.rank);
	}
	
	/**
	 * Constructs and initializes a square position at the specified
	 * {@code (rank, file)} location.
	 * 
	 * @param rank value ranging from {@code 0} to the {@code (board width - 1)}
	 * @param file value ranging from {@code 0} to the {@code (board height - 1)}
	 */
	public Square(int rank, int file)
	{
		this.rank = rank;
		this.file = file;
	}
	
	/**
	 * Constructs and initializes a square position at the specified
	 * location given the name of the square (a1 to h8).
	 * 
	 * @param name String representation of the square.
	 */
	public Square(String name) throws IllegalArgumentException
	{
		final int BASIC_ASCII_SET = 127;
		
		if (name.length() != 2)
			throw new IllegalArgumentException("Invalid string length: " + name.length() + "!= 2");
		
		if (!Character.isLetter(name.charAt(0)) || name.charAt(0) > BASIC_ASCII_SET)
			throw new IllegalArgumentException("First character is not a letter: " + name.charAt(0));
		
		if (!Character.isDigit(name.charAt(1)))
			throw new IllegalArgumentException("Second character is not a digit: " + name.charAt(1));
		
		rank = name.toLowerCase().charAt(0) - 'a';
		file = name.toLowerCase().charAt(1) - '0' - 1;
	}
	
	/**
	 * Determines whether or not two squares are equal.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Square other = (Square) obj;
		return (this.rank == other.rank && this.file == other.file);
	}
}
