package com.sg.kata.rules;

import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;


/**
 * Rule Interface.
 *
 * @author Yassine.Mejri
 * @version 0.1
 */
public interface Rule
{
	/**
	 * Apply the rule.
	 *
	 *
	 * @param match
	 * @param player
	 * @throws KataException
	 */
	void apply(Match match, Player player) throws KataException;
}
