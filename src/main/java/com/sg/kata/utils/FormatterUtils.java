package com.sg.kata.utils;

import com.sg.kata.model.Match;
import com.sg.kata.model.Set;


/**
 * Class Utilities.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class FormatterUtils
{

	/**
	 * This method print the global result of match.
	 *
	 * @param match
	 */
	public static void printGlobalResult(final Match match)
	{

		final StringBuilder message = new StringBuilder();

		message.append("Player 1 VS Player 2 \n");
		message.append("Games : " + match.getPlayerOne().getScoreSet() + " - " + match.getPlayerTwo().getScoreSet() + "\n");

		for (final Set set : match.getSets())
		{
			message.append("Set " + set.getOrder() + " : " + set.getScorePlayerOne() + " - " + set.getScorePlayerTwo());
			if (set.isFinished())
			{
				message.append(
						" , Winner Set : " + set.getWinner().getName() + " , rule activated = " + match.getCurrentRule() + "\n");
			}
			else
			{
				message.append(" , rule activated = " + match.getCurrentRule() + "\n");
			}
		}

		if (match.isFinished())
		{
			message.append(" The match is finished and the winner is " + match.getMatchWinner().getName() + " ! \n");
		}

		System.out.println(message.toString());
	}

	/**
	 * Convert String to integer.
	 *
	 * @param answer
	 * @return
	 * @throws NumberFormatException
	 */
	public static int toInteger(final String answer) throws NumberFormatException
	{
		return Integer.parseInt(answer);
	}

}
