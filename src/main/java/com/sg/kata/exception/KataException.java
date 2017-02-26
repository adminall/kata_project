package com.sg.kata.exception;

/**
 * New Exception Object for KATA Application.
 *
 * @author Yassine.Mejri
 *
 */
public class KataException extends Exception
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public KataException()
	{
		super();
	}

	public KataException(final String message)
	{
		super(message);
	}

	public KataException(final Throwable throwable)
	{
		super(throwable);
	}

}
