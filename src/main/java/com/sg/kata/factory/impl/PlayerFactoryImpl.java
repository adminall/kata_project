package com.sg.kata.factory.impl;

import com.sg.kata.enums.PlayerName;
import com.sg.kata.factory.PlayerFactory;
import com.sg.kata.model.Player;


/**
 * This Factory have a responsibility to create all Players.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class PlayerFactoryImpl implements PlayerFactory<Player, PlayerName>
{

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public Player createPlayer(final PlayerName playerName)
	{
		return new Player(playerName.getName());
	}

}
