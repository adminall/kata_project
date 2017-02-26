package com.sg.kata.rules.impl;

import org.apache.log4j.Logger;

import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;
import com.sg.kata.rules.Rule;


/**
 * This rule check and apply an Tie Break for the player.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class TieBreakRule implements Rule
{
	public static final Logger LOG = Logger.getLogger(TieBreakRule.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void apply(final Match match, final Player player) throws KataException
	{
		if (match.getCurrentRule().equals(RuleName.TIE_BREAK))
		{
			if (match.getPlayerOne().equals(player))
			{
				match.getSets().last().incrementScorePlayerOne();
			}
			else
			{
				match.getSets().last().incrementScorePlayerTwo();
			}
			match.checkSet();
		}
	}

}
