package com.sg.kata.rule.engine;

import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;


/**
 *
 * @author Yassine.Mejri
 *
 */
public interface RuleEngine
{
	void applyRule(Match match, Player player) throws KataException;
}
