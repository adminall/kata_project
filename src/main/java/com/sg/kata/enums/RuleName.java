/**
 * 
 */
package com.sg.kata.enums;

import com.sg.kata.model.Match;


/**
 * This Enumeration is by {@link Match} to control the status of the Match :
 * 
 * <pre>
 * DEUCE = DEUCE Match
 * ADVANTAGE = Advantage Player
 * TIE_BREAK = Tie Break
 * New = is the default status
 * </pre>
 * 
 * @author Yassine.Mejri
 * @version 0.1
 *
 */
public enum RuleName
{
	NEW, DEUCE, ADVANTAGE, TIE_BREAK
}
