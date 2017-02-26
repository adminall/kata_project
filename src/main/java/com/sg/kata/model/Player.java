/**
 *
 */
package com.sg.kata.model;

import com.sg.kata.exception.KataException;


/**
 * @author Yassine.Mejri
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
	 * @param name
	 */
	public Player(final String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * @param match
	 * @throws KataException
	 */
	public void addPoint(final Match match) throws KataException
	{
		match.addPointForPlayer(this);
	}

	/**
	 * 
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
	 * 
	 */
	public void resetScoreSet()
	{
		lastScoreSet = 0;
	}

	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAdvantage()
	{
		return advantage;
	}

	/**
	 * 
	 * @param advantage
	 */
	public void setAdvantage(final boolean advantage)
	{
		this.advantage = advantage;
	}

	/**
	 * 
	 * @return
	 */
	public int getScoreSet()
	{
		return lastScoreSet;
	}

	/**
	 * 
	 * @param scoreSet
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
