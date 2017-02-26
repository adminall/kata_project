/**
 *
 */
package com.sg.kata.model;

import com.sg.kata.exception.KataException;


/**
 * 
 * This Class represent a {@link Player}
 * 
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class Player
{

	private String name;
	private int lastScoreSet = 0;
	private boolean advantage = false;

	/**
	 * Default Constructor
	 */
	public Player()
	{

	}

	/**
	 *
	 * @param Player
	 *           name
	 */
	public Player(final String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * @param {@link
	 * 			 Match}
	 * @throws KataException
	 */
	public void addPoint(final Match match) throws KataException
	{
		match.addPointForPlayer(this);
	}

	/**
	 * Increment the game score
	 */
	public void incrementScoreSet()
	{
		if (lastScoreSet == 30)
		{
			lastScoreSet = 40;
		}
		else
		{
			lastScoreSet += 15;
		}
	}

	/**
	 * reset the game score.
	 */
	public void resetScoreSet()
	{
		lastScoreSet = 0;
	}

	/**
	 * 
	 * @return the name of the {@link Player}
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 
	 * @param the
	 *           name of the {@link player}
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * @return player advantage or not
	 * 
	 */
	public boolean isAdvantage()
	{
		return advantage;
	}

	/**
	 * 
	 * @param set
	 *           advantage to player
	 * 
	 */
	public void setAdvantage(final boolean advantage)
	{
		this.advantage = advantage;
	}

	/**
	 * 
	 * @return get the set score
	 * 
	 */
	public int getScoreSet()
	{
		return lastScoreSet;
	}

	/**
	 * 
	 * @param set
	 *           the score set.
	 * 
	 */
	public void setScoreSet(final int scoreSet)
	{
		lastScoreSet = scoreSet;
	}

	@Override
	public String toString()
	{
		return "I am " + name + " and my current score is " + lastScoreSet;
	}

}