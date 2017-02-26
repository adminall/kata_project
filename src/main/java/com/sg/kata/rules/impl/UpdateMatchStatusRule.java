package com.sg.kata.rules.impl;

import org.apache.log4j.Logger;

import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;
import com.sg.kata.rules.Rule;


/**
 * This rule update the match status {NEW, DEUCE, TIE_BREAK}
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class UpdateMatchStatusRule implements Rule
{
	public static final Logger LOG = Logger.getLogger(UpdateMatchStatusRule.class);

	@Override
	public void apply(final Match match, final Player player) throws KataException
	{

		if (match.getPlayerOne().getScoreSet() == 40 && match.getPlayerTwo().getScoreSet() == 40)
		{
			match.setCurrentRule(RuleName.DEUCE);
		}
		else if (match.getCurrentRule().equals(RuleName.TIE_BREAK)
				|| match.getSets().last().getScorePlayerOne() == 6 && match.getSets().last().getScorePlayerTwo() == 6)
		{
			match.setCurrentRule(RuleName.TIE_BREAK);
			match.getPlayerOne().resetScoreSet();
			match.getPlayerTwo().resetScoreSet();
		}
		else
		{
			match.setCurrentRule(RuleName.NEW);
		}

	}

}
