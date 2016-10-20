package com.nuttyneko.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest
{
	@Test
	public void testConstructor_convertString()
	{
		Square square = null;
		
		square = new Square("A1");
		assertTrue(square.rank == 0 && square.file == 0);
		
		square = new Square("d4");
		assertTrue(square.rank == 3 && square.file == 3);
		
		square = new Square("H8");
		assertTrue(square.rank == 7 && square.file == 7);
		
		/*
		 * Some variants of Chess (i.e. Gothic Chess) may have more
		 * than 8 ranks and files.
		 */
		square = new Square("i2");
		assertTrue(square.rank == 8 && square.file == 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_invalidArgument_1()
	{
        new Square("");
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_invalidArgument_2()
	{
        new Square("3d");
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_invalidArgument_3()
	{
        new Square("â1");
    }
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor_invalidArgument_4()
	{
        new Square("hH");
    }
	
	@Test
	public void testEquals()
	{
		Square squareOne = new Square(0, 0);
		Square squareTwo = new Square(1, 1);
		Square squareThree = new Square(squareTwo);
		
		assertTrue(squareOne.equals(squareOne));
		assertTrue(squareTwo.equals(squareThree));
		assertFalse(squareOne.equals(squareTwo));
		assertFalse(squareOne.equals(null));
	}
}
