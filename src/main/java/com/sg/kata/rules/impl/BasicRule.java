package com.sg.kata.rules.impl;

import org.apache.log4j.Logger;

import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;
import com.sg.kata.rules.Rule;


/**
 * This rule increment the score set for the player.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class BasicRule implements Rule
{

	public static final Logger LOG = Logger.getLogger(BasicRule.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void apply(final Match match, final Player player) throws KataException
	{

		if (match.getCurrentRule().equals(RuleName.DEUCE) || match.getCurrentRule().equals(RuleName.TIE_BREAK))
		{
			return;
		}

		final int lastPoint = player.getScoreSet();
		switch (lastPoint)
		{
			case 0:
				player.incrementScoreSet();
				break;
			case 15:
				player.incrementScoreSet();
				break;
			case 30:
				player.incrementScoreSet();
				break;
			case 40:
				if (player.equals(match.getPlayerOne()))
				{
					match.getSets().last().incrementScorePlayerOne();
				}
				else
				{
					match.getSets().last().incrementScorePlayerTwo();
				}

				player.resetScoreSet();
				match.checkSet();
				break;

			default:
				break;
		}
	}
}
