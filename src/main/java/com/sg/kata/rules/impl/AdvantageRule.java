package com.sg.kata.rules.impl;

import org.apache.log4j.Logger;

import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;
import com.sg.kata.model.Set;
import com.sg.kata.rules.Rule;


/**
 * This rule check / apply an advantage for the player.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class AdvantageRule implements Rule
{
	public static final Logger LOG = Logger.getLogger(AdvantageRule.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void apply(final Match match, final Player player) throws KataException
	{
		if (match == null || player == null)
		{
			throw new KataException("Player or match is empty.");
		}

		if (!match.isFinished())
		{
			final Set lastSet = match.getSets().last();
			if (lastSet.getScorePlayerOne() != 6
					|| lastSet.getScorePlayerTwo() != 6 && !match.getCurrentRule().equals(RuleName.TIE_BREAK))
			{
				if (match.getCurrentRule().equals(RuleName.DEUCE))
				{
					if (player.equals(match.getPlayerOne()))
					{
						if (!player.isAdvantage())
						{
							if (match.getPlayerTwo().isAdvantage())
							{
								match.getPlayerOne().setAdvantage(false);
								match.getPlayerTwo().setAdvantage(false);
							}
							else
							{
								player.setAdvantage(true);
							}
						}
						else
						{
							if (match.getPlayerTwo().isAdvantage())
							{
								match.getPlayerOne().setAdvantage(false);
								match.getPlayerTwo().setAdvantage(false);
							}
							else
							{
								if (match.getPlayerOne().equals(player))
								{
									lastSet.incrementScorePlayerOne();
								}
								else
								{
									lastSet.incrementScorePlayerTwo();
								}

								match.checkSet();
								resetCounters(match);
							}
						}
					}
					else if (player.equals(match.getPlayerTwo()))
					{
						if (!player.isAdvantage())
						{
							if (match.getPlayerOne().isAdvantage())
							{
								match.getPlayerOne().setAdvantage(false);
								match.getPlayerTwo().setAdvantage(false);
							}
							else
							{
								player.setAdvantage(true);
							}
						}
						else
						{
							if (match.getPlayerOne().isAdvantage())
							{
								match.getPlayerOne().setAdvantage(false);
								match.getPlayerTwo().setAdvantage(false);
							}
							else
							{
								if (match.getPlayerOne().equals(player))
								{
									lastSet.incrementScorePlayerOne();
								}
								else
								{
									lastSet.incrementScorePlayerTwo();
								}
								match.checkSet();
								resetCounters(match);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Rest all scores counters.
	 *
	 * @param match
	 */
	private void resetCounters(final Match match)
	{
		match.getPlayerOne().resetScoreSet();
		match.getPlayerTwo().resetScoreSet();
		match.getPlayerOne().setAdvantage(Boolean.FALSE);
		match.getPlayerTwo().setAdvantage(Boolean.FALSE);
		match.setCurrentRule(RuleName.NEW);
	}
}
