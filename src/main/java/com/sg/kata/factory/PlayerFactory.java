package com.sg.kata.factory;

/**
 *
 * @author Yassine.Mejri
 *
 * @param <T>
 */
public interface PlayerFactory<T, R>
{

	T createPlayer(R playerName);

}
