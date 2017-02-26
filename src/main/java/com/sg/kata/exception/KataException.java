/**
 * 
 */
package com.sg.kata.exception;

/**
 * Define a new {@link Exception} type for KATA Application.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class KataException extends Exception
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public KataException()
	{
		super();
	}

	/**
	 * 
	 * @param message
	 */
	public KataException(final String message)
	{
		super(message);
	}

	/**
	 * 
	 * @param {@link
	 * 			 Throwable}
	 */
	public KataException(final Throwable throwable)
	{
		super(throwable);
	}

}
