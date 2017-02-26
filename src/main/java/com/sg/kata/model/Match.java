/**
 * 
 */
package com.sg.kata.model;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.sg.kata.enums.PlayerName;
import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.factory.PlayerFactory;
import com.sg.kata.factory.impl.PlayerFactoryImpl;
import com.sg.kata.rule.engine.RuleEngine;
import com.sg.kata.rule.engine.RuleEngineImpl;
import com.sg.kata.utils.FormatterUtils;


/**
 * This class create a new {@link Match}.
 *
 * @author Yassine.Mejri
 * @version 0.1
 */
public class Match
{

	public static final Logger LOG = Logger.getLogger(Match.class);
	/** **/
	private Player playerOne;
	private Player playerTwo;
	private boolean finished;
	private SortedSet<Set> sets = new TreeSet<Set>();
	private RuleName currentRule = RuleName.NEW;
	private Player matchWinner;

	PlayerFactory<Player, PlayerName> playerFactory = new PlayerFactoryImpl();
	RuleEngine ruleEngine = new RuleEngineImpl();

	/**
	 * Default Constructor
	 */
	public Match()
	{

		playerOne = playerFactory.createPlayer(PlayerName.PLAYER_ONE);
		playerTwo = playerFactory.createPlayer(PlayerName.PLAYER_TWO);
		finished = Boolean.FALSE;
		sets.add(new Set(0));

	}

	/**
	 * This Method run the application.
	 *
	 * @throws KataException
	 */
	@SuppressWarnings("resource")
	public void run() throws KataException
	{
		LOG.info("Start new match [ " + playerOne.getName() + " VS " + playerTwo.getName() + "].");
		final Scanner scanner = new Scanner(System.in);

		while (!finished)
		{
			System.out.print(" Tape 1 to mark one point to player one / Tape 2 to mark one point to player one : ");
			final String answer = scanner.next();
			System.out.print(" Your answer is : " + answer.trim().toLowerCase());

			final int answerInt = FormatterUtils.toInteger(answer);
			switch (answerInt)
			{
				case 1:
					addPointForPlayer(playerOne);
					break;
				case 2:
					addPointForPlayer(playerTwo);
					break;

				default:
					break;
			}

			FormatterUtils.printGlobalResult(this);
		}

		if (finished)
		{
			System.out.print(" Good By ! ");
		}

	}

	/**
	 * Mark a point for the player giving in parameter.
	 *
	 * @param {@link
	 * 			 Player}
	 * @throws KataException
	 * 
	 */
	public void addPointForPlayer(final Player player) throws KataException
	{

		if (finished || null == player)
		{
			throw new KataException(
					"An error has been occured, please check if the current match is finishid or the player parameter is empty [ "
							+ player + "].");
		}

		ruleEngine.applyRule(this, player);

		FormatterUtils.printGlobalResult(this);
	}

	/**
	 * Check if the set has finished.
	 */
	public void checkSet()
	{
		final Player winner = getSetWinner();
		if (winner != null)
		{
			getSets().last().setFinished(true);
			getSets().last().setWinner(winner);

			int setwinsPlayerOne = 0;
			int setwinsPlayerTwo = 0;
			for (final Set set : sets)
			{

				if (!set.isFinished())
				{
					return;
				}
				if (set.getWinner().equals(this.getPlayerOne()))
				{
					setwinsPlayerOne += 1;
				}
				else
				{
					setwinsPlayerTwo += 1;
				}
			}

			if (setwinsPlayerOne - setwinsPlayerTwo >= 2)
			{
				this.setFinished(Boolean.TRUE);
				this.setMatchWinner(winner);
			}

			if (setwinsPlayerTwo - setwinsPlayerOne >= 2)
			{
				this.setFinished(Boolean.TRUE);
				this.setMatchWinner(winner);
			}

			if (!finished)
			{
				this.setCurrentRule(RuleName.NEW);
				final int index = getSets().size();
				getSets().add(new Set(index));
			}
		}
	}

	/**
	 * Get the set winner.
	 *
	 * @return {@link Player}
	 * 
	 */
	public Player getSetWinner()
	{

		final Set set = getSets().last();

		Player result = null;
		if (!getCurrentRule().equals(RuleName.TIE_BREAK))
		{
			if (set.getScorePlayerOne() == 7
					|| set.getScorePlayerOne() == 6 && set.getScorePlayerOne() - set.getScorePlayerTwo() >= 2)
			{
				result = playerOne;
			}
			else if (set.getScorePlayerTwo() == 7
					|| (set.getScorePlayerTwo() == 6 && set.getScorePlayerTwo() - set.getScorePlayerOne() >= 2))
			{
				result = playerTwo;
			}
		}
		else
		{
			if (set.getScorePlayerOne() >= 6 && set.getScorePlayerTwo() >= 6)
			{
				if (set.getScorePlayerOne() - set.getScorePlayerTwo() >= 2)
				{
					result = playerOne;
				}
				else if (set.getScorePlayerTwo() - set.getScorePlayerOne() >= 2)
				{
					result = playerTwo;
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @return Player
	 */
	public Player getPlayerOne()
	{
		return playerOne;
	}

	/**
	 * 
	 * @return Player
	 */
	public Player getPlayerTwo()
	{
		return playerTwo;
	}

	/**
	 * 
	 * @return SortedSet<Set>
	 * 
	 */
	public SortedSet<Set> getSets()
	{
		return sets;
	}

	/**
	 * 
	 * @param {@link
	 * 			 Player}
	 */
	public void setPlayerOne(final Player playerOne)
	{
		this.playerOne = playerOne;
	}

	/**
	 * 
	 * @param {@link
	 * 			 Player}
	 */
	public void setPlayerTwo(final Player playerTwo)
	{
		this.playerTwo = playerTwo;
	}

	/**
	 * 
	 * @param SortedSet<Set>
	 */
	public void setSets(final SortedSet<Set> sets)
	{
		this.sets = sets;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isFinished()
	{
		return finished;
	}

	/**
	 * 
	 * @param boolean
	 */
	public void setFinished(final boolean finished)
	{
		this.finished = finished;
	}

	/**
	 * 
	 * @return {@link RuleName}
	 */
	public RuleName getCurrentRule()
	{
		return currentRule;
	}

	public void setCurrentRule(final RuleName currentRule)
	{
		this.currentRule = currentRule;
	}

	/**
	 * 
	 * @return {@link Player}
	 * 
	 */
	public Player getMatchWinner()
	{
		return matchWinner;
	}

	/**
	 * 
	 * @param {@linkPlayer}
	 * 
	 */
	public void setMatchWinner(final Player matchWinner)
	{
		this.matchWinner = matchWinner;
	}

}
