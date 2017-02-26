package com.sg.kata.enums;

/**
 * The default players are [PLAYER_ONE Or PLAYER_TWO].
 *
 * @author Yassine.Mejri
 *
 */
public enum PlayerName
{

	PLAYER_ONE("Player One"), PLAYER_TWO("Player Two");

	private final String name;

	private PlayerName(final String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
