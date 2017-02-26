package com.sg.kata.rule.engine;

import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;


/**
 * This interface is an abstract Rule.
 *
 * @author Yassine.Mejri
 *
 */
public interface RuleEngine
{
	/**
	 * Apply rule to the current match and player.
	 * 
	 * @param {@link
	 * 			 Match}
	 * @param {@link
	 * 			 Player}
	 * @throws KataException
	 */
	void applyRule(Match match, Player player) throws KataException;
}
