package com.sg.kata.enums;

/**
 * This Enumeration is used by @{link Player}
 *
 * @author Yassine.Mejri
 * @version 0.1
 * 
 */
public enum PlayerName
{

	PLAYER_ONE("Player One"), PLAYER_TWO("Player Two");
	private final String name;

	/**
	 * 
	 * @param name
	 */
	private PlayerName(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
