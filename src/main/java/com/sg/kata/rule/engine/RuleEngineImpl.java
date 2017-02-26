package com.sg.kata.rule.engine;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sg.kata.enums.RuleName;
import com.sg.kata.exception.KataException;
import com.sg.kata.model.Match;
import com.sg.kata.model.Player;
import com.sg.kata.rules.Rule;
import com.sg.kata.rules.impl.AdvantageRule;
import com.sg.kata.rules.impl.BasicRule;
import com.sg.kata.rules.impl.TieBreakRule;
import com.sg.kata.rules.impl.UpdateMatchStatusRule;


/**
 * This Class apply a list of rules.
 *
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public class RuleEngineImpl implements RuleEngine
{
	public final static Logger LOG = Logger.getLogger(RuleEngineImpl.class);

	Map<RuleName, Rule> rules = new HashMap<RuleName, Rule>();
	Rule updateMatchStatusRule = new UpdateMatchStatusRule();

	/**
	 * Default Constructor
	 */
	public RuleEngineImpl()
	{
		rules.put(RuleName.ADVANTAGE, new AdvantageRule());
		rules.put(RuleName.DEUCE, new BasicRule());
		rules.put(RuleName.TIE_BREAK, new TieBreakRule());
	}

	/**
	 * Apply rule for match and player.
	 *
	 * @param Match
	 * @param Player
	 * @throws KataException
	 *
	 */
	@Override
	public void applyRule(final Match match, final Player player) throws KataException
	{

		rules.keySet().stream().forEach(ruleName -> {
			try
			{
				rules.get(ruleName).apply(match, player);
			}
			catch (final KataException e)
			{
				LOG.error(e);
			}
		});

		// The final rule to update match status
		updateMatchStatusRule.apply(match, player);
	}
}
