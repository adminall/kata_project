/**
 * 
 */
package com.sg.kata.factory;

import com.sg.kata.model.Player;


/**
 * This Interface must be used by the factory implementation.
 * 
 * @author Yassine.Mejri
 * @version 0.1
 *
 * @param <T>
 * @param <R>
 */
public interface PlayerFactory<T, R>
{

	/**
	 * Create a new {@link Player}
	 * 
	 * @param R
	 * @return T
	 */
	T createPlayer(R playerName);

}
