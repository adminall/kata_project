package com.sg.kata.model;

/**
 * This Class represent the Set.
 *
 * @author Yassine.Mejri
 *
 */
@SuppressWarnings("rawtypes")
public class Set implements Comparable
{
	private int order;
	private int scorePlayerOne = 0;
	private int scorePlayerTwo = 0;
	private Player winner;
	private boolean finished = Boolean.FALSE;

	/**
	 * Default Constructor
	 */
	public Set()
	{

	}

	/**
	 * 
	 * @param order
	 */
	public Set(final int order)
	{
		this.order = order;
	}

	/**
	 * 
	 */
	public void incrementScorePlayerOne()
	{
		scorePlayerOne++;
	}

	/**
	 * 
	 */
	public void incrementScorePlayerTwo()
	{
		scorePlayerTwo++;
	}

	/**
	 * 
	 */
	public void closeSet()
	{
		finished = Boolean.TRUE;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isFinished()
	{
		return finished;
	}

	/**
	 * 
	 * @param finished
	 */
	public void setFinished(final boolean finished)
	{
		this.finished = finished;
	}

	/**
	 * 
	 * @return
	 */
	public int getOrder()
	{
		return order;
	}

	/**
	 * 
	 * @param order
	 */
	public void setOrder(final int order)
	{
		this.order = order;
	}

	/**
	 * 
	 * @return
	 */
	public int getScorePlayerOne()
	{
		return scorePlayerOne;
	}

	/**
	 * 
	 * @return
	 */
	public int getScorePlayerTwo()
	{
		return scorePlayerTwo;
	}

	/**
	 * 
	 * @param scorePlayerOne
	 */
	public void setScorePlayerOne(final int scorePlayerOne)
	{
		this.scorePlayerOne = scorePlayerOne;
	}

	/**
	 * 
	 * @param scorePlayerTwo
	 */
	public void setScorePlayerTwo(final int scorePlayerTwo)
	{
		this.scorePlayerTwo = scorePlayerTwo;
	}

	/**
	 * 
	 * @return
	 */
	public Player getWinner()
	{
		return winner;
	}

	/**
	 * 
	 * @param winner
	 */
	public void setWinner(final Player winner)
	{
		this.winner = winner;
	}

	@Override
	public String toString()
	{
		return "Set [scorePlayerOne = " + scorePlayerOne + ",scorePlayerTwo = " + scorePlayerTwo + "].";
	}

	@Override
	public int compareTo(final Object o)
	{
		if (this.order == ((Set) o).order)
		{
			return 0;
		}
		else if (this.order > ((Set) o).order)
		{
			return 1;
		}
		return -1;
	}

}
