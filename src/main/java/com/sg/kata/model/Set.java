package com.sg.kata.model;

/**
 * Set
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

	public Set(final int order)
	{
		this.order = order;
	}

	public void incrementScorePlayerOne()
	{
		scorePlayerOne++;
	}

	public void incrementScorePlayerTwo()
	{
		scorePlayerTwo++;
	}

	public void closeSet()
	{
		finished = Boolean.TRUE;
	}

	public boolean isFinished()
	{
		return finished;
	}

	public void setFinished(final boolean finished)
	{
		this.finished = finished;
	}

	public int getOrder()
	{
		return order;
	}

	public void setOrder(final int order)
	{
		this.order = order;
	}

	public int getScorePlayerOne()
	{
		return scorePlayerOne;
	}

	public int getScorePlayerTwo()
	{
		return scorePlayerTwo;
	}

	public void setScorePlayerOne(final int scorePlayerOne)
	{
		this.scorePlayerOne = scorePlayerOne;
	}

	public void setScorePlayerTwo(final int scorePlayerTwo)
	{
		this.scorePlayerTwo = scorePlayerTwo;
	}

	public Player getWinner()
	{
		return winner;
	}

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
		if (order == ((Set) o).order)
		{
			return 0;
		}
		else if (order > ((Set) o).order)
		{
			return 1;
		}
		return -1;
	}

}
